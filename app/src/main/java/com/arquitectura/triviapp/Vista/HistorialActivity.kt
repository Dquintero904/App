package com.arquitectura.triviapp.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.arquitectura.triviapp.Adapter.HistorialAdapter

import com.arquitectura.triviapp.Servicios.HistorialViewModel
import com.arquitectura.triviapp.databinding.ActivityHistorialBinding


class HistorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistorialBinding
    private val viewModel: HistorialViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        //now show history
        binding.username.text = intent.getStringExtra("username").toString()
        binding.overallPoints.text =
            viewModel.getTotalPuntosDelUsuario(intent.getStringExtra("username").toString()).toString()

        viewModel.getDatosDelUsuario(binding.username.text.toString()).observe(this) {

//            TODO : bind data in recycler view
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = HistorialAdapter(this, it)

        }

    }
}