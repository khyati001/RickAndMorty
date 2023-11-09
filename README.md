# RickAndMortyApp

The primary objective of this Android application is to demonstrate the seamless integration of several powerful technologies and architectural patterns, including Retrofit, Kotlin, MVVM, Coroutines, Dagger2, and Jetpack Compose. Focused on the popular Rick and Morty TV series, the app fetches images and data from a REST API using Retrofit within the context of the MVVM design pattern. For efficient image loading, the application leverages the Coil image loading library. Jetpack Compose is employed to elegantly and dynamically present the fetched data on the user interface, creating a modern and engaging user experience.

# What is MVVM
Each component has its own responsibilities to do their task

- The **View** receives user action and send it to the ViewModel, or listen live data stream from ViewModel and shows it to user.
- The **ViewModel** receives user actions from the View or provides data to View.
- The **Model** abstract the data sourec. We write our business logic here and both View and ViewModel uses that to stream data.

# Jetpack Compose
- Jetpack compose is the new way to build UI for your android applications in a declarative manner. Now no more XML needed and you can build Android apps without construct the XML layout code.
- Jetpack Compose is a modern declarative UI Toolkit for Android. Compose makes it easier to write and maintain your app UI by providing a declarative API that allows you to render your app UI without imperatively mutating frontend views.

# Coroutines
A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously. Coroutines were added to Kotlin in version 1.3 and are based on established concepts from other languages. Coroutines is our recommended solution for asynchronous programming on Android. Noteworthy features include the following:

- **Lightweight**: You can run many coroutines on a single thread due to support for suspension, which doesn't block the thread where the coroutine is running. Suspending saves memory over blocking while supporting many concurrent operations.
- **Fewer memory leaks**: Use structured concurrency to run operations within a scope.
- **Built-in cancellation support**: Cancellation is propagated automatically through the running coroutine hierarchy.
- **Jetpack integration**: Many Jetpack libraries include extensions that provide full coroutines support. Some libraries also provide their own coroutine scope that you can use for structured concurrency.

# Coil
An image loading library for Android backed by Kotlin Coroutines. Coil is:

- **Fast**: Coil performs a number of optimizations including memory and disk caching, downsampling the image in memory, automatically pausing/cancelling requests, and more.
- **Lightweight**: Coil adds ~2000 methods to your APK (for apps that already use OkHttp and Coroutines), which is comparable to Picasso and significantly less than Glide and Fresco.
- **Easy to use**: Coil's API leverages Kotlin's language features for simplicity and minimal boilerplate.
- **Modern**: Coil is Kotlin-first and uses modern libraries including Coroutines, OkHttp, Okio, and AndroidX Lifecycles.

# Dagger
Dagger 2 is a compile-time android dependency injection framework and uses the JSR 330 and uses an annotation processor.

# Retrofit

 [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.



