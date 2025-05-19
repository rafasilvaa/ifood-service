package br.com.atacadao.dto;

import java.math.BigDecimal;

public class ProductDTO {
    public String ean;
    public String nomeProduto;
    public String nomeMarca;
    public String nomeCategoria;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public Integer getEstoqueEmbalagem1() {
        return estoqueEmbalagem1;
    }

    public void setEstoqueEmbalagem1(Integer estoqueEmbalagem1) {
        this.estoqueEmbalagem1 = estoqueEmbalagem1;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public Long getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(Long idFilial) {
        this.idFilial = idFilial;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String nomeDepartamento;
    public String descricaoProduto;
    public String unidadeProduto;
    public Integer estoqueEmbalagem1;
    public String plu;
    public Long idFilial;
    public Boolean ativo;
    public String urlImagem;
    public BigDecimal volume;
    public BigDecimal preco;

    // Construtor usado no mapeamento
    public ProductDTO(String ean, String nomeProduto, String nomeMarca, String nomeCategoria,
                           String nomeDepartamento, String descricaoProduto, String unidadeProduto,
                           Integer estoqueEmbalagem1, String plu, Long idFilial, Boolean ativo,
                           String urlImagem, BigDecimal volume, BigDecimal preco) {
        this.ean = ean;
        this.nomeProduto = nomeProduto;
        this.nomeMarca = nomeMarca;
        this.nomeCategoria = nomeCategoria;
        this.nomeDepartamento = nomeDepartamento;
        this.descricaoProduto = descricaoProduto;
        this.unidadeProduto = unidadeProduto;
        this.estoqueEmbalagem1 = estoqueEmbalagem1;
        this.plu = plu;
        this.idFilial = idFilial;
        this.ativo = ativo;
        this.urlImagem = urlImagem;
        this.volume = volume;
        this.preco = preco;
    }
}

