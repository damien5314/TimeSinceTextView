package com.ddiehl.timesincetextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Date;

public class TimeSinceTextView extends TextView {
  private static final int[] TIMESPAN_IDS = {
      R.string.timespan_years,
      R.string.timespan_months,
      R.string.timespan_weeks,
      R.string.timespan_days,
      R.string.timespan_hours,
      R.string.timespan_minutes,
      R.string.timespan_seconds,
      R.string.timespan_now
  };

  private static final int[] TIMESPAN_IDS_PLURAL = {
      R.string.timespan_years_plural,
      R.string.timespan_months_plural,
      R.string.timespan_weeks_plural,
      R.string.timespan_days_plural,
      R.string.timespan_hours_plural,
      R.string.timespan_minutes_plural,
      R.string.timespan_seconds_plural,
      R.string.timespan_now
  };

  private static final int[] TIMESPAN_IDS_ABBR = {
      R.string.timespan_year_abbr,
      R.string.timespan_months_abbr,
      R.string.timespan_weeks_abbr,
      R.string.timespan_days_abbr,
      R.string.timespan_hours_abbr,
      R.string.timespan_minutes_abbr,
      R.string.timespan_seconds_abbr,
      R.string.timespan_now
  };

  private static int NOW_THRESHOLD_SECONDS = 10;

  private boolean mAbbreviated = false;

  public TimeSinceTextView(Context context) {
    super(context);
  }

  public TimeSinceTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    mAbbreviated = attrs.getAttributeBooleanValue(
        "http://schemas.android.com/apk/res-auto",
        "abbreviated", false);
  }

  public void setDate(Date date) {
    setText(getFormattedDateString(date.getTime() / 1000));
  }

  public void setDate(long utc) {
    setText(getFormattedDateString(utc));
  }

  private String getFormattedDateString(long utc) {
    long currentTime = System.currentTimeMillis();
    long diffMs = currentTime - utc * 1000;

    long seconds = diffMs / 1000;
    long minutes = seconds / 60;
    long hours = minutes / 60;
    long days = hours / 24;
    long weeks = days / 7;
    long months = days / 30;
    long years = days / 365;

    long[] units = new long[] { years, months, weeks, days, hours, minutes, seconds };

    Context context = getContext();
    String output = "";
    long unit = 0;
    for (int i = 0; i < units.length; i++) {
      unit = units[i];
      if (unit > 0) {
        if (mAbbreviated) {
          output = context.getString(TIMESPAN_IDS_ABBR[i]);
        } else if (unit == 1) {
          output = context.getString(TIMESPAN_IDS[i]);
        } else {
          output = context.getString(TIMESPAN_IDS_PLURAL[i]);
        }
        break;
      }
    }

    if (unit == seconds && seconds <= NOW_THRESHOLD_SECONDS) {
      output = context.getString(TIMESPAN_IDS[TIMESPAN_IDS.length - 1]);
    }

    return String.format(output, unit);
  }
}
