package com.example.finalproject;

public class Food {
    private String itemName;
    private String itemDescription;
    private String itemTime;
    private String itemImage;

    public Food(String itemName, String itemDescription, String itemTime, String itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemTime = itemTime;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemTime() {
        return itemTime;
    }

    public void setItemTime(String itemTime) {
        this.itemTime = itemTime;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public void food(){

    }
}
