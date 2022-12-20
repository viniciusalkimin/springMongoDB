package com.alkimin.springMongoDB.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultDate) {
        if(!textDate.isEmpty()) {
            return LocalDate.parse(textDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return defaultDate;
    }
}
