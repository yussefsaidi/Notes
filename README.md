## Notes
Android app to take down notes on the go.

## Screenshots
<p>
  <img src="/Screenshots/Screenshot_1582319780.png" width="270" height="450"/>
  <img src="/Screenshots/Screenshot_1582319789.png" width="270" height="450"/>
  <img src="/Screenshots/Screenshot_1582319798.png" width="270" height="450"/>
</p>

## Installation
Git clone the repository, import project in Android Studio, and run on an android device.

## Architecture Overview
This application makes use of the MVVM architectural pattern. 
Our project follows: Activity -> ViewModel -> Repository -> Remote Data Source -> Retrofit -> Webservice.
LiveData is retrieved from the Remote Data Source into our repository, then it trickles down all the way to our ViewModel. The activities do not hold data.

TO DO: Adding a local database cache using Room Persistence Library.

## External Dependencies

- [Room](https://developer.android.com/topic/libraries/architecture/room)
: Local data storage for our notes.

## Tests

Test: Swipe a note to the right to delete it.
Test: Press on the Floating Action Button to add a new note and enter edit mode.
Test: Fill out the note information (title and information), and press the checkmark.
Test: Open and view a note by clicking on it.
Test: Edit a note either by double clicking the body, or by single clicking the title.

## License
© [Yussef Saidi](https://yussefsaidi.me/)

