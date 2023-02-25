package com.douglasstarnes.basicworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.contentcapture.DataShareWriteAdapter
import android.widget.Button
import android.widget.Toast
import androidx.work.*
import java.net.HttpRetryException
import java.util.concurrent.TimeUnit
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    // 3- Getting an Instance of a WorkManager
    val workManager = WorkManager.getInstance(this)
    lateinit var btnStartWork: Button
    lateinit var btnWorkStatus: Button
    lateinit var btnResetStatus: Button
    lateinit var btnWorkUIThread: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartWork = findViewById(R.id.btnStartWork)
        btnWorkStatus = findViewById(R.id.btnWorkStatus)
        btnResetStatus = findViewById(R.id.btnResetStatus)
        btnWorkUIThread = findViewById(R.id.btnWorkUIThread)

        btnStartWork.setOnClickListener {

//            val data = Data.Builder()
//                .putString("WORK_MESSAGE" , "Work Complete !")
//                .build()
            // By using a Kotlin Extension
            val database = workDataOf("WORK_MESSAGE" to "Work Complete !")

            // 2- Create a workRequest to define the Conditions of the work
            val workRequest = OneTimeWorkRequestBuilder<SimpleWorker>()
                .setInputData(database)
                .build()
            val periodicWorkRequest =
                PeriodicWorkRequestBuilder<SimpleWorker>(
                    5, TimeUnit.MINUTES, 1, TimeUnit.MINUTES
                ).build()
            // The workManager will schedule the the work request and eventually complete the Work.
            workManager.enqueue(workRequest)


         workManager.enqueue(workRequest)
        }

        btnWorkStatus.setOnClickListener {
            val toast = Toast.makeText(
                this,
                "The work status is: ${WorkStatusSingleton.workMessage}",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }

        btnResetStatus.setOnClickListener {
            WorkStatusSingleton.workComplete = false
        }

        btnWorkUIThread.setOnClickListener {
            Thread.sleep(10000)
            WorkStatusSingleton.workComplete = true
        }
    }
}

//            val workRequest = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
//            val data = Data.Builder()
//                .putString("WORK_MESSAGE", "Work Completed!")
//                .build()
//            val constraints = Constraints.Builder()
//                .setRequiresCharging(true)
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .build()
//            val data = workDataOf("WORK_MESSAGE" to "Work Completed!")
//            val workRequest = OneTimeWorkRequestBuilder<SimpleWorker>()
//                .setInputData(data)
//                .setConstraints(constraints)
//                .build()
//            val periodicWorkRequest = PeriodicWorkRequestBuilder<SimpleWorker>(
//                5, TimeUnit.MINUTES,
//                1, TimeUnit.MINUTES
//            ).build()
//