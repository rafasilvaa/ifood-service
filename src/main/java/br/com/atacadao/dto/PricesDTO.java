package br.com.atacadao.dto;


import java.math.BigDecimal;

public class PricesDTO {
    private BigDecimal price;

    public PricesDTO() {}

    public PricesDTO(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
