package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void testIsValideDate1(){
        assertTrue(Date.isValidDate(0,1,2020));
    }

    @Test
    public void testIsValideDate2(){
        assertTrue(Date.isValidDate(1,0,2020));
    }

    @Test
    public void testIsValideDate3(){
        assertTrue(Date.isValidDate(1,1,2020));
    }

}