package com.arquitectura.triviapp.Vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arquitectura.triviapp.databinding.ActivityCategoriaBinding

class CategoriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoriaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("username").toString()
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        binding.geografia.setOnClickListener {
            val intent = Intent(this, PreguntaActivity::class.java)
            intent.putExtra("categoria", "geografia")
            intent.putExtra("user", userName)
            startActivity(intent)
        }

        binding.matematicas.setOnClickListener {
            val intent = Intent(this, PreguntaActivity::class.java)
            intent.putExtra("categoria", "matematicas")
            intent.putExtra("user", userName)
            startActivity(intent)
        }

        binding.literatura.setOnClickListener {
            val intent = Intent(this, PreguntaActivity::class.java)
            intent.putExtra("categoria", "literatura")
            intent.putExtra("user", userName)
            startActivity(intent)
        }


    }

    override fun onRestart() {
        onBackPressed()
        super.onRestart()
    }

}