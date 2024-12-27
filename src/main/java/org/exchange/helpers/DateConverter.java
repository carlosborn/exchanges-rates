package org.exchange.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static String convertDateToString(Date date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
