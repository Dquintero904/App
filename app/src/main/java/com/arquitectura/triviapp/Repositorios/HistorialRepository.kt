package com.arquitectura.triviapp.Repositorios

import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.DAO.HistorialDao
import com.arquitectura.triviapp.Entidades.Historial

class HistorialRepository(private val dao: HistorialDao) {


    fun insert(historial: Historial) {
        dao.insert(historial)
    }

    fun getDatosDelUsuario(user: String): LiveData<List<Historial>> {
        return dao.getDatosDelUsuario(user)
    }

    fun getTotalPuntosDelUsuario(user: String): Int{
        return dao.getTotalPuntosDelUsuario(user)
    }

}