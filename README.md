# TimeSinceTextView
This is a subclass of android.widget.TextView which exposes a method `setDate()` which can take either a Unix timestamp (`long`) or `java.util.Date`. The view converts the date into a String which describes the date in terms of time since.

e.g. If the current timestamp is Unix 1453503166 and the time passed to `setDate()` is 1453503116, "50 seconds ago" is displayed.

## Usage

Simply declare a `TimeSinceTextView` in XML or create one in code.

    <com.ddiehl.timesincetextview.TimeSinceTextView
      android:id="@+id/comment_timestamp"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"/>
  
Then call `setDate(Date)` or `setDate(long)` with a Unix timestamp, and the text will be automatically generated and set to the view.

    ((TimeSinceTextView) findViewById(R.id.timestamp)).setDate(1452827942);

Abbreviated

To add to your project, simply add the following line to your `dependencies` block in your build.gradle file.

    compile 'com.github.damien5314:TimeSinceTextView:1.0.0'

## Screenshot
![Screenshot](/screenshots/1453502946.png)

## Contributions

Pull requests are welcome, in particular in would be nice to have [strings.xml](timesincetextview/src/main/res/values/strings.xml) translated into as many languages as possible.
