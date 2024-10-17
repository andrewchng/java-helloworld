package com.resturant.menu;

import java.util.List;

public class ComboItem extends MenuItem{
    private List<MenuItem> comboItems;

    public ComboItem(String name, double price) {
        super(name, price);
    }

    public void addComboItem(MenuItem item){
        this.comboItems.add(item);
    }

    public void removeComboItem(MenuItem item){
        this.comboItems.remove(item);
    }
    
    public List<MenuItem> getComboItems(){
        return this.comboItems;
    }   

}
