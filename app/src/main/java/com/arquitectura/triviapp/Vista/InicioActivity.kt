package com.arquitectura.triviapp.Vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.arquitectura.triviapp.Entidades.CatalogoPreguntas
import com.arquitectura.triviapp.Entidades.Pregunta
import com.arquitectura.triviapp.Servicios.PreguntaViewModel
import com.arquitectura.triviapp.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    private val viewModel: PreguntaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.delete()
        val list: List<Pregunta> = CatalogoPreguntas().insertAll()
        for (i in list.indices) {
            viewModel.insert(list[i])
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 200)

    }
}