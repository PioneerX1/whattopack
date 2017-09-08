## WhatToPack

An Android app that recommends clothing to pack for each day of travel based on location and weather factors like temperature, humidity, and precipitation.

#### By _**Mick Sexton**_

### Description

Users can input their travel destination along with dates. These dates should be within the forecastable future. WhatToPack will create a list for each day of what the user should wear based on local weather conditions.

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](https://git-scm.com/)
* Android Studio
* working Android emulator (or device)

## Installation

* Download app from GitHub repo: https://github.com/PioneerX1/whattopack
* Open with Android Studio
* Run app on an emulator or Android device

## Code Specs

|Behavior - Plain English|Input|Output|
|---|---|---|
|User opens app, sees home view stating purpose of WhatToPack.|User taps button Lets Go Already to get started.|User sees Location view, where they input a location, or get ideas for places to go.|
|User sees location view.|User inputs a location like Paris or Alaska and taps Where button.|User then sees a dates view asking for the dates they plan to travel.|
|User sees dates view.|User inputs the dates they plan to travel and taps When button.|User then sees the purpose view, asking for their purpose of travel - business, casual, outdoor activity.|
|User sees purpose view.|User selects their purpose and taps Why button.|User sees a summary of their input.|
|User sees location view.|User taps Need Ideas? button.|User sees the ideas view with a list of possible places and activities.|


## Known Bugs

_No known bugs or issues at this time._

## Support and contact details

_Please contact Mick Sexton at lacrookedbeat@hotmail.com for any questions, feedback, or concerns._

## Technologies Used

_Technologies used include Java, Android Studio, XML, and Git_

### License

*This software operates under the MIT license.*

Copyright (c) 2017 **_Mick Sexton_**




##### Internal Developer Notes #####

    Before Day 2:
    - Look into Date picker fragment for Android XML
    - Test DarkSky and AccuWeather with Postman


    Day 1:
    https://github.com/PioneerX1/whattopack.git


    1. Welcome - WhatToPack helps travelers plan for local weather conditions and pack accordingly
    2. What’s your Destination?
    3. What dates will you be there?
    4. **Optional for now — Purpose of trip? (business, casual, outdoor active)
    5. Output(for now just list the destination and dates)


    WhatToPack
    —

    User inputs a location they are traveling to and dates for the trip (must be within API forecast window).
    App recommends what to wear on each day based on temperature, humidity, and precipitation.
    Outputs this data in the form of a list for each day.

    Bonus:
    Recommendations also take into account the activities of user (outdoor hiking vs business meetings).
    App can let users customize based on their individual temperatures (some run hotter or colder).
    App can break down what to wear based on highs or lows of the day (mid-afternoon vs morning vs night).
    Advertising based on clothing needs.