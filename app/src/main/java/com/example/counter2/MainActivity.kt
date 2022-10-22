package com.example.counter2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.counter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var viewModel : MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel ::class.java]

        setupObserves()
        setPlus()
        setMinus()
    }

    private fun setupObserves() {
        viewModel?.data?.observe(this){ count ->
            binding.counterTv.text = count.toString()
        }
    }

    private fun setPlus() {
        binding.plusBtn.setOnClickListener {
            viewModel?.plus()
            if (viewModel?.count == 10){
                binding.counterTv.setTextColor(Color.parseColor("green"))
            }
        }
    }

    private fun setMinus() {
        binding.minusBtn.setOnClickListener{
            viewModel?.minus()
            }
        }
    }

