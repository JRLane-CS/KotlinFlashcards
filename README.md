# Kotlin Flashcards

## Purpose
After learning the basics of the Kotlin language, and since Kotlin is being promoted by Google to replace Java, I wanted to see what programming an Android smartphone in Kotlin would be like. It was enlightening and not in a good way. I found the Android structure to be more complex than it needed to be, but I was able to create a working Flashcard application using Kotlin.

## Description
This application features the ability to create, edit, load, save, and run a set of flashcards. The user begins by pressing Start on the Title page. This navigates to the second activity, the Flashcard Control page. A flashcard set of three questions and answers are programmed into the app by default, thus the run or edit activities are each available for use from the Control view. 

### Run
On the Run activity page, the flashcard set is displayed sequentially. The second flashcard will not be shown until the first has been correctly answered, the third won't be shown until the second is answered, etc. A toast is shown informing the user whether the answer was correct or incorrect. Once the last flashcard is answered correctly, the hint/question text area announces that all flashcards are finished and a toast is generated with the same message. The response text area instructs the user to press the Quit button. This ends this activity and sends the user back to the Control activity.

### Edit
When the Edit button is pressed, the Edit Flashcard activity begins. Here the user can navigate between the current flashcards using the Previous and Next buttons, delete a flashcard with the appropriately named Delete button, or accept a flashcard (in case it has been altered by the user or is a new one) using the Accept Flashcard button. Once the editing has been accomplished, the user presses the Done button to return to the Control activity.

### Load
If a flashcard set has been saved previously, the Load button will retrieve it and repopulate the questions and answers lists with the information. If there was no saved flashcard file, whatever flashcards, whether default or user entered, will remain and not be overwritten. A toast will inform the user of the operation.

### Save
Once the user has created a set of flashcards, pressing the Save button will store them in the application's shared preferences. If the user exits the app then presses the Save button, the default flashcard set will overwrite the one saved by the user, so caution should be used in utilizing this function. A toast informs the user of the successful save operation.

## Video Demo Link

[Software Demo Video](https://youtu.be/UGj-LJ9eyLk)

# Development Environment

This application was developed using Android Studio. It supports Android versions 19 and beyond, allowing for use on nearly 100% of current Android devices.

The language used to create this application was Kotlin.

# Useful Websites

{Make a list of websites that you found helpful in this project}
* [Web Site Name](http://url.link.goes.here)
* [Web Site Name](http://url.link.goes.here)

# Future Work

* Amend the Save function to accept a file name, allowing for more than one flashcard set to be stored
* Amend the Load function to prompt for a file name once the Save function has been amended
* Alter the way the Run Flashcard activity operates, allowing for navigation between questions instead of having to wait until the correct response is given before continuing
* Removing questions in the Run Flashcard activity so they won't show up if the user has previously correctly answered it, so if the user navigates backward, it won't appear