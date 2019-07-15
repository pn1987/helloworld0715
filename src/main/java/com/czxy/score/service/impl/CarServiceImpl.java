package com.czxy.score.service.impl;

import com.czxy.score.dao.CarMapper;
import com.czxy.score.entity.Car;
import com.czxy.score.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Resource
    CarMapper carMapper;

    @Override
    public Car getCarById(Integer id) {
        Example example = new Example(Car.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        return carMapper.selectOneByExample(example);
    }

    @Override
    public List<Car> getCarList() {
        return carMapper.selectAll();
    }
}
