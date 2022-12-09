package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    // IsValideDate

    @Test
    public void testIsValideDate1(){
        assertFalse(Date.isValidDate(0,1,2020));
    }

    @Test
    public void testIsValideDate2(){
        assertFalse(Date.isValidDate(1,0,2020));
    }

    @Test
    public void testIsValideDate3(){
        assertFalse(Date.isValidDate(32,1,2020));
    }

    @Test
    public void testIsValideDate4(){
        assertFalse(Date.isValidDate(1,13,2020));
    }

    @Test
    public void testIsValideDate5(){
        assertFalse(Date.isValidDate(31,4,2020));
    }

    @Test
    public void testIsValideDate6(){
        assertTrue(Date.isValidDate(29,2,2020));
    }

    @Test
    public void testIsValideDate7(){
        assertTrue(Date.isValidDate(29,2,2024));
    }

    @Test
    public void testIsValideDate8(){
        assertTrue(Date.isValidDate(28,2,2022));
    }

    // IsLeapYear

    @Test
    public void testIsLeapYear1(){
        assertTrue(Date.isLeapYear(2024));
    }

    @Test
    public void testIsLeapYear2(){
        assertFalse(Date.isLeapYear(2023));
    }
    
    @Test
    public void testIsLeapYear3(){
        assertTrue(Date.isLeapYear(400));
    }

    @Test
    public void testIsLeapYear4(){
        assertTrue(Date.isLeapYear(404));
    }

    @Test
    public void testIsLeapYear5(){
        assertTrue(Date.isLeapYear(16000));
    }

    @Test
    public void testIsLeapYear6(){
        assertFalse(Date.isLeapYear(100));
    }

    // NextDate

    @Test
    public void testNextDate1(){
        Date date = new Date(31,12,2020);

        Date nextDate = date.nextDate();

        assertEquals(1,nextDate.getDay());
        assertEquals(1,nextDate.getMonth());
        assertEquals(2021,nextDate.getYear());
    }

    @Test
    public void testNextDate2(){
        Date date = new Date(28, 2, 2020);

        Date nextDate = date.nextDate();

        assertEquals(29,nextDate.getDay());
    }

    @Test
    public void testNextDate3(){
        Date date = new Date(27, 2, 2021);

        Date nextDate = date.nextDate();

        assertEquals(28,nextDate.getDay());
    }

    @Test
    public void testNextDate4(){
        Date date = new Date(27, 2, 2024);

        Date nextDate = date.nextDate();

        assertEquals(28,nextDate.getDay());
    }

    // previousDate

    @Test
    public void testPreviousDate1(){
        Date date = new Date(1,1,2021);

        Date previousDate = date.previousDate();

        assertEquals(31,previousDate.getDay());
        assertEquals(12,previousDate.getMonth());
        assertEquals(2020,previousDate.getYear());
    }

    @Test
    public void testPreviousDate2(){
        Date date = new Date(1,3,2020);

        Date previousDate = date.previousDate();

        assertEquals(29,previousDate.getDay());
    }

    @Test
    public void testPreviousDate3(){
        Date date = new Date(1,3,2021);

        Date previousDate = date.previousDate();

        assertEquals(28,previousDate.getDay());
    }

    // compareTo

    @Test
    public void testCompareTo1(){
        Date date1 = new Date(1,1,2020);
        Date date2 = new Date(1,1,2020);

        assertEquals(0,date1.compareTo(date2));
    }

    @Test
    public void testCompareTo2(){
        Date date1 = new Date(1,1,2020);
        Date date2 = new Date(1,1,2021);

        assertEquals(-1,date1.compareTo(date2));
    }

    @Test
    public void testCompareTo3(){
        Date date1 = new Date(1,2,2020);
        Date date2 = new Date(1,1,2020);

        assertEquals(1,date1.compareTo(date2));
    }

    @Test
    public void testCompareTo4(){
        Date date1 = new Date(2,1,2020);
        Date date2 = new Date(1,1,2020);

        assertEquals(1,date1.compareTo(date2));
    }

    @Test
    public void testCompareTo5(){
        Date date1 = new Date(1,1,2020);
        Date date2 = new Date(2,1,2020);

        assertEquals(-1,date1.compareTo(date2));
    }

    @Test
    public void testCompareTo6(){
        Date date1 = new Date(1,1,2020);
        Date date2 = new Date(1,2,2020);

        assertEquals(-1,date1.compareTo(date2));
    }

}