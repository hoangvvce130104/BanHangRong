package com.example.banhangrong.Class;

public class SellerType {
    //declare variables
    private int sellerTypeID;
    private String nameSellerType;
    private int status;
    //constructor null
    public SellerType() {
    }
    //constructor hasn't id seller type id
    public SellerType(String nameSellerType, int status) {
        this.nameSellerType = nameSellerType;
        this.status = status;
    }
    //constructor full
    public SellerType(int sellerTypeID, String nameSellerType, int status) {
        this.sellerTypeID = sellerTypeID;
        this.nameSellerType = nameSellerType;
        this.status = status;
    }

    public static class UserAccount {
        //declare variables
        private int userID;
        private String passWord;
        private String nameUser;
        private int locationID;
        private String dateOfBirth;
        private int gender;
        private String phoneNumber;
        private String address;
        private int userStatus;
        private String hash;
        private String gmail;



        //constructor null
        public UserAccount() {

        }
        //constructor hasn't id user account
        public UserAccount(String passWord, String nameUser, int locationID, String dateOfBirth, int gender, String phoneNumber, String address, int userStatus, String hash, String gmail) {
            this.passWord = passWord;
            this.nameUser = nameUser;
            this.locationID = locationID;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.userStatus = userStatus;
            this.hash = hash;
            this.gmail = gmail;
        }
        //constructor full
        public UserAccount(int userID, String passWord, String nameUser, int locationID, String dateOfBirth, int gender, String phoneNumber, String address, int userStatus, String hash, String gmail) {
            this.userID = userID;
            this.passWord = passWord;
            this.nameUser = nameUser;
            this.locationID = locationID;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.userStatus = userStatus;
            this.hash = hash;
            this.gmail = gmail;
        }

        /**
         * Getter setter all variables
         *
         */
        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }


        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public String getNameUser() {
            return nameUser;
        }

        public void setNameUser(String nameUser) {
            this.nameUser = nameUser;
        }

        public int getLocationID() {
            return locationID;
        }

        public void setLocationID(int locationID) {
            this.locationID = locationID;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getGmail() {
            return gmail;
        }

        public void setGmail(String gmail) {
            this.gmail = gmail;
        }
    }
}
