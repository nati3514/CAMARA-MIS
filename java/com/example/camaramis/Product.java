package com.example.camaramis;

public class Product {
    private int id;
    private String Afri_Number;
    private String Short_Des;
    private String Brand;
    //private String image;
    private String pro_Date;
    private String Status;

    public Product(int id, String Afri_Number, String Short_Des, String Brand, String pro_Date, String Status) {
        this.id = id;
        this.Afri_Number = Afri_Number;
        this.Short_Des = Short_Des;
        this.Brand = Brand;
        this.pro_Date = pro_Date;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public String getAfri_Number() {
        return Afri_Number;
    }

    public String getShort_Des() {
        return Short_Des;
    }

    public String getBrand() {
        return Brand;
    }

    public String getPro_Date() {
        return pro_Date;
    }

    public String getStatus() {
        return Status;
    }
}
