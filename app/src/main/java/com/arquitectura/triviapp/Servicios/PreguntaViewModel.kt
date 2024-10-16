package com.arquitectura.triviapp.Servicios

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arquitectura.TriviaQuestion
import com.arquitectura.triviapp.Entidades.PreguntaDatabase
import com.arquitectura.triviapp.Entidades.Pregunta
import com.arquitectura.triviapp.Repositorios.PreguntaRepository

class PreguntaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PreguntaRepository

    private val _preguntas = MutableLiveData<List<TriviaQuestion>>()
    val preguntas: LiveData<List<TriviaQuestion>> get() = _preguntas

    init {
        val dao = PreguntaDatabase.getDatabase(application).preguntaDao()
        repository = PreguntaRepository(dao)
    }

    fun insert(pregunta: Pregunta) {
        repository.insert(pregunta)
    }

    fun getTodasLasPreguntas(categoria: String): List<Pregunta> {
        return repository.getTodasLasPreguntas(categoria)
    }

    fun delete() {
        repository.delete()
    }

/*
    fun fetchMathQuestions() {
        RetrofitInstance.api.getMathQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

    fun fetchGeographyQuestions() {
        RetrofitInstance.api.getGeographyQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

    fun fetchLiteratureQuestions() {
        RetrofitInstance.api.getLiteratureQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

    fun fetchHistoryQuestions() {
        RetrofitInstance.api.getHistoryQuestions().enqueue(object : Callback<TriviaResponse> {
            override fun onResponse(call: Call<TriviaResponse>, response: Response<TriviaResponse>) {
                if (response.isSuccessful && response.body()?.response_code == 0) {
                    _questions.postValue(response.body()?.results)
                } else {
                    // Manejar error de API
                }
            }

            override fun onFailure(call: Call<TriviaResponse>, t: Throwable) {
                // Manejar fallo de red
            }
        })
    }

*/
}