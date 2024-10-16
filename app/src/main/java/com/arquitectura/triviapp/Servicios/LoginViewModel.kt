package com.arquitectura.triviapp.Servicios

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.Entidades.Login
import com.arquitectura.triviapp.Entidades.LoginDatabase
import com.arquitectura.triviapp.Repositorios.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: LoginRepository

    init {
        val dao = LoginDatabase.getDatabase(application).loginDao()
        repository = LoginRepository(dao)
    }

    fun insert(login: Login) {
        repository.insert(login)
    }

    fun verificarusuario(
        username: String,
        password: String
    ): LiveData<List<Login>> {
        return repository.verificarusuario(username, password)
    }

    fun verificarusuarioexistente(username: String): LiveData<List<Login>> {
        return repository.verificarusuarioexistente(username)
    }

    fun actualizar(password: String, username: String) {
        repository.actualizar(password,username)
    }

}