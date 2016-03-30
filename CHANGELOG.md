Change Log
==========

Version 1.2.1 *(2016-03-29)*
----------------------------------
* Renamed string resources to avoid clashing in other libraries

Version 1.2.0 *(2016-03-29)*
----------------------------------
* Added Spanish translation (courtesy of @JorgeDLS)
* Added Japanese translation
* **BREAKING** Renamed `abbreviated` attribute to `tstv_abbreviated` in order to prevent clashing with other libraries. This is not backwards compatible.
* Added methods `setAbbreviated`, `isAbbreviated`, and `getDate`.
* Static utility methods in `TimeSinceTextView` are deprecated in favor those in `TimeSince`.
* Added source code to distribution .aar (how did no one ask for this?)
* Added Javadoc to distribution .aar
* Added Apache 2.0 license, not that I really care what you do with this code.

Version 1.1.1 *(2016-02-07)*
----------------------------------
* Added Russian translation (courtesy of @vkotovv)

Version 1.1.0 *(2016-01-27)*
----------------------------------
* Added Simplified Chinese translation (thanks @jewelzqiu!)
* Switched from simple string resources to plural resources which can be more accurately localized in all languages.
* Switched from using long to int in timespan calculation which should improve memory footprint.

Version 1.0.1 *(2016-01-23)*
----------------------------------
* Exposed static method in TimeSinceTextView class for converting a timestamp to String without using the TextView directly.

Version 1.0.0 *(2016-01-22)*
----------------------------------
* Initial release
