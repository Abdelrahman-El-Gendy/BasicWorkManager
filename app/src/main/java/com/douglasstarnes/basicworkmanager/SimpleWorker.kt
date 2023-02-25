package com.douglasstarnes.basicworkmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

// 1- Define a worker Class that describe the work (background task) to be don
class SimpleWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {
        val message = inputData.getString("WORK_MESSAGE")
        Thread.sleep(1_000)
        WorkStatusSingleton.workComplete = true
        if (message != null) {
            WorkStatusSingleton.workMessage = message
        }
        return Result.success()
    }
}


//class SimpleWorker(context: Context, params: WorkerParameters): Worker(context, params) {
//    override fun doWork(): Result {
//        val message = inputData.getString("WORK_MESSAGE")
////        Thread.sleep(10000)
//        WorkStatusSingleton.workComplete = true
//        if (message != null) {
//            WorkStatusSingleton.workMessage = message
//        }
//        return Result.success()
//    }
//}