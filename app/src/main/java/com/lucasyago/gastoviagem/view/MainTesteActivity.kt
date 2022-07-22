package com.lucasyago.gastoviagem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lucasyago.gastoviagem.R
import com.lucasyago.gastoviagem.databinding.ActivityMainTesteBinding
import com.lucasyago.gastoviagem.util.toast
import com.lucasyago.gastoviagem.viewmodel.MainViewModel

class MainTesteActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_teste)
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