package com.springboot.service;

import com.springboot.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarService {

    public List<Car> list(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2,"劳斯莱斯",8888d,new Date()));
        cars.add(new Car(3,"布加拉迪",8888d,new Date()));
        cars.add(new Car(4,"玛莎拉蒂",8888d,new Date()));
        return cars;
    }
}