package com.company.day1;

import java.sql.Time;
import java.util.Date;

public class TimeGreetings {
    private Date currentDate;

    public TimeGreetings () {
        updateTime();
    }
    public void updateTime() {
        currentDate = new Date();
    }
    public void printGreetings(String username) {
        updateTime();
        int hours = currentDate.getHours();
        if(hours >= 0 && hours <=4) {
            System.out.println("Доброй ночи, " + username);
        } else if(hours >=5 && hours<=9) {
            System.out.println("Доброе утро, " + username);
        } else if (hours >=10 && hours <=16) {
            System.out.println("Добрый день, " + username);
        } else {
            System.out.println("Добрый вечер, " + username);
        }
    }

}
