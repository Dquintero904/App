package com.arquitectura.triviapp.Repositorios


import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.DAO.LoginDao
import com.arquitectura.triviapp.Entidades.Login

class LoginRepository(private val dao: LoginDao) {

    fun insert(login: Login) {
        dao.insert(login)
    }

    fun verificarusuario(
        username: String,
        password: String
    ): LiveData<List<Login>> {
        return dao.verificarusuario(username, password)
    }

    fun verificarusuarioexistente(username: String): LiveData<List<Login>> {
        return dao.verificarusuarioexistente(username)
    }

    fun actualizar(password: String, username:String) {
        dao.actualizar(password, username)
    }


}