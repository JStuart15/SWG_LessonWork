/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dateexamples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author jstuart15
 */
public class DateExamples {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        
        ld = LocalDate.parse("2017-01-01");
        System.out.println(ld);
        
        ld = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);
        
        String isoDate = ld.toString();
        System.out.println("ISO Date to String " + isoDate);
        ld = LocalDate.parse(isoDate);
        System.out.println(ld);
        
        //print out in month/day/year format
        String formatted = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(formatted);
        
        formatted = ld.format(DateTimeFormatter.ofPattern("MM=dd=yyyy+=+=+=+="));
        System.out.println(formatted);
        
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        LocalDate past = ld.minusDays(6);
        System.out.println(past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        
        past = ld.minusMonths(3);
        System.out.println(past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        
        //difference between two dates
        Period diff = ld.until(past);
        System.out.println(diff);
        System.out.println(diff.getMonths());
        
        diff = past.until(ld);
        System.out.println(diff.getMonths());
        
        //LocalDateTimes
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        
        formatted = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(formatted);
        
        //Convert legacy dates to new date/times
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        
        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);
            //for legacy date
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(),ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
            //for Gregorian calendar
        zdt = legacyCalendar.toZonedDateTime();
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
        System.out.println(3.0 % 3.0);
        System.out.println(6.0 % 4.2);
        
    }
    
    
}
