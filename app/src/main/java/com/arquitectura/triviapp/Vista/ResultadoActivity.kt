package com.arquitectura.triviapp.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arquitectura.triviapp.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Categoria = intent.getStringExtra("categoria").toString()
        val correct = intent.getIntExtra("correct", 0)
        val incorrect = intent.getIntExtra("incorrect", 0)
        val currDate = intent.getStringExtra("currentDate").toString()
        val currTime = intent.getStringExtra("currentTime").toString()
        val points = intent.getIntExtra("pointScoredCurrent", 0)
        val total = intent.getIntExtra("totalPointsTillDate", 0)


        binding.categoria.text = Categoria
        binding.correct.text = correct.toString()
        binding.incorrect.text = incorrect.toString()
        binding.fecha.text = currDate
        binding.tiempo.text = currTime
        binding.puntaje.text = points.toString()

        binding.startAgainBtn.setOnClickListener {
            onBackPressed()
        }
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }


}