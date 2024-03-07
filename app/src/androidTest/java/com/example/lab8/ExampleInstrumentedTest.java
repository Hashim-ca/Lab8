package com.example.lab8;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.lab8", appContext.getPackageName());
    }

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
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

    @Test
    public void hasCity(){
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        onView(withText("Estevan")).check(matches(isDisplayed()));
    }

    @Test
    public void removeCity(){
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
//        list.removeCity(0);
        onView(withText("Estevan")).check(doesNotExist());
    }

    @Test
    //count the number of cities in the list
    public void countCities(){
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Regina", "SK"));
        list.addCity(new City("Saskatoon", "SK"));
        assertEquals(list.getCount(),7);
    }


}