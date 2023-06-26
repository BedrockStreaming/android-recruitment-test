# Superhero Application

You are to make an Android application which will display information about superheros. The
application will be composed of two screens.
The first screen will display a list of superheroes with basic information. The second screen will
display more details about a specific hero.
API documentation for the data can be found here: https://akabab.github.io/superhero-api/api/

### List screen

Upon launch, the application should make a call to
`https://akabab.github.io/superhero-api/api/all.json` to fetch data.
It should then display a vertical list of superheroes. Each entry in the list should display the
superhero's "hero name" and an image.

### Details screen

After clicking on a hero entry in the List page, the app should display make a call
to the API to fetch the details of the superhero in the online database.
The details screen should display the information from that call.

### Search

The List screen should have a search box that enables to search for a specific hero name.
The search should be performed on the client side, without making a network call.

### Landscape mode

When used on a large screen, the application should split the screen in half to display the list
screen on the left side and the details screen on the right side.

### Functional Requirements

- UI choices are up to you
- The application should not crash or stop responding under any circumstance.
- The application should display an error when there is no network connection.
- The application should not make the same network call multiple times.

### Technical requirements

- Kotlin
- Should use dependency injection
- The choice of technology and library is up to you
