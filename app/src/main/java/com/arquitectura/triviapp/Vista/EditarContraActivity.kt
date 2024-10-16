package com.arquitectura.triviapp.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.arquitectura.triviapp.Servicios.LoginViewModel
import com.arquitectura.triviapp.databinding.ActivityEditarContraBinding

class EditarContraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContraBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarContraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("user").toString()
        //already present in database
        val password = intent.getStringExtra("password").toString()
        val id = intent.getStringExtra("id").toString().toInt()

        binding.changePasswordBtn.setOnClickListener {

            if (binding.newPassword.text.toString()
                    .isEmpty() || binding.oldPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "All fields must be non empty", Toast.LENGTH_SHORT).show()
            } else if (binding.oldPassword.text.toString().trim() != password) {
                Toast.makeText(this, "Old password is incorrect", Toast.LENGTH_SHORT).show()
            } else if (binding.newPassword.text.toString() == password) {
                Toast.makeText(this, "Old password is same as New password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Contraseña cambiada", Toast.LENGTH_SHORT)
                    .show()

                viewModel.actualizar(binding.newPassword.text.toString(), username)
            }
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}
