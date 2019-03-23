package com.example.asus.demo2;

public class Model {

    private int image;
    private String name, address, price, distance,description,star ,sale;

    public Model(int image, String name, String address, String price, String description) {
        this.image = image;
        this.name = name;
        this.address = address;
        this.price = price;
        this.description = description;
    }

    public Model(int image, String name,String address, String star, String price, String distance) {
        this.image = image;
        this.address = address;
        this.star = star;
        this.name = name;
        this.price = price;
        this.distance = distance;
    }
    public Model(int image, String name,String address, String star, String price, String distance, String sale) {
        this.image = image;
        this.address = address;
        this.star = star;
        this.name = name;
        this.price = price;
        this.distance = distance;
        this.sale = sale;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLocal() {
        return distance;
    }

    public void setLocal(String local) {
        this.distance = local;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return address;
    }

    public void setPlace(String place) {
        this.address = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
