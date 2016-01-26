
Output of `DateUtils.getRelativeTimeSpanString(long)` vs `TimeSinceTextView.getFormattedDateString(long, ...)`

| Time Since              | DateUtils      | TimeSinceTextView |
| ----------------------- | -------------- | ----------------- |
| 10s ago                 | 0 minutes ago  | just now          |
| 11s ago                 | 0 minutes ago  | 11 seconds ago    |
| 59s ago                 | 0 minutes ago  | 59 seconds ago    |
| 60s ago                 | 1 minute ago   | 1 minute ago      |
| 59m, 59s ago            | 59 minutes ago | 59 minutes ago    |
| 60m ago                 | 1 hour ago     | 1 hour ago        |
| 23h, 59m, 59s ago       | 23 hours ago   | 23 hours ago      |
| 24h ago                 | Yesterday      | 1 day ago         |
| 6d, 23h, 59m, 59s ago   | 7 days ago     | 6 days ago        |
| 7d ago                  | Jan 18, 2016   | 1 week ago        |
| 29d, 23h, 59m, 59s ago  | Dec 26, 2015   | 4 weeks ago       |
| 30d ago                 | Dec 26, 2015   | 1 month ago       |
| 364d, 23h, 59m, 59s ago | Jan 25, 2015   | 12 months ago     |
| 365d ago                | Jan 25, 2015   | 1 year ago        |
| 30yr ago                | Feb 1, 1986    | 30 years ago      |
