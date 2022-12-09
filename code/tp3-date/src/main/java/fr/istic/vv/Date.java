package fr.istic.vv;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) { 
        if (!isValidDate(day, month, year)) throw new IllegalArgumentException("Invalid date");
    }

    public static boolean isValidDate(int day, int month, int year) { 

        if(month < 1 || month > 12) return false;
        if(day < 1) return false;

        if(month == 2){
            if(isLeapYear(year) && day > 28) return false;
            else if(isLeapYear(year) && day > 29) return false;
        }

        if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day > 30) return false;

        }else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 12){
            if(day > 31) return false;
        }
        
        return true;

     }

    public static boolean isLeapYear(int year) { 
        
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) return true;
                return false;
            }
            return true;
        }
        return false;

     }

    public Date nextDate() {

        int day = this.day;
        int month = this.month;
        int year = this.year;

        if(day == 31 && month == 12) {
            day = 1;
            month = 1;
            year++;
        } else if(day == 31) {
            day = 1;
            month++;
        } else if(day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            day = 1;
            month++;
        } else if(day == 28 && month == 2 && !isLeapYear(year)) {
            day = 1;
            month++;
        } else if(day == 29 && month == 2 && isLeapYear(year)) {
            day = 1;
            month++;
        } else
            day++;

        return new Date(day, month, year);

    }

    public Date previousDate() { 

        int day = this.day;
        int month = this.month;
        int year = this.year;

        if(day == 1 && month == 1) {
            day = 31;
            month = 12;
            year--;
        } else if(day == 1 && month == 3 && isLeapYear(year)) {
            day = 29;
            month--;
        } else if(day == 1 && month == 3 && !isLeapYear(year)) {
            day = 28;
            month--;
        } else if(day == 1 && (month == 5 || month == 7 || month == 10 || month == 12)) {
            day = 30;
            month--;
        } else if(day == 1) {
            day = 31;
            month--;
        } else
            day--;

        return new Date(day, month, year);

     }

    public int compareTo(Date other) {

        if(other == null) throw new NullPointerException();

        if(this.year < other.year) return -1;
        if(this.year > other.year) return 1;

        if(this.month < other.month) return -1;
        if(this.month > other.month) return 1;

        if(this.day < other.day) return -1;
        if(this.day > other.day) return 1;

        return 0;

     }

}