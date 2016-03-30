package com.ddiehl.timesincetextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Date;

public class TimeSinceTextView extends TextView {

  private long mTimestamp = 0;
  private boolean mAbbreviated = false;

  public TimeSinceTextView(Context context) {
    super(context);
    init(context, null, 0, 0);
  }

  public TimeSinceTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, 0, 0);
  }

  public TimeSinceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr, 0);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public TimeSinceTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context, attrs, defStyleAttr, defStyleRes);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    if (attrs != null) {
      TypedArray ta = context.getTheme()
          .obtainStyledAttributes(attrs, R.styleable.TimeSinceTextView, 0, 0);
      mAbbreviated = ta.getBoolean(R.styleable.TimeSinceTextView_tstv_abbreviated, false);
    }
  }

  public long getDate() {
    return mTimestamp;
  }

  public void setDate(Date date) {
    setDate(date.getTime() / 1000);
  }

  public void setDate(long utc) {
    mTimestamp = utc;
    setText(
        TimeSince.getFormattedDateString(
            utc, mAbbreviated, getContext()));
  }

  public boolean isAbbreviated() {
    return mAbbreviated;
  }

  public void isAbbreviated(boolean b) {
    mAbbreviated = b;
    invalidate();
    requestLayout();
  }
}
