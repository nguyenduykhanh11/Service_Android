package com.example.service_demo

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    companion object{
        const val TAG = "this"
    }
    private var  handler: Handler? = null
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d(TAG, "OnCreate Service")
        handler = Handler()
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand MyService")
        removeHandler()
        var i = 0
        handler?.postDelayed(object : Runnable{
            override fun run() {
                try {
                    Log.d(TAG, "Log lần $i")
                    i++
                    handler!!.postDelayed(this, 10000)
                }catch (e: Exception){
                    Log.d(TAG, e.toString())
                }
            }
        }, 0)
        return START_NOT_STICKY
    }

    private fun removeHandler() {
        if(handler !=null){
            handler!!.removeCallbacksAndMessages(null)
        }
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy MyService")
        removeHandler()
        super.onDestroy()
    }
}