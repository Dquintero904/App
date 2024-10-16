package com.arquitectura.triviapp.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arquitectura.triviapp.Entidades.Login

@Dao
interface LoginDao {


    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(login: Login)

    @Query("SELECT * FROM tabla_login WHERE username LIKE :username AND " + "password LIKE :password")
    fun verificarusuario(
        username: String,
        password: String
    ): LiveData<List<Login>>

    @Query("SELECT * FROM tabla_login WHERE username LIKE :username")
    fun verificarusuarioexistente(username: String): LiveData<List<Login>>


    @Query("UPDATE tabla_login SET password = :password WHERE username= :username")
    fun actualizar(password: String, username: String)

}