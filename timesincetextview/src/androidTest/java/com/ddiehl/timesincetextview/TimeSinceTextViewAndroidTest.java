package com.ddiehl.timesincetextview;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class TimeSinceTextViewAndroidTest {
  private static final String TIMESPAN_NOW = "just now";
  private static final String TIMESPAN_YEARS = "%s years ago";
  private static final String TIMESPAN_MONTHS = "%s months ago";
  private static final String TIMESPAN_WEEKS = "%s weeks ago";
  private static final String TIMESPAN_DAYS = "%s days ago";
  private static final String TIMESPAN_HOURS = "%s hours ago";
  private static final String TIMESPAN_MINUTES = "%s minutes ago";
  private static final String TIMESPAN_SECONDS = "%s seconds ago";
  private static final String TIMESPAN_YEAR = "%s year ago";
  private static final String TIMESPAN_MONTH = "%s month ago";
  private static final String TIMESPAN_WEEK = "%s week ago";
  private static final String TIMESPAN_DAY = "%s day ago";
  private static final String TIMESPAN_HOUR = "%s hour ago";
  private static final String TIMESPAN_MINUTE = "%s minute ago";
  private static final String TIMESPAN_SECOND = "%s second ago";
  private static final String TIMESPAN_YEARS_ABBR = "%syr";
  private static final String TIMESPAN_MONTHS_ABBR = "%smo";
  private static final String TIMESPAN_WEEKS_ABBR = "%swk";
  private static final String TIMESPAN_DAYS_ABBR = "%sd";
  private static final String TIMESPAN_HOURS_ABBR = "%sh";
  private static final String TIMESPAN_MINUTES_ABBR = "%sm";
  private static final String TIMESPAN_SECONDS_ABBR = "%ss";

  private Context mContext;
  private final long mTime = new Date().getTime() / 1000;

  @Before
  public void setUp() {
    mContext = InstrumentationRegistry.getContext();
  }

  @After
  public void tearDown() {

  }

  @Test
  public void getFormattedDateString_now() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 10, mTime, false, mContext),
        is(TIMESPAN_NOW));
  }

  @Test
  public void getFormattedDateString_11seconds() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 11, mTime, false, mContext),
        is(TIMESPAN_SECONDS, String.valueOf(11)));
  }

  @Test
  public void getFormattedDateString_59seconds() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 59, mTime, false, mContext),
        is(TIMESPAN_SECONDS, String.valueOf(59)));
  }

  @Test
  public void getFormattedDateString_1minute() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60, mTime, false, mContext),
        is(TIMESPAN_MINUTE, String.valueOf(1)));
  }

  @Test
  public void getFormattedDateString_59minutes() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60 * 60 + 1, mTime, false, mContext),
        is(TIMESPAN_MINUTES, String.valueOf(59)));
  }

  @Test
  public void getFormattedDateString_1hour() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60 * 60, mTime, false, mContext),
        is(TIMESPAN_HOUR, String.valueOf(1)));
  }

  @Test
  public void getFormattedDateString_23hours() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(TIMESPAN_HOURS, String.valueOf(23)));
  }

  @Test
  public void getFormattedDateString_1day() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60, mTime, false, mContext),
        is(TIMESPAN_DAY, String.valueOf(1)));
  }

  @Test
  public void getFormattedDateString_6days() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(TIMESPAN_DAYS, String.valueOf(6)));
  }

  @Test
  public void getFormattedDateString_1week() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60, mTime, false, mContext),
        is(TIMESPAN_WEEK, String.valueOf(1)));
  }

  @Test
  public void getFormattedDateString_4weeks() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(TIMESPAN_WEEKS, String.valueOf(4)));
  }

  @Test
  public void getFormattedDateString_1month() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60, mTime, false, mContext),
        is(TIMESPAN_MONTH, String.valueOf(1)));
  }

  @Test
  public void getFormattedDateString_12months() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(TIMESPAN_MONTHS, String.valueOf(12)));
  }

  @Test
  public void getFormattedDateString_1year() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60, mTime, false, mContext),
        is(TIMESPAN_YEAR, String.valueOf(1)));
  }

  @Test
  public void getFormattedDateString_30years() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 30 * 365 * 24 * 60 * 60, mTime, false, mContext),
        is(TIMESPAN_YEARS, String.valueOf(30)));
  }

  @Test
  public void getFormattedDateString_abbrev() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 59, mTime, true, mContext),
        is(TIMESPAN_SECONDS_ABBR, String.valueOf(59)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60, mTime, true, mContext),
        is(TIMESPAN_MINUTES_ABBR, String.valueOf(1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60 * 60, mTime, true, mContext),
        is(TIMESPAN_HOURS_ABBR, String.valueOf(1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60, mTime, true, mContext),
        is(TIMESPAN_DAYS_ABBR, String.valueOf(1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60, mTime, true, mContext),
        is(TIMESPAN_WEEKS_ABBR, String.valueOf(1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60, mTime, true, mContext),
        is(TIMESPAN_MONTHS_ABBR, String.valueOf(1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60, mTime, true, mContext),
        is(TIMESPAN_YEARS_ABBR, String.valueOf(1)));
  }

  @Test
  public void setDate_long() {
    TimeSinceTextView view = new TimeSinceTextView(mContext);
    view.setDate(mTime - 1 * 24 * 60 * 60); // 1 day
    assertThat(
        view.getText().toString(),
        is(TIMESPAN_DAY, String.valueOf(1)));
  }

  @Test
  public void setDate_java_util_date() {
    TimeSinceTextView view = new TimeSinceTextView(mContext);
    view.setDate(new Date((mTime - 1 * 24 * 60 * 60) * 1000)); // 1 day
    assertThat(
        view.getText().toString(),
        is(TIMESPAN_DAY, String.valueOf(1)));
  }

  private static Matcher<String> is(String matcher, String... args) {
    return Is.is(
        String.format(matcher, args));
  }
}
