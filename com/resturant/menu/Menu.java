package com.resturant.menu;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        this.items.add(item);
    }

    public void removeItem(MenuItem item){
        this.items.remove(item);
    }

    public ArrayList<MenuItem> getItems(){
        return this.items;
    }

    public MenuItem getItemByName(String name) {
        for(MenuItem item : items){
            if (item.getName().equals(name)) {
                return item;
            }   
        }
        return null;
    }

    public MenuItem getItemByIndex(int index) {
       return this.items.get(index);
    }

    public String printMenu(){
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (MenuItem item : this.items) {
            sb.append(index).append(". ").append(item.getName()).append(": $").append(item.getPrice()).append("\n");
            index++;
        }
        return sb.toString();
    }
    
}
