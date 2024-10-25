package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return the list of objects
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * check if selected city is in the list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Toronto", "Ontario");
        list.addCity(city);
        assertTrue(list.hasCity(city), "hasCity should return true when the city is in the list");
        City nonExistentCity = new City("Vancouver", "British Columbia");
        assertFalse(list.hasCity(nonExistentCity), "hasCity should return false when the city is not in the list");

    }

    /**
     *check if the city is successfully deleted in the list
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Toronto", "Ontario");
        list.addCity(city);
        assertTrue(list.deleteCity(city), "deleteCity should return true when the city is successfully removed");
        City nonExistentCity = new City("Vancouver", "British Columbia");
        assertFalse(list.deleteCity(nonExistentCity), "deleteCity should return false when the city is not in the list");
    }

    /**
     * this checks if the number of cities in the list is counted correctly
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities(), "countCities should return 0 when the list is empty");
        City city1 = new City("Toronto", "Ontario");
        list.addCity(city1);
        assertEquals(1, list.countCities(), "countCities should return 1 after adding one city");
        City city2 = new City("Vancouver", "British Columbia");
        list.addCity(city2);
        assertEquals(2, list.countCities(), "countCities should return 2 after adding another city");

    }

    }


