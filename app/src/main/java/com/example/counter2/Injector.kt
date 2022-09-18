package com.example.counter2

import com.example.counter2.presenter.Presenter

class Injector {
    companion object{
        fun getPresenter(): Presenter {
            return Presenter()
        }
        fun getModel(): CounterModel{
            return CounterModel()
        }
    }
}