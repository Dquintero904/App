package com.arquitectura.triviapp.Servicios

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arquitectura.triviapp.Entidades.HistorialDatabase
import com.arquitectura.triviapp.Entidades.Historial
import com.arquitectura.triviapp.Repositorios.HistorialRepository

class HistorialViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HistorialRepository

    init {
        val dao = HistorialDatabase.getDatabase(application).historyDao()
        repository = HistorialRepository(dao)
    }


    fun insert(historial: Historial) {
        repository.insert(historial)
    }

    fun getDatosDelUsuario(user: String): LiveData<List<Historial>> {
        return repository.getDatosDelUsuario(user)
    }

    fun getTotalPuntosDelUsuario(user: String): Int {
        return repository.getTotalPuntosDelUsuario(user)
    }

}