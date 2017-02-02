package com.ddiehl.timesincetextview.sample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;

import com.ddiehl.timesincetextview.TimeSinceTextView;

import java.util.Date;

import timesincetextview.sample.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long utc = new Date().getTime() / 1000;

        findView(R.id.time_now).setDate(utc);

        findView(R.id.time_seconds).setDate(utc - 30);
        findView(R.id.time_seconds_abbreviated).setDate(utc - 30);

        findView(R.id.time_minutes).setDate(utc - 5 * 60);
        findView(R.id.time_minutes_abbreviated).setDate(utc - 5 * 60);

        findView(R.id.time_hours).setDate(utc - 5 * 60 * 60);
        findView(R.id.time_hours_abbreviated).setDate(utc - 5 * 60 * 60);

        findView(R.id.time_days).setDate(utc - 3 * 24 * 60 * 60);
        findView(R.id.time_days_abbreviated).setDate(utc - 3 * 24 * 60 * 60);

        findView(R.id.time_weeks).setDate(utc - 2 * 7 * 24 * 60 * 60);
        findView(R.id.time_weeks_abbreviated).setDate(utc - 2 * 7 * 24 * 60 * 60);

        findView(R.id.time_months).setDate(utc - 6 * 30 * 24 * 60 * 60);
        findView(R.id.time_months_abbreviated).setDate(utc - 6 * 30 * 24 * 60 * 60);

        findView(R.id.time_years).setDate(utc - 4 * 52 * 7 * 24 * 60 * 60);
        findView(R.id.time_years_abbreviated).setDate(utc - 4 * 52 * 7 * 24 * 60 * 60);
    }

    private TimeSinceTextView findView(@IdRes int resId) {
        return (TimeSinceTextView) findViewById(resId);
    }
}
