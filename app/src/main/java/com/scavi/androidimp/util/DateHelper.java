package com.scavi.androidimp.util;

import java.util.Calendar;

public class DateHelper {
    /**
     * Private constructor to prevent access of the helper class (only static access)
     */
    private DateHelper() {

    }

    /**
     * Determines the start timestamp (based on milli seconds) of the last month depending on the
     * given timestamp
     *
     * @param timeInMillis the given timestamp
     * @return the start of the last month
     */
    public static long startOfLastMonth(final long timeInMillis) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(endOfLastMonth(timeInMillis));
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    /**
     * Determines the start timestamp (based on milli seconds) of the last month depending on the
     * given timestamp
     *
     * @param timeInMillis the given timestamp
     * @return the start of the last month
     */
    public static long endOfLastMonth(final long timeInMillis) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeInMillis);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MILLISECOND, -1);
        return c.getTimeInMillis();
    }


    /**
     * Determines the start of the next month depending on the given milli seconds. Then
     * calculates the remaining time
     *
     * @param timeInMillis the given timestamp
     * @return the remaining time
     */
    public static long timeToNextMonth(final long timeInMillis) {
        Calendar next = Calendar.getInstance();
        next.setTimeInMillis(timeInMillis);
        // next month
        next.add(Calendar.MONTH, 1);
        next.set(Calendar.DAY_OF_MONTH, 1);
        next.set(Calendar.HOUR_OF_DAY, 0);
        next.set(Calendar.MINUTE, 0);
        next.set(Calendar.SECOND, 0);
        next.set(Calendar.MILLISECOND, 0);
        return next.getTimeInMillis() - timeInMillis;
    }
}
