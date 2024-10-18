package com.resturant.menu;

import java.util.ArrayList;

public class ComboItem extends MenuItem{
    private final ArrayList<MenuItem> comboItems;

    public ComboItem(String name, double price) {
        super(name, price);
        this.comboItems = new ArrayList<>();
    }

    public void addComboItem(MenuItem item){
        this.comboItems.add(item);
    }

    public void removeComboItem(MenuItem item){
        this.comboItems.remove(item);
    }
    
    public ArrayList<MenuItem> getComboItems(){
        return this.comboItems;
    }   

}
