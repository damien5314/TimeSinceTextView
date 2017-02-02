package com.ddiehl.timesincetextview;

import android.content.Context;

public class TimeSince {

    private static final int[] TIMESPAN_IDS = {
            R.plurals.tstv_timespan_years,
            R.plurals.tstv_timespan_months,
            R.plurals.tstv_timespan_weeks,
            R.plurals.tstv_timespan_days,
            R.plurals.tstv_timespan_hours,
            R.plurals.tstv_timespan_minutes,
            R.plurals.tstv_timespan_seconds
    };

    private static final int[] TIMESPAN_IDS_ABBR = {
            R.plurals.tstv_timespan_years_abbr,
            R.plurals.tstv_timespan_months_abbr,
            R.plurals.tstv_timespan_weeks_abbr,
            R.plurals.tstv_timespan_days_abbr,
            R.plurals.tstv_timespan_hours_abbr,
            R.plurals.tstv_timespan_minutes_abbr,
            R.plurals.tstv_timespan_seconds_abbr
    };

    private static final int NOW_THRESHOLD_SECONDS = 10;

    /**
     * Returns a formatted date string with respect to the current time, optionally abbreviated.
     *
     * @param utc         Unix timestamp of the start date
     * @param abbreviated True if we should display the date string in abbreviated form, false otherwise
     * @param context     {@link android.content.Context} with access to application {@link android.content.res.Resources}
     * @return String formatted in the form of `X days ago` or locale equivalent
     */
    public static String getFormattedDateString(long utc, boolean abbreviated, Context context) {
        long currentTime = System.currentTimeMillis() / 1000;
        return getFormattedDateString(utc, currentTime, abbreviated, context);
    }

    /**
     * Returns a formatted date string with respect to the given time, optionally abbreviated.
     *
     * @param start       Unix timestamp of the start date
     * @param end         Unix timestamp of the end date
     * @param abbreviated True if we should display the date string in abbreviated form, false otherwise
     * @param context     {@link android.content.Context} with access to application {@link android.content.res.Resources}
     * @return String formatted in the form of `X days ago` or locale equivalent
     */
    public static String getFormattedDateString(
            long start, long end, boolean abbreviated, Context context) {
        int seconds = (int) (end - start);
        int[] units = new int[]{
                seconds / 31536000, // years
                seconds / 2592000, // months
                seconds / 604800, // weeks
                seconds / 86400, // days
                seconds / 3600, // hours
                seconds / 60, // minutes
                seconds};

        String output = "";
        int unit = 0;
        for (int i = 0; i < units.length; i++) {
            unit = units[i];
            if (unit > 0) {
                output = context.getResources().getQuantityString(
                        abbreviated ? TIMESPAN_IDS_ABBR[i] : TIMESPAN_IDS[i],
                        unit, unit);
                break;
            }
        }

        if (unit == seconds && seconds <= NOW_THRESHOLD_SECONDS) {
            output = context.getString(R.string.tstv_timespan_now);
        }

        return String.format(output, unit);
    }

    private TimeSince() {
    }

}
