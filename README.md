# Bedrock Android recruitment test

Your task is to write an Android application composed of two screens. A main screen which displays a
list of numbers and a details screen showing information about a specific number.
The application should support Android phones and tablets. Please read functional and technical
requirements carefully.

**[Create a new project using this repository as a template](https://github.com/BedrockStreaming/android-recruitment-test/generate)**,
and deliver a link to the final source code (either a public repo or a tarball).

## Functional requirements

### Main screen

- The main screen should display a list of numbers and images
- A web service for the list is available here: `http://dev.tapptic.com/test/json.php`
    - It returns a JSON array of objects. Each object represents a number. A number has a name and
      an image.
    - Each number (name & image) should be displayed on a separate row
- Rows should be highlighted when users click on it (3 states - normal, focused,
  clicked / selected)
    - Each state should have a different color
    - Clicked / selected state should only be visible on tablets in landscape mode - see below
- Clicking on an item of the list should open / display the details screen

### Details screen

- Details screen should display data downloaded
  from `http://dev.tapptic.com/test/json.php?name=xxx`, where `xxx` is a number’s name field.
- Please display a large image and the name (text) below it.

### Screen rotation / tablets

a. On a tablet in landscape mode, the list and details screens should be displayed side by side,
each taking 50% of the available screen width.

- On a tablet in portrait mode, the application should have the same behavior as on a phone 
  (clicking on an item of the main screen opens the details screen and both screens are never
  displayed at the same time).
- On a tablet, when changing the device orientation from portrait to landscape while displaying the
  details screen, the application should display the list and details screens together as explained
  in point a. The details screen in landscape mode should then display the same content which was
  previously displayed in portrait mode.

### Network errors & retry

- Please display an error when there is no network connection
- The application should either retry to download data automatically (when network is available) or
  display a button that will allow user to retry manually.

## Additional functional requirements (nice to have)

- Use a pager in the details screen in order to make it possible to navigate to other numbers
  details directly from this screen (by swiping the pager). On a tablet in landscape mode, the
  selected row of the main list should always correspond to the number details displayed in the
  details screen.

## Technical (non-functional) requirements

- Kotlin or Java
- Android Studio / Gradle
- Although this application is very simple, please architecture it as if it was a big project
  with long term maintenance.
- Support Android 5, API 21+
- Support any screen size & resolution
- There should be no ANR
- Application should not crash under any circumstances

## Additional technical requirements (nice to have)

- Use dependency injection
- Write unit tests for at least one class
- Use both Java and Kotlin
    - If you are using Java for this project, then write one class in Kotlin
    - If you are using Kotlin for this project, then write one class in Java
    - Make sure that this "one class" is used

## FAQ

### UI Design?

It is not very important, application can use default Android components, please do not spend too
much time on it, as it is not the purpose of this task.

### What is most important?

- Meeting functional & technical requirements
- Clean code
- Proper architecture

If you have any notes or want to make some assumptions for this project, then please add a README
file to the project’s root directory.
