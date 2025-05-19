package br.com.atacadao.dto;

public class CategorizationDTO {
    private String department;
    private String category;
    private String subCategory;

    public CategorizationDTO() {}

    public CategorizationDTO(String department, String category, String subCategory) {
        this.department = department;
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
