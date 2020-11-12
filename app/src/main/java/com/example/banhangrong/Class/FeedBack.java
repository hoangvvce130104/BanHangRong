package com.example.banhangrong.Class;

import java.util.Date;

public class FeedBack {
    //declare variables
    private int feedBackID;
    private int userID;
    private int sellerID;
    private Date dateFeedback;
    private String title;
    private String description;
    private int status;

    //null constructor
    public FeedBack() {
    }

    /**
     * constructor hasn't id feed back
     * @param userID
     * @param sellerID
     * @param dateFeedback
     * @param title
     * @param description
     * @param status
     */
    public FeedBack(int userID, int sellerID, Date dateFeedback, String title, String description, int status) {
        this.userID = userID;
        this.sellerID = sellerID;
        this.dateFeedback = dateFeedback;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    /**
     * constructor full
     * @param feedBackID
     * @param userID
     * @param sellerID
     * @param dateFeedback
     * @param title
     * @param description
     * @param status
     */
    public FeedBack(int feedBackID, int userID, int sellerID, Date dateFeedback, String title, String description, int status) {
        this.feedBackID = feedBackID;
        this.userID = userID;
        this.sellerID = sellerID;
        this.dateFeedback = dateFeedback;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    /**
     * Getter setter all variables
     *
     */
    public int getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(int feedBackID) {
        this.feedBackID = feedBackID;
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

    public Date getDateFeedback() {
        return dateFeedback;
    }

    public void setDateFeedback(Date dateFeedback) {
        this.dateFeedback = dateFeedback;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
