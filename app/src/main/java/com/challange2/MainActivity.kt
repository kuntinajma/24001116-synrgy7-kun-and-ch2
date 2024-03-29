package com.challange2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.challange2.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.title = "Tip Time"
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        with(binding){
            btnCalculate.setOnClickListener{
                if(etCost.text?.isNotEmpty() == true){
                    val percentage = when {
                        rbAmazing.isChecked -> 0.20
                        rbGood.isChecked -> 0.18
                        rbOk.isChecked -> 0.15
                        else -> 0.0
                    }
                    val tip = etCost.text.toString().toDouble()*percentage
                    tvTip.text = if(swRound.isChecked){
                        tip.toInt().toString()
                    }else {
                        tip.toString()
                    }
                }
            }
        }
    }
}