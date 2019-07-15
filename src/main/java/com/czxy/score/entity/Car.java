package com.czxy.score.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name="tab_car")
public class Car implements Serializable {

    @Id
    private Integer id;
    private String carName;
    private Double minPrice;
    private Double maxPrice;
    private String productionPlace;
    private String introduce;
    private String img;

    //浏览次数
    @Transient
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Car() {
    }

    public Car(Integer id, String carName, Double minPrice, Double maxPrice, String productionPlace, String introduce) {
        this.id = id;
        this.carName = carName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.productionPlace = productionPlace;
        this.introduce = introduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        this.productionPlace = productionPlace;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
