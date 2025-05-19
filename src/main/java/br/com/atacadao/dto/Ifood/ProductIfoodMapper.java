package br.com.atacadao.dto.Ifood;

import br.com.atacadao.dto.*;

import java.math.BigDecimal;
import java.util.Collections;

public class ProductIfoodMapper {
    public static ProductIfoodDTO toIfood(ProductDTO dto) {
        return new ProductIfoodDTO(
                dto.getEan(),
                dto.getNomeProduto(),
                dto.getPlu(),
                dto.getAtivo() != null ? dto.getAtivo() : true,
                new InventoryDTO(dto.getEstoqueEmbalagem1() != null ? dto.getEstoqueEmbalagem1() : 0),
                new DetailsDTO(
                        new CategorizationDTO(
                                dto.getNomeDepartamento(),
                                dto.getNomeCategoria(),
                                null
                        ),
                        dto.getNomeMarca(),
                        dto.getUnidadeProduto(),
                        dto.getVolume() != null ? dto.getVolume().toPlainString() : "",
                        dto.getUrlImagem() != null ? dto.getUrlImagem() : "",
                        dto.getDescricaoProduto(),
                        false,
                        null
                ),
                new PricesDTO(dto.getPreco() != null ? dto.getPreco() : BigDecimal.ZERO),
                null,
                Collections.singletonList("ifood-app")
        );
    }
}

