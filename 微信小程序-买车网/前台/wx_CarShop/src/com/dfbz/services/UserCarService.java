package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.userCar;

public interface UserCarService {
    public List<userCar> findCar (int id,String address);
}
