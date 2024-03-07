package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void setUp() {
        // Initialize your list here
        list = new CustomList(null, new ArrayList<>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void removeCity() {
        list.addCity(new City("Estevan", "SK"));
        list.removeCity(0); // Assuming removeCity is correctly implemented to remove based on index
        assertEquals(0, list.getCount());
    }

    @Test
    public void countCities() {
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Regina", "SK"));
        list.addCity(new City("Saskatoon", "SK"));
        assertEquals(3, list.getCount());
    }
}
