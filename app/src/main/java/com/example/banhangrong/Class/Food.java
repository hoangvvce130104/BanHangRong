package com.example.banhangrong.Class;

public class Food {
    //declare variable
    private int foodId;
    private String foodName;
    private int sellID;
    private int typeID;
    private float price;
    private int number;
    private String description;
    private int status;

    //null constructor
    public Food() {
    }
    // constructor hasn't id food
    public Food(String foodName, int sellID, int typeID, float price, int number, String description, int status) {
        this.foodName = foodName;
        this.sellID = sellID;
        this.typeID = typeID;
        this.price = price;
        this.number = number;
        this.description = description;
        this.status = status;
    }

    // constructor full
    public Food(int foodId, String foodName, int sellID, int typeID, float price, int number, String description, int status) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.sellID = sellID;
        this.typeID = typeID;
        this.price = price;
        this.number = number;
        this.description = description;
        this.status = status;
    }

    //getter setter all variable
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getSellID() {
        return sellID;
    }

    public void setSellID(int sellID) {
        this.sellID = sellID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
