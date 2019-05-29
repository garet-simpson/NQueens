package com.garetsimpson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalDate.now;

public class Timer {
    //Timer object to keep track of how long each NQueen calculation takes.
    //This still in work.

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private  LocalDate startDate;
    String diff;

    public void start(){
        startDate = LocalDate.now();
    }

    public String stop(){
        LocalDate endDate = LocalDate.now();

        diff  = endDate.toString() + startDate.toString();
        return diff;
    }

}
