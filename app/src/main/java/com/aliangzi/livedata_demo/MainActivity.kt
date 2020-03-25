package com.aliangzi.livedata_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mainViewModel= ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        mainViewModel.liveDataI.observe(this, Observer {
            numberDisplay.text = it.toString()
        })
        stop.setOnClickListener { mainViewModel.stop() }
        start.setOnClickListener { mainViewModel.start() }
    }
}
