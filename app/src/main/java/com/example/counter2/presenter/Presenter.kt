package com.example.counter2.presenter

import android.content.Context
import com.example.counter2.CounterView
import com.example.counter2.Injector
import com.example.counter2.MainActivity

class Presenter {
    val model = Injector.getModel()
    lateinit var view : CounterView
    fun increment(){
        model.increment()
        view.updateCount(model.getCount().toString())
    }
    fun decrement(){
        model.decrement()
        view.updateCount(model.getCount().toString())
    }
    fun toast(context: Context){
        model.toast(context)
        view.updateCount(model.getCount().toString())
    }
    fun changeColor() : Boolean{
        model.changeColor()
        return model.boolean
    }

    fun attachView(view: MainActivity){
        this.view = view
    }
}