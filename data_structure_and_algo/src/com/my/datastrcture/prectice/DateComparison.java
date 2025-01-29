package com.my.datastrcture.prectice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparison {
    public static boolean isDueDateInRange1(Date currentBusinessDate, Date nextBusinessDate, Date dueDate) {
        // Ensure none of the dates are null (edge case)
        if (currentBusinessDate == null || nextBusinessDate == null || dueDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        // Compare dueDate with currentBusinessDate and nextBusinessDate
        return (dueDate.compareTo(currentBusinessDate) >= 0) && (dueDate.compareTo(nextBusinessDate) < 0);
    }

    public static boolean isDueDateInRange(Date currentBusinessDate, Date nextBusinessDate, Date dueDate) {
        // Check if dueDate is >= currentBusinessDate and < nextBusinessDate using after() and before()
        return !dueDate.before(currentBusinessDate) && dueDate.before(nextBusinessDate);
    }

    public static boolean isDueDateWithinBusinessRange(Date dueDate, Date previousBusinessDate, Date currentBusinessDate) {
        // Check if dueDate is greater than previousBusinessDate and less than or equal to currentBusinessDate
        return dueDate.compareTo(previousBusinessDate) > 0 && dueDate.compareTo(currentBusinessDate) <= 0;
    }

    public static boolean isDueDateWithinBusinessRange1(Date dueDate, Date previousBusinessDate, Date currentBusinessDate) {
        // Check if dueDate is greater than previousBusinessDate and less than or equal to currentBusinessDate
        return dueDate.after(previousBusinessDate) && !dueDate.after(currentBusinessDate);
    }

    public static void main(String[] args) {
       /* // Example dates (replace these with actual dates)
        Date previousBusinessDate = convertStringToDate("10/18/2024"); // Oct 18, 2024
        Date currentBusinessDate = convertStringToDate("10/21/2024");  // Oct 21, 2024
        Date dueDate = new Date();              // Example due date (Oct 20, 2024)

        // Check if the due date is within the business date range
        boolean result = isDueDateWithinBusinessRange(dueDate, previousBusinessDate, currentBusinessDate);
        boolean result1 = isDueDateWithinBusinessRange1(dueDate, previousBusinessDate, currentBusinessDate);
        System.out.println("Is the due date within the business range? " + result);
        System.out.println("Is the due date within the business range? " + result1);*/

        Date currentBusinessDate = convertStringToDate("10/18/2024");  // 18-Oct-2024
        Date nextBusinessDate = convertStringToDate("10/21/2024");     // 21-Oct-2024
        Date dueDate = convertStringToDate("10/19/2024");              // 19-Oct-2024 (Example)


        // Check if the due date falls between the business dates
        boolean isInRange = isDueDateInRange(currentBusinessDate, nextBusinessDate, dueDate);

        // Output the result
        System.out.println("Is due date in range? " + isInRange);
    }

    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); // Define the date format
        try {
            // Parse the string into a java.util.Date object
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
