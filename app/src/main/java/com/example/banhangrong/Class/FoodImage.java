package com.example.banhangrong.Class;

public class FoodImage {
    //declare variables
    private int imageID;
    private byte[] image;
    private int foodId;
    private int status;
    //constructor null
    public FoodImage() {
    }
    //constructor hasn't id image
    public FoodImage(byte[] image, int foodId, int status) {
        this.image = image;
        this.foodId = foodId;
        this.status = status;
    }
    // constructor full
    public FoodImage(int imageID, byte[] image, int foodId, int status) {
        this.imageID = imageID;
        this.image = image;
        this.foodId = foodId;
        this.status = status;
    }
    // getter setter all variables
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public byte[] getURL() {
        return image;
    }

    public void setURL(byte[] image) {
        this.image = image;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
