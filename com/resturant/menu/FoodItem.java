package com.resturant.menu;

public class FoodItem extends MenuItem{

    private String category;
    private String description;

    public FoodItem(String name, double price, String category, String description) {
        super(name, price);
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(String category){
        this.category = category;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

}
