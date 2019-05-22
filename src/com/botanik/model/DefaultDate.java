package com.botanik.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author USER
 */
public class DefaultDate {

    private LocalDate locaDate;
    private Date date;

    public DefaultDate(LocalDate locaDate) {
        this.locaDate = locaDate;
    }

    public DefaultDate(Date date) {
        this.date = date;
    }

    public Date toDate() {
        if (locaDate == null) {
            return null;
        }
        return Date.from(locaDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public LocalDate toLocalDate() {
        if (date == null) {
            return null;
        }
//        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new java.sql.Date(date.getTime()).toLocalDate();
    }
    
    
    
}
