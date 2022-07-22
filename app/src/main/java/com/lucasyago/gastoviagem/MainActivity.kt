package com.lucasyago.gastoviagem

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lucasyago.gastoviagem.databinding.ActivityMainBinding
import com.lucasyago.gastoviagem.util.toast
import com.lucasyago.gastoviagem.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.btnButtonCalculate.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnButtonCalculate) {
            toast("Testando modal")
            viewModel.calculate()
        }
    }
}
