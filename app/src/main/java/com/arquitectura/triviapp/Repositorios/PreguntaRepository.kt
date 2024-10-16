package com.arquitectura.triviapp.Repositorios

import com.arquitectura.triviapp.DAO.PreguntaDao
import com.arquitectura.triviapp.Entidades.Pregunta

    class PreguntaRepository(private val dao: PreguntaDao) {


        fun insert(pregunta: Pregunta) {
            dao.insert(pregunta)
        }

        fun getTodasLasPreguntas(categoria: String): List<Pregunta> {
            return dao.getTodasLasPreguntas(categoria)
        }

        fun delete(){
            dao.delete()
        }



    }