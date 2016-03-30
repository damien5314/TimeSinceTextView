# TimeSinceTextView

This is a subclass of android.widget.TextView that exposes a method `setDate()` which accepts a `long` Unix timestamp or `java.util.Date`. The view converts the date into a String which describes the date in terms of time since that timestamp. For example, if the current timestamp is Unix 1453503166 and we call `timeSinceTextView.setDate(1453503116)`, "50 seconds ago" is displayed.

[Changelog](CHANGELOG.md)

[Javadoc](https://jitpack.io/com/github/damien5314/TimeSinceTextView/1.2.3/javadoc/)

## Comparison to DateUtils.getRelativeTimeSpanString

I actually wrote this library before I knew about [DateUtils.getRelativeTimeSpanString](http://developer.android.com/reference/android/text/format/DateUtils.html#getRelativeDateTimeString), but the output is actually quite a bit different. The DateUtils implementation should return localized text and allows for customizable flags. See [here](Comparison.md) for a comparison of the output of different time stamps.

## Usage

Simply declare a `TimeSinceTextView` in XML or create one in code.

```xml
<com.ddiehl.timesincetextview.TimeSinceTextView
  android:id="@+id/timestamp"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content" />
```

Then call `setDate(Date)` or `setDate(long)` with a Unix timestamp, and the text will be automatically generated and set to the view.

```java
((TimeSinceTextView) findViewById(R.id.timestamp)).setDate(1452827942);
```

To get an abbreviated form of the converted text, add `app:abbreviated="true"` to your XML layout.

```xml
<com.ddiehl.timesincetextview.TimeSinceTextView
  xmlns:app="http://schemas.android.com/apk/res-auto"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  app:tstv_abbreviated="true" />
```

The class `TimeSince` also contains static methods which can be used to retrieve a relative timestamp string without an instance of `TimeSinceTextView`.

## Add to your project

[![Release](https://jitpack.io/v/damien5314/TimeSinceTextView.svg)](https://jitpack.io/#damien5314/TimeSinceTextView)

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
dependencies {
  compile 'com.github.damien5314:TimeSinceTextView:1.+'
}
```

![Screenshot](/screenshots/1453502946.png)

## Contributions

Pull requests are welcome, in particular in would be nice to have [strings.xml](timesincetextview/src/main/res/values/strings.xml) translated into as many languages as possible.
