package br.com.atacadao.dto;

public class DetailsDTO {
    private CategorizationDTO categorization;
    private String brand;
    private String unit;
    private String volume;
    private String imageUrl;
    private String description;
    private boolean nearExpiration;
    private String family;

    public DetailsDTO() {}

    public DetailsDTO(CategorizationDTO categorization, String brand, String unit, String volume,
                      String imageUrl, String description, boolean nearExpiration, String family) {
        this.categorization = categorization;
        this.brand = brand;
        this.unit = unit;
        this.volume = volume;
        this.imageUrl = imageUrl;
        this.description = description;
        this.nearExpiration = nearExpiration;
        this.family = family;
    }

    public CategorizationDTO getCategorization() {
        return categorization;
    }

    public void setCategorization(CategorizationDTO categorization) {
        this.categorization = categorization;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNearExpiration() {
        return nearExpiration;
    }

    public void setNearExpiration(boolean nearExpiration) {
        this.nearExpiration = nearExpiration;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
