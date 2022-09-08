package com.s3329840.items.model;

public class Item {

    private int id;
    private String name;
    private String desc;
    private String image;
    private double price;

    public Item() {}

    public Item(int id, String name, String desc, String image, double price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return"item{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "desc='" + desc + '\'' +
                "='" + id + '\'' +
                "id='" + id + '\'' +
                '}';
    }
}
