package com.lucasyago.gastoviagem

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lucasyago.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnButtonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnButtonCalculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (
                binding.etDistance.text.toString() != ""
                && binding.etDistance.text.toString().toFloat() > 0f
                && binding.etPrice.text.toString() != ""
                && binding.etPrice.text.toString().toFloat() > 0f
                && binding.etAutonomy.text.toString() != ""
                && binding.etAutonomy.text.toString().toFloat() > 0f
        )

    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        if (isValid()) {

            val distance = binding.etDistance.text.toString().toFloat()
            val price = binding.etPrice.text.toString().toFloat()
            val autonomy = binding.etAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.tvTotalValue.text = "R$ %.2f".format(totalValue)
        } else {
            Toast.makeText(this, R.string.Validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }

    }

}
