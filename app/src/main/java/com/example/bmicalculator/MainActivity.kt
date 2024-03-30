package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            val weight: Float = binding.editTextNumberDecimalWeight.text.toString().toFloat()
            val height: Float = binding.editTextNumberDecimalHeight.text.toString().toFloat()
            val bmi: Float = weight/(height * height)
            var type = ""

            if(weight > 0 && height > 0) {
                if(bmi < 18.5) {
                    type = getString(R.string.under)
                    binding.imageViewDefault.visibility = View.INVISIBLE
                    binding.imageViewUnder.visibility = View.VISIBLE
                    binding.imageViewNormal.visibility = View.INVISIBLE
                    binding.imageViewOver.visibility = View.INVISIBLE
                } else if(bmi in 18.5..24.9) {
                    type = getString(R.string.normal)
                    binding.imageViewDefault.visibility = View.INVISIBLE
                    binding.imageViewUnder.visibility = View.INVISIBLE
                    binding.imageViewNormal.visibility = View.VISIBLE
                    binding.imageViewOver.visibility = View.INVISIBLE
                } else if (bmi >= 25) {
                    type = getString(R.string.over)
                    binding.imageViewDefault.visibility = View.INVISIBLE
                    binding.imageViewUnder.visibility = View.INVISIBLE
                    binding.imageViewNormal.visibility = View.INVISIBLE
                    binding.imageViewOver.visibility = View.VISIBLE
                }
            }

            binding.textViewDisplayBMI.text = String.format("%f", bmi)
            binding.textViewDisplayType.text = String.format("%s", type)

        }

        binding.buttonReset.setOnClickListener {
            binding.editTextNumberDecimalWeight.text.clear()
            binding.editTextNumberDecimalHeight.text.clear()
            binding.textViewDisplayBMI.text = ""
            binding.textViewDisplayType.text = ""
            binding.imageViewDefault.visibility = View.VISIBLE
            binding.imageViewUnder.visibility = View.INVISIBLE
            binding.imageViewNormal.visibility = View.INVISIBLE
            binding.imageViewOver.visibility = View.INVISIBLE
        }
    }
}