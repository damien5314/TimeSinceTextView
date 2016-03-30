package com.ddiehl.timesincetextview;

import android.content.Context;
import android.support.annotation.PluralsRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class TimeSinceTextViewAndroidTest {
  private static Context mContext;
  private final long mTime = new Date().getTime() / 1000;

  @BeforeClass
  public static void setUpClass() {
    mContext = InstrumentationRegistry.getContext();
  }

  @AfterClass
  public static void tearDownClass() {

  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void getFormattedDateString_now() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 10, mTime, false, mContext),
        is(mContext.getString(R.string.tstv_timespan_now)));
  }

  @Test
  public void getFormattedDateString_11seconds() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 11, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_seconds, 11)));
  }

  @Test
  public void getFormattedDateString_59seconds() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 59, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_seconds, 59)));
  }

  @Test
  public void getFormattedDateString_1minute() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_minutes, 1)));
  }

  @Test
  public void getFormattedDateString_59minutes() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_minutes, 59)));
  }

  @Test
  public void getFormattedDateString_1hour() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_hours, 1)));
  }

  @Test
  public void getFormattedDateString_23hours() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_hours, 23)));
  }

  @Test
  public void getFormattedDateString_1day() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_days, 1)));
  }

  @Test
  public void getFormattedDateString_6days() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_days, 6)));
  }

  @Test
  public void getFormattedDateString_1week() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_weeks, 1)));
  }

  @Test
  public void getFormattedDateString_4weeks() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_weeks, 4)));
  }

  @Test
  public void getFormattedDateString_1month() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_months, 1)));
  }

  @Test
  public void getFormattedDateString_12months() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_months, 12)));
  }

  @Test
  public void getFormattedDateString_1year() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_years, 1)));
  }

  @Test
  public void getFormattedDateString_30years() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 30 * 365 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_years, 30)));
  }

  @Test
  public void getFormattedDateString_abbrev() {
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 59, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_seconds_abbr, 59)));
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_minutes_abbr, 1)));
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_hours_abbr, 1)));
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_days_abbr, 1)));
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_weeks_abbr, 1)));
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_months_abbr, 1)));
    assertThat(
        TimeSince.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.tstv_timespan_years_abbr, 1)));
  }

  @Test
  public void setDate_long() {
    TimeSinceTextView view = new TimeSinceTextView(mContext);
    view.setDate(mTime - 1 * 24 * 60 * 60); // 1 day
    assertThat(
        view.getText().toString(),
        is(getQuantityString(R.plurals.tstv_timespan_days, 1)));
  }

  @Test
  public void setDate_java_util_date() {
    TimeSinceTextView view = new TimeSinceTextView(mContext);
    view.setDate(new Date((mTime - 1 * 24 * 60 * 60) * 1000)); // 1 day
    assertThat(
        view.getText().toString(),
        is(getQuantityString(R.plurals.tstv_timespan_days, 1)));
  }

  private static Matcher<String> is(String matcher, Object... args) {
    return Is.is(
        String.format(matcher, args));
  }

  private String getQuantityString(@PluralsRes int resId, int n) {
    return mContext.getResources().getQuantityString(resId, n, n);
  }
}
