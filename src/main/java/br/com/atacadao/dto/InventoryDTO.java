package br.com.atacadao.dto;

public class InventoryDTO {
    private int stock;

    public InventoryDTO() {}

    public InventoryDTO(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
