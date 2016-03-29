package com.ddiehl.timesincetextview;

import android.content.Context;
import android.support.annotation.PluralsRes;
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
        is(mContext.getString(R.string.timespan_now)));
  }

  @Test
  public void getFormattedDateString_11seconds() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 11, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_seconds, 11)));
  }

  @Test
  public void getFormattedDateString_59seconds() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 59, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_seconds, 59)));
  }

  @Test
  public void getFormattedDateString_1minute() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_minutes, 1)));
  }

  @Test
  public void getFormattedDateString_59minutes() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_minutes, 59)));
  }

  @Test
  public void getFormattedDateString_1hour() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_hours, 1)));
  }

  @Test
  public void getFormattedDateString_23hours() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_hours, 23)));
  }

  @Test
  public void getFormattedDateString_1day() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_days, 1)));
  }

  @Test
  public void getFormattedDateString_6days() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_days, 6)));
  }

  @Test
  public void getFormattedDateString_1week() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_weeks, 1)));
  }

  @Test
  public void getFormattedDateString_4weeks() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_weeks, 4)));
  }

  @Test
  public void getFormattedDateString_1month() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_months, 1)));
  }

  @Test
  public void getFormattedDateString_12months() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60 + 1, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_months, 12)));
  }

  @Test
  public void getFormattedDateString_1year() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_years, 1)));
  }

  @Test
  public void getFormattedDateString_30years() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 30 * 365 * 24 * 60 * 60, mTime, false, mContext),
        is(getQuantityString(R.plurals.timespan_years, 30)));
  }

  @Test
  public void getFormattedDateString_abbrev() {
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 59, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_seconds_abbr, 59)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_minutes_abbr, 1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_hours_abbr, 1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_days_abbr, 1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 7 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_weeks_abbr, 1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 30 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_months_abbr, 1)));
    assertThat(
        TimeSinceTextView.getFormattedDateString(
            mTime - 1 * 365 * 24 * 60 * 60, mTime, true, mContext),
        is(getQuantityString(R.plurals.timespan_years_abbr, 1)));
  }

  @Test
  public void setDate_long() {
    TimeSinceTextView view = new TimeSinceTextView(mContext);
    view.setDate(mTime - 1 * 24 * 60 * 60); // 1 day
    assertThat(
        view.getText().toString(),
        is(getQuantityString(R.plurals.timespan_days, 1)));
  }

  @Test
  public void setDate_java_util_date() {
    TimeSinceTextView view = new TimeSinceTextView(mContext);
    view.setDate(new Date((mTime - 1 * 24 * 60 * 60) * 1000)); // 1 day
    assertThat(
        view.getText().toString(),
        is(getQuantityString(R.plurals.timespan_days, 1)));
  }

  private static Matcher<String> is(String matcher, Object... args) {
    return Is.is(
        String.format(matcher, args));
  }

  private String getQuantityString(@PluralsRes int resId, int n) {
    return mContext.getResources().getQuantityString(resId, n, n);
  }
}
