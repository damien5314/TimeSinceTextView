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

    /**
     * @return Unix timestamp associated with this instance, or seconds since January 1, 1970
     */
    public long getDate() {
        return mTimestamp;
    }

    /**
     * Sets the timestamp displayed by this view
     *
     * @param date {@link java.util.Date} from which to calculate time passed
     */
    public void setDate(Date date) {
        setDate(date.getTime() / 1000);
    }

    /**
     * Sets the timestamp displayed by this view
     *
     * @param utc Unix timestamp from which to calculate time passed
     */
    public void setDate(long utc) {
        mTimestamp = utc;
        setText(TimeSince.getFormattedDateString(utc, mAbbreviated, getContext()));
        setContentDescription(TimeSince.getFormattedDateString(utc, false, getContext()));
    }

    /**
     * @return True if view is displaying abbreviated timestamp strings, otherwise false
     */
    public boolean isAbbreviated() {
        return mAbbreviated;
    }

    /**
     * Set to true if the view should display abbreviated timestamp strings
     *
     * @param b True if the view should display abbreviated timestamp strings
     */
    public void isAbbreviated(boolean b) {
        mAbbreviated = b;
        invalidate();
        requestLayout();
    }

    /**
     * @deprecated Use {@link TimeSince#getFormattedDateString(long, boolean, Context)}
     */
    @Deprecated
    public static String getFormattedDateString(long utc, boolean abbreviated, Context context) {
        return TimeSince.getFormattedDateString(utc, abbreviated, context);
    }

    /**
     * @deprecated Use {@link TimeSince#getFormattedDateString(long, long, boolean, Context)}
     */
    @Deprecated
    public static String getFormattedDateString(
            long start, long end, boolean abbreviated, Context context) {
        return TimeSince.getFormattedDateString(start, end, abbreviated, context);
    }
}
