package com.example.counter2

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = 0
    var boolean = false

    fun plus(){
        ++count
    }
    fun minus(){
        --count
    }
    fun toast(context: Context){
        if (count == 10){
            Toast.makeText(context, "Ура, получилось", Toast.LENGTH_SHORT).show()
        }
    }
    fun changeColor():Boolean{
        if (count>9){
            boolean = true
        }else boolean = false
        return boolean
    }
    fun getCount():Int{
        return count
    }
}