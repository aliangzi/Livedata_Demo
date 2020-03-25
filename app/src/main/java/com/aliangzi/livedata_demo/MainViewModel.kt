package com.aliangzi.livedata_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author glsite.com
 * @version $
 * @des
 * @updateAuthor $
 * @updateDes
 */
class MainViewModel:ViewModel() {
    val liveDataI = MutableLiveData<Int>()
    var stop = false

    fun start(){
        stop = false
        liveDataI.postValue(0)
        object :Thread(){
            override fun run() {
                while (!stop){
                    Thread.sleep(3000)
                    val value = liveDataI.value
                    if (value != null) {
                        liveDataI.postValue(value+1)
                    }
                }
            }
        }.start()
    }

    fun stop(){
        stop = true
    }
}