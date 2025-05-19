package br.com.atacadao.dto.Ifood;

import br.com.atacadao.dto.DetailsDTO;
import br.com.atacadao.dto.InventoryDTO;
import br.com.atacadao.dto.PricesDTO;

import java.util.List;

public class ProductIfoodDTO {
    private String barcode;
    private String name;
    private String plu;
    private Boolean active;
    private InventoryDTO inventory;
    private DetailsDTO details;
    private PricesDTO prices;
    private Integer multiple;
    private List<String> channels;

    public ProductIfoodDTO() {} // Construtor vazio necessário para o Jackson

    public ProductIfoodDTO(String barcode, String name, String plu, Boolean active, 
                         InventoryDTO inventory, DetailsDTO details, PricesDTO prices, 
                         Integer multiple, List<String> channels) {
        this.barcode = barcode;
        this.name = name;
        this.plu = plu;
        this.active = active;
        this.inventory = inventory;
        this.details = details;
        this.prices = prices;
        this.multiple = multiple;
        this.channels = channels;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public InventoryDTO getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDTO inventory) {
        this.inventory = inventory;
    }

    public DetailsDTO getDetails() {
        return details;
    }

    public void setDetails(DetailsDTO details) {
        this.details = details;
    }

    public PricesDTO getPrices() {
        return prices;
    }

    public void setPrices(PricesDTO prices) {
        this.prices = prices;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
}
