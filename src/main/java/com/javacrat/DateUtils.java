package com.javacrat;

import java.time.LocalDateTime;

public class DateUtils {

    public  static int countNumberOfDayBetweenDates(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        int difference = 0;
        if(dateTime1.isBefore(dateTime2)) {
            difference = dateTime1.getDayOfYear() - dateTime2.getDayOfYear();
        } else {
            difference = dateTime1.getDayOfYear() - dateTime2.getDayOfYear();
        }
        return difference;
    }

    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(2021, 6, 3, 10, 10);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("number of days between "+now+ " and " +of+ " is " +countNumberOfDayBetweenDates(now, of));
    }

}
