package com.example.banhangrong.Class;

public class Bill {
    //declare variable
    private int billID;
    private int userID;
    private int sellerID;
    private int locationID;
    private int status;
    //constructor null
    public Bill() {
    }

    public Bill(int billID, int userID, int sellerID, int locationID, int status) {
        this.billID = billID;
        this.userID = userID;
        this.sellerID = sellerID;
        this.locationID = locationID;
        this.status = status;
    }

    public Bill(int userID, int sellerID, int locationID, int status) {
        this.userID = userID;
        this.sellerID = sellerID;
        this.locationID = locationID;
        this.status = status;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
