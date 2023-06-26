package com.driver.Services;

import com.driver.Repository.HotelManagementRepository;
import com.driver.model.Hotel;
import com.driver.model.User;

public class HotelManagementService {

    private HotelManagementRepository hotelManagementRepository= new HotelManagementRepository();

    public String addHotel(Hotel hotel) {
        return hotelManagementRepository.addHotel(hotel);
    }

    public Integer addUser(User user) {
        return hotelManagementRepository.addUser(user);
    }

    public String getHotelWithMostFacilities() {
        return hotelManagementRepository.getHotelWithMostFacilities();
    }
}
