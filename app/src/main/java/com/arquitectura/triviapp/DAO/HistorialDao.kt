package com.arquitectura.triviapp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.arquitectura.triviapp.Entidades.Historial

@Dao
interface HistorialDao {

    @Insert(onConflict = REPLACE)
    fun insert(historial: Historial)

    @Query("SELECT * FROM TABLA_HISTORIAL WHERE username = :user ORDER BY tiempo desc")
    fun getDatosDelUsuario(user: String): LiveData<List<Historial>>

    @Query("select SUM(puntaje) from tabla_historial where username = :user")
    fun getTotalPuntosDelUsuario(user: String): Int

}