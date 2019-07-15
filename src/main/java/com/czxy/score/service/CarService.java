package com.czxy.score.service;

import com.czxy.score.entity.Car;

import java.util.List;

public interface CarService {

    Car getCarById(Integer id);
    List<Car> getCarList();
}
