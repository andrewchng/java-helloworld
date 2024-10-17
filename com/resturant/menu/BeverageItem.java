package com.resturant.menu;

public class BeverageItem extends MenuItem {
    private boolean isAlcholic;

    public BeverageItem(String name, double price, boolean isAlcholic) {
        super(name, price);
        this.isAlcholic = isAlcholic;
    }
    
    public boolean isAlcholic() {
        return isAlcholic;
    }

    public void setIsAlcholic(boolean isAlcholic) {
        this.isAlcholic = isAlcholic;
    }
}
