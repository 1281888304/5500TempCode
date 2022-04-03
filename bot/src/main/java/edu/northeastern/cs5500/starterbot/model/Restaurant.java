package edu.northeastern.cs5500.starterbot.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Restaurant implements Model {

    private ObjectId id;
    private String restaurantId;
    private String image;
    private String description;
    private String openTime;
    private String type;
    private String address;
    private String restaurantPhone;
    private String orderId;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Restaurant() {}

    // public Restaurant(
    //         String restaurantId,
    //         String image,
    //         String description,
    //         String openTime,
    //         String type,
    //         String address,
    //         String restaurantPhone,
    //         String orderId) {

    //     this.restaurantId = restaurantId;
    //     this.image = image;
    //     this.description = description;
    //     this.openTime = openTime;
    //     this.type = type;
    //     this.address = address;
    //     this.restaurantPhone = restaurantPhone;
    //     this.orderId = orderId;
    // }

    // public Restaurant(
    //         ObjectId id,
    //         String restaurantId,
    //         String image,
    //         String description,
    //         String openTime,
    //         String type,
    //         String address,
    //         String restaurantPhone,
    //         String orderId) {

    //     this.id = id;
    //     this.restaurantId = restaurantId;
    //     this.image = image;
    //     this.description = description;
    //     this.openTime = openTime;
    //     this.type = type;
    //     this.address = address;
    //     this.restaurantPhone = restaurantPhone;
    //     this.orderId = orderId;
    // }

    // public String getRestaurantId() {
    //     return restaurantId;
    // }

    // public void setRestaurantId(String restaurantId) {
    //     this.restaurantId = restaurantId;
    // }

    // public String getImage() {
    //     return image;
    // }

    // public void setImage(String image) {
    //     this.image = image;
    // }

    // public String getDescription() {
    //     return description;
    // }

    // public void setDescription(String description) {
    //     this.description = description;
    // }

    // public String getType() {
    //     return type;
    // }

    // public void setType(String type) {
    //     this.type = type;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public String getOpenTime() {
    //     return this.openTime;
    // }

    // public void setopenTime(String openTime) {
    //     this.openTime = openTime;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public String getRestaurantPhone() {
    //     return restaurantPhone;
    // }

    // public void setRestaurantPhone(String restaurantPhone) {
    //     this.restaurantPhone = restaurantPhone;
    // }

    // public String getOrderId() {
    //     return orderId;
    // }

    // public void setOrderId(String orderId) {
    //     this.orderId = orderId;
    // }

    @Override
    public String toString() {
        return "Restaurant [restaurantId="
                + restaurantId
                + ", image="
                + image
                + ", description="
                + description
                + ", isOpen="
                + openTime
                + ", type="
                + type
                + ", address="
                + address
                + ", restaurantPhone="
                + restaurantPhone
                + ", orderId="
                + orderId
                + "]";
    }
}
