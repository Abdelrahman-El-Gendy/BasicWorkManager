# WorkManager
- WorkManager is an Android Jetpack library that runs deferrable, guaranteed background work when the work’s constraints are satisfied. 
- One of the Android Jetpack Component.
 * It is the current best practice for this kind of work on Android.
 * runs deferrable backgroind work when thw work's constraints are satisfied.
 * Intended for tasks that require a guarentee that the system run them even if the app exist.
 * WorkManager provides a battery-friendly API that encapsulates years of evolution of Android's background behaviour restrictions ,this is critical for Android Apps        that need  to execute the background tasks

## Usage
* WorkManger runs tasks in the background to avoid doing too much work on the main Thread (UI Thread).
* WorkManager handles background work that needs to run when various constraints are met, regardless of whether the application process is alive or not. 
* Background work can be started when the app is in the background, when the app is in the foreground, or when the app starts in the foreground but goes to the background. 
* Regardless of what the application is doing, background work should continue to execute, or be restarted if Android kills its process.

* A common confusion about WorkManager is that it’s for tasks that needs to be run in a “background” thread but don’t need to survive process death. This is not the case. 
* There are other solutions for this use case like Kotlin’s coroutines, ThreadPools, or libraries like RxJava. 
* You can find more information about this use case in the guide to background processing.

* There are many different situations in which you need to run background work, and therefore different solutions for running background work. 
* This blog post about background processing provides a lot of great information about when to use WorkManager. Take a look at this diagram from the blog:<br>
![image](https://user-images.githubusercontent.com/73541296/221368673-e0e820fa-1d18-4075-a3db-33396e650405.png)

## Scheduling Background Tasks
<ol>
  <li>AlarmManager : Schedule work to repeat at specified intervaks.</li>
  
  <li>Async Task : The API for Async Task comes with a sleep learning curve.</li>
  
  <li>Job Scheduler : Fixes some of the issues of the AlarmManager in AsyncTask , and adds  new feature.</li>
 </ol>
## Using WorkManager
<ol>
  <li>Describe the Work (background Task) to be done</li>
  
  <li>Create a Work request to define the conditions of the work.</li>
  
  <li>You 'll need an instance of a WorkManager to schedule the work request</li>
 </ol>
 
 ## Example
 ### Worker.kt
 
 ```kt
class MyWorker: Worker {
override fun doWork(): Result {
// do the work!
/**
  val data = inputData.getString("KEY")
**/
return Result.success()
  }
}  
 ```
### MainActivity.kt
```kt
class MainActivity : AppCompatActivity() {
  // The Instance of the WorkManager is a singleTon pattern that exists for the Life Cycle of the App.
  val workManager = WorkManager
    .getInstance(this)
    
  fun startWork() {
  /**
     val data = Data.Builder(...)
     .build()
  **/   
     val workRequest = OneTimeWorkRequest
       .Builder(...)
       .setInputData(data)
       .build()
    workManager.enqueue(workRequest)
    }
}
```
<details>
<summary><strong>More Details</strong></summary>
  <ul>
    <li> Pluralsight Course : <a href="https://app.pluralsight.com/library/courses/workmanager-coroutines-background-jobs-performing/table-of-contents"> 
      Click Here </a> </li>
    <li> Medium Article : <a href="https://medium.com/androiddevelopers/introducing-workmanager-2083bcfc4712">Click Here </a> </li>
    <li> Android Developers : <a href="https://developer.android.com/reference/androidx/work/WorkManager"> Click Here </a> </li>
  </u>
</details>

