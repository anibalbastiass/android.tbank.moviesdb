# Android Cool Movies
[![CircleCI](https://circleci.com/gh/anibalbastiass/android.tbank.moviesdb.svg?style=shield)](https://circleci.com/gh/anibalbastiass/android.tbank.moviesdb)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.3.72-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AndroidStudio-4.0.0-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-5.6.4-blue?style=flat)](https://gradle.org)

[![Build Status](https://app.bitrise.io/app/89cddb70fa2ebd1d/status.svg?token=KrUvhc9U7MEKHEnGo2oYSg)](https://app.bitrise.io/app/89cddb70fa2ebd1d)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/76fc2ca6929e4c1bbcb152a361cb711c)](https://app.codacy.com/manual/anibalbastiass/android.tbank.moviesdb?utm_source=github.com&utm_medium=referral&utm_content=anibalbastiass/android.tbank.moviesdb&utm_campaign=Badge_Grade_Dashboard)
[![CodeFactor](https://www.codefactor.io/repository/github/anibalbastiass/android.tbank.moviesdb/badge)](https://www.codefactor.io/repository/github/anibalbastiass/android.tbank.moviesdb)


Transbank CL Challenge technical test for Android Developer

The goal of the project is to demonstrate best practices by using up to date tech-stack and presenting modern Android application
[Architecture](#architecture) that is modular, scalable, maintainable, and testable. This application may look quite simple,
but it has all of these small details that will set the rock-solid foundation for the larger app suitable for bigger teams
and long [application lifecycle](https://en.wikipedia.org/wiki/Application_lifecycle_management).

This project is being maintained to match current industry standards and will be agregate more features as TV Series, Favorites and Profile.

## Project characteristics

This project brings to table set of best practices, tools, and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Modern architecture (dynamic feature modules, Clean Architecture, Model-View-ViewModel, Model-View-Intent)
* [Android Jetpack](https://developer.android.com/jetpack)
* A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
* Reactive UI
* CI pipeline
* Testing
* Static analysis tools
* Dependency Injection with KodeIn
* Material design

## Tech-stack

<img src="misc/image/application_anim1.gif" width="336" align="right" hspace="20">

Min API level is set to [`21`](https://android-arsenal.com/api?level=21), so the presented approach is suitable for over
[85% of devices](https://developer.android.com/about/dashboards) running Android. This project takes advantage of many
popular libraries and tools of the Android ecosystem. Most of the libraries are in the stable version unless there is a
good reason to use non-stable dependency.

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Kodein](https://kodein.org/Kodein-DI/) - dependency injection
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
  *   [Coil](https://github.com/coil-kt/coil) - image loading library with Kotlin idiomatic API
  *   [Lottie](http://airbnb.io/lottie) - animation library
    * [Stetho](http://facebook.github.io/stetho/) - application debugging tool
* Architecture
    * Clean Architecture (at module level)
    * MVVM + MVI (presentation layer)
    * [Dynamic feature modules](https://developer.android.com/studio/projects/dynamic-delivery)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
    * [Mockito](https://github.com/mockito/mockito) + [Mockito-Kotlin](https://github.com/nhaarman/mockito-kotlin)
    * [Kluent](https://github.com/MarkusAmshove/Kluent)
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Custom tasks
    * Plugins ([Ktlint](https://github.com/JLLeitschuh/ktlint-gradle), [Detekt](https://github.com/arturbosch/detekt#with-gradle), [Versions](https://github.com/ben-manes/gradle-versions-plugin), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args))

## Architecture

Feature related code is placed inside one of the feature modules.
We can think about each feature as the equivalent of [microservice](https://en.wikipedia.org/wiki/Microservices) or private library.

The modularized code-base approach provides few benefits:
- better [separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns). Each module has a clear API., Feature related classes life in different modules and can't be referenced without explicit module dependency.
- features can be developed in parallel eg. by different teams
- each feature can be developed in isolation, independently from other features
- faster compile time

### Module types and module dependencies

We have three kinds of modules in the application:

- `app` module - this is the main module. It contains code that wires multiple modules together (dependency injection setup, `NavHostActivity`, etc.) and fundamental application configuration (retrofit configuration, required permissions setup, custom application class, etc.).
- helper modules
  - application-independent `library_base` module containing common code base that could be reused in other projects/applications (this code is not specific to this application) eg. base classes, utilities, custom delegates, extensions.
  - additional application-specific `library_x` modules that some of the features could depend on. This is helpful if you want to share some assets or code only between few feature modules (currently app has no such modules)
- feature modules - the most common type of module containing all code related to a given feature.

### Feature module structure

`Clean architecture` is the "core architecture" of the application, so each `feature module` contains own set of Clean architecture layers:

#### Presentation layer

This layer is closest to what the user sees on the screen. The `presentation` layer is a mix of `MVVM` (Jetpack `ViewModel` used to preserve data across activity restart) and
`MVI` (`actions` modify the `common state` of the view and then new state is edited to a view via `LiveData` to be rendered).

> `common state` (for each view) approach derives from
> [Unidirectional Data Flow](https://en.wikipedia.org/wiki/Unidirectional_Data_Flow_(computer_science)) and [Redux
> principles](https://redux.js.org/introduction/three-principles).

Components:
- **View (Fragment)** - presents data on the screen and pass user interactions to View Model. Views are hard to test, so they should be as simple as possible.
- **ViewModel** - dispatches (through `LiveData`) state changes to the view and deals with user interactions (these view models are not simply [POJO classes](https://en.wikipedia.org/wiki/Plain_old_Java_object)).
- **ViewState** - common state for a single view
- **NavManager** - singleton that facilitates handling all navigation events inside `NavHostActivity` (instead of separately, inside each view)

#### Domain layer

This is the core layer of the application. Notice that the `domain` layer is independent of any other layers. This allows to make domain models and business logic independent from other layers.
In other words, changes in other layers will have no effect on `domain` layer eg. changing database (`data` layer) or screen UI (`presentation` layer) ideally will not result in any code change withing `domain` layer.

Components:
- **UseCase** - contains business logic
- **DomainModel** - defies the core structure of the data that will be used within the application. This is the source of truth for application data.
- **Repository interface** - required to keep the `domain` layer independent from the `data layer` ([Dependency inversion](https://en.wikipedia.org/wiki/Dependency_inversion_principle)).

#### Data layer

Manages application data and exposes these data sources as repositories to the `domain` layer. Typical responsibilities of this layer would be to retrieve data from the internet and optionally cache this data locally.

Components:
- **Repository** is exposing data to the `domain` layer. Depending on application structure and quality of the external APIs repository can also merge, filter, and transform the data. The intention of
these operations is to create high-quality data source for the `domain` layer, not to perform any business logic (`domain` layer `use case` responsibility).

- **Mapper** - maps `data model` to `domain model` (to keep `domain` layer independent from the `data` layer).
- **RetrofitService** - defines a set of API endpoints.
- **DataModel** - defines the structure of the data retrieved from the network and contains annotations, so Retrofit (Moshi) understands how to parse this network data (XML, JSON, Binary...) this data into objects.

## Ci pipeline

[CI pipeline](circle.yml) verifies project correctness which each PR. Some of the tasks run in parallel, while
others like `app build` will not be stared until all `static checks` and `tests` complete successfully:


These are all of the Gradle tasks (cmd commands) that are [executed by CI](/circle.yml):
* `./gradlew lintDebug` - runs Android lint
* `./gradlew detekt` - runs detekt
* `./gradlew ktlintCheck` - runs ktlint
* `./gradlew testDebugUnitTest` - run unit tests
* `./gradlew :app:bundleDebug` - create app bundle

On top of that project contains a custom `./gradlew staticCheck` task that mimics all CI tasks and is intended to run on
a local computer.

## Getting started

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/anibalbastiass/android.tbank.moviesdb.git` into URL field

## Known issues
- Keep Fragment stack for each dynamic navigator graph
