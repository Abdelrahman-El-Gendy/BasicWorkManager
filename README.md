# WorkManager
- WorkManager is an Android Jetpack library that runs deferrable, guaranteed background work when the work’s constraints are satisfied. 
It is the current best practice for this kind of work on Android

#usage
-WorkManager handles background work that needs to run when various constraints are met, regardless of whether the application process is alive or not. 
Background work can be started when the app is in the background, when the app is in the foreground, or when the app starts in the foreground but goes to the background. 
Regardless of what the application is doing, background work should continue to execute, or be restarted if Android kills its process.

A common confusion about WorkManager is that it’s for tasks that needs to be run in a “background” thread but don’t need to survive process death. This is not the case. 
There are other solutions for this use case like Kotlin’s coroutines, ThreadPools, or libraries like RxJava. 
You can find more information about this use case in the guide to background processing.

There are many different situations in which you need to run background work, and therefore different solutions for running background work. 
This blog post about background processing provides a lot of great information about when to use WorkManager. Take a look at this diagram from the blog:
![image](https://user-images.githubusercontent.com/73541296/221368673-e0e820fa-1d18-4075-a3db-33396e650405.png)


