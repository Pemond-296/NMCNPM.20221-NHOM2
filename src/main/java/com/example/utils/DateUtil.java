package com.example.utils;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtil {
    public static Date asDate(LocalDate localDate) {
        return Date.valueOf(localDate);
    }

    public static LocalDate asLocalDate(Date date) {
        return date.toLocalDate();
    }
}
