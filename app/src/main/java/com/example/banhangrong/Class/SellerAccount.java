package com.example.banhangrong.Class;

import java.io.Serializable;
import java.util.Date;

public class SellerAccount implements Serializable {
    //declare vatiables
    private int sellerID;
    private String phoneNumber;
    private String password;
    private String sellerName;
    private int locationID;
    private int sellerTypeID;
    private String dateOfBirth;
    private int gender;
    private String address;
    private String gmail;
    private int hash;
    private byte[] image;
    private int status;

    public SellerAccount() {
    }

    public SellerAccount(int sellerID, String phoneNumber, String password, String sellerName, int locationID, int sellerTypeID, String dateOfBirth, int gender, String address, String gmail, int hash, byte[] image, int status) {
        this.sellerID = sellerID;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.sellerName = sellerName;
        this.locationID = locationID;
        this.sellerTypeID = sellerTypeID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.gmail = gmail;
        this.hash = hash;
        this.image = image;
        this.status = status;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getSellerTypeID() {
        return sellerTypeID;
    }

    public void setSellerTypeID(int sellerTypeID) {
        this.sellerTypeID = sellerTypeID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int isGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
