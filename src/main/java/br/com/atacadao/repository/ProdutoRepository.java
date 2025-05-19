package br.com.atacadao.repository;

import br.com.atacadao.dto.ProductDTO;
import jakarta.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProdutoRepository  {

    private final DataSource dataSource;

    public ProdutoRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<ProductDTO> buscarProdutosPorFilial(Long filialId) throws SQLException {
        String sql = """
            select
                ts.ean,
                tp.nome as nome_produto,
                tm.nome as nome_marca,
                categoria.nome as nome_categoria,
                departamento.nome as nome_departamento,
                tp.descricao as descricao_produto,
                ts.complemento as unidade_produto,
                tsa.estoque_embalagem1,
                tsa.codigo_sku as plu,
                tsa.id_filial,
                tsa.ativo,
                ti.url,
                (ts.altura * ts.largura * ts.comprimento) as volume,
                ROUND(cast(tsa.json->'preco'->'fixos'->0->>'precoLista' as numeric), 2) as preco
            from
                tb_sku_app tsa
            join tb_sku ts on
                tsa.codigo_sku::VARCHAR = ts.id_sku
            join tb_produto tp on
                tp.ean = ts.ean
            left join tb_imagem ti on
                ti.produto_id = ts.id_produto and ti.tamanho = 'G'
            left join tb_marca tm on
                tm.id = tp.marca_id
            left join tb_categoria categoria on
                categoria.id = tp.categoria_id
            left join tb_categoria departamento on
                departamento.id = categoria.categoria_pai_id
            where tsa.id_filial = ?
                and tsa.ativo = true
                and tsa.estoque_embalagem1 > 0
                and tsa.grupo_mercadoria not in (13, 19)
                and tsa.sub_grupo_mercadoria != 4
                and ts.id_produto > 1000
                and cast(coalesce(tsa.json->>'pesoVariavel', 'false') as boolean) = false
                and coalesce(status_mercadoria, ' ') not in ('ZZ', 'FL', 'NC')
                and tsa.descricao_mercadoria not like 'PA.%'
                and tsa.descricao_mercadoria not like 'AC.%'
                and tsa.descricao_mercadoria not like 'FR.%'
                and tsa.descricao_mercadoria not like 'HF%'
                and tsa.descricao_mercadoria not like 'RF%'
                and tsa.data_atualizacao >= current_date - 5
        """;

        List<ProductDTO> produtos = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, filialId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    produtos.add(new ProductDTO(
                            rs.getString("ean"),
                            rs.getString("nome_produto"),
                            rs.getString("nome_marca"),
                            rs.getString("nome_categoria"),
                            rs.getString("nome_departamento"),
                            rs.getString("descricao_produto"),
                            rs.getString("unidade_produto"),
                            rs.getInt("estoque_embalagem1"),
                            rs.getString("plu"),
                            rs.getLong("id_filial"),
                            rs.getBoolean("ativo"),
                            rs.getString("url"),
                            rs.getBigDecimal("volume"),
                            rs.getBigDecimal("preco")
                    ));
                }
            }
        }

        produtos.add(produtos.get(5));



        return produtos;
    }
}