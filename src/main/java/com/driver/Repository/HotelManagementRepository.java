package com.driver.Repository;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelManagementRepository {

    HashMap<String, Hotel> hotelDb = new HashMap<>();
    HashMap<String, User> userDb = new HashMap<>();
    public String addHotel(Hotel hotel) {
        //You need to add a hotel to the database
        //In case the hotelName is null or the hotel Object is null return an empty a FAILURE
        //In case somebody is trying to add the duplicate hotelName return FAILURE
        //in all other cases return SUCCESS after successfully adding the hotel to the hotelDb.

        if(hotel == null) {
            return "FAILURE";
        }else if(hotelDb.containsKey(hotel.getHotelName())) {
            return "FAILURE";
        }

        String name = hotel.getHotelName();

        hotelDb.put(name, hotel);

        return "SUCCESS";
    }

    public Integer addUser(User user) {
        //You need to add a User Object to the database
        //Assume that user will always be a valid user and return the aadhar CardNo of the user
        String name = user.getName();
        userDb.put(name, user);

        return user.getaadharCardNo();
    }

    public String getHotelWithMostFacilities() {
        //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
        //Incase there is a tie return the lexicographically smaller hotelName
        //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)

        String res = "";
        int cnt = 1;

        for(String hotels : hotelDb.keySet()) {
            Hotel hotel = hotelDb.get(hotels);
            char ch = hotels.charAt(0);
            List<Facility> facilities = hotel.getFacilities();
            int size = facilities.size();

            if(cnt <= size) {
                if(cnt == size) {
                    if(res.equals("")) {
                        res = hotels;
                    } else {
                        res = res.charAt(0) > ch ? hotels : res;
                    }
                } else {
                    res = hotels;
                    cnt = size;
                }
            }
        }
        return res;
    }
}
