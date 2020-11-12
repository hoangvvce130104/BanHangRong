package com.example.banhangrong.Class;

public class BillDetail {
    //declare variables
    private int billDetailID;
    private int billID;
    private int foodID;
    private int amount;
    private String description;
    //constructor null
    public BillDetail() {
    }
    //constructor hasn't id bill detail
    public BillDetail(int billID, int foodID, int amount, String description) {
        this.billID = billID;
        this.foodID = foodID;
        this.amount = amount;
        this.description = description;
    }
    //constructor full
    public BillDetail(int billDetailID, int billID, int foodID, int amount, String description) {
        this.billDetailID = billDetailID;
        this.billID = billID;
        this.foodID = foodID;
        this.amount = amount;
        this.description = description;
    }
    //getter setter
    public int getBillDetailID() {
        return billDetailID;
    }

    public void setBillDetailID(int billDetailID) {
        this.billDetailID = billDetailID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
