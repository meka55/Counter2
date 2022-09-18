package com.example.counter2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            incrementBtn.setOnClickListener{
                presenter.increment()
                if (presenter.changeColor()){
                    binding.counterTv.setTextColor(Color.parseColor("green"))
                }
                presenter.toast(this@MainActivity)
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
                if (!presenter.changeColor()){
                    binding.counterTv.setTextColor(Color.parseColor("red"))

                }
            }
        }
    }

    override fun updateCount(count: String) {
        binding.counterTv.text = count
    }
}