package ru.hotelinno.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateTimeHandler {
    private SimpleDateFormat format;
    private final String defaultFormat = "yyyyMMdd130000";
    private final int rate = 1000; //1000 milliseconds in 1 second

    /**
     * Construct instance with default date-time format.
     */
    DateTimeHandler() {
        format = new SimpleDateFormat(defaultFormat);
    }

    /**
     * Construct instance with assigned date-time format.
     */
    DateTimeHandler(String dateFormat) {
        format = new SimpleDateFormat(dateFormat);
    }

    String getFormattedDate(long timeStampInMinutes) {
        Date date = new Date(timeStampInMinutes * rate);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return format.format(date);
    }

    /**
     * Parse <currentString> from <beginPosition> till <endPosition> with pattern defined in class constructor.
     * Return time stamp in minutes.
     */
    long getTimeStampInMinutes(String currentString) {
        Date dateBegin = format.parse(currentString, new ParsePosition(0));
        return dateBegin.getTime() / rate;
    }
}