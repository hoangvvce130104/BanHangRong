package com.example.banhangrong.Class;

public class FoodType {
    //declare variable
    private int foodTypeID;
    private String foodTypeName;
    private int status;
    //constructor null
    public FoodType() {
    }
    //constructor hasn't id type food

    public FoodType(String foodTypeName, int status) {
        this.foodTypeName = foodTypeName;
        this.status = status;
    }
    //constructor full

    public FoodType(int foodTypeID, String foodTypeName, int status) {
        this.foodTypeID = foodTypeID;
        this.foodTypeName = foodTypeName;
        this.status = status;
    }
    //getter setter all variables

    public int getFoodTypeID() {
        return foodTypeID;
    }

    public void setFoodTypeID(int foodTypeID) {
        this.foodTypeID = foodTypeID;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
