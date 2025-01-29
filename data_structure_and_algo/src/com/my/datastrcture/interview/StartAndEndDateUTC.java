package com.my.datastrcture.interview;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StartAndEndDateUTC {
    public static void main(String[] args) {
        // Step 1: Current date-time in EST
        ZoneId estZone = ZoneId.of("America/New_York"); // EST time zone
        ZonedDateTime estDateTime = ZonedDateTime.now(estZone);
        System.out.println("Current Date-Time in EST: " + estDateTime);

        // Step 2: Convert EST to UTC
        ZonedDateTime utcDateTime = estDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("Converted Date-Time in UTC: " + utcDateTime);

        // Step 3: Subtract one day from the UTC time
        ZonedDateTime utcDateTimeMinusOneDay = utcDateTime.minusDays(1);

        // Step 4: Format the output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedUTCDateMinusOneDay = utcDateTimeMinusOneDay.format(formatter);
        System.out.println("Formatted UTC Date-Time (Minus 1 Day): " + formattedUTCDateMinusOneDay);
    }
}
