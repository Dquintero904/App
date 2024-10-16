package com.arquitectura.triviapp.Vista

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.arquitectura.triviapp.Entidades.Historial
import com.arquitectura.triviapp.Servicios.HistorialViewModel
import com.arquitectura.triviapp.Entidades.Pregunta
import com.arquitectura.triviapp.R
import com.arquitectura.triviapp.Servicios.PreguntaViewModel
import com.arquitectura.triviapp.databinding.ActivityPreguntaBinding
import java.util.*

class PreguntaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreguntaBinding
    private lateinit var categoriaChosen: String
    private lateinit var userName: String

    private var i = 0
    private var correct = 0
    private var incorrect = 0
    private var points = 0
    private var totalPoints = 0

    private val viewModel1: HistorialViewModel by viewModels()
    private val viewModel: PreguntaViewModel by viewModels()

    private var selectedOption: CardView? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra("user").toString()
        categoriaChosen = intent.getStringExtra("categoria").toString()

        binding.categoria.text = getString(R.string.chosenCategoria, categoriaChosen)

        when (categoriaChosen) {
            "matematicas" -> getmatematicasQues()
            "geografia" -> getgeografiaQues()
            "literatura" -> getliteraturaQues()
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        setupOptionClickListeners()
    }

    // Configura los listeners de los CardView
    private fun setupOptionClickListeners() {
        binding.op1.setOnClickListener { selectOption(binding.op1) }
        binding.op2.setOnClickListener { selectOption(binding.op2) }
        binding.op3.setOnClickListener { selectOption(binding.op3) }
        binding.op4.setOnClickListener { selectOption(binding.op4) }
    }

    // Marca un CardView como seleccionado
    private fun selectOption(cardView: CardView) {
        // Restablecer el estilo de las opciones no seleccionadas
        resetOptionStyles()

        // Establecer el estilo seleccionado para la opción actual
        selectedOption = cardView
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }

    // Restablece el estilo de todas las opciones
    private fun resetOptionStyles() {
        binding.op1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
        binding.op2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
        binding.op3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
        binding.op4.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
    }

    // Renderiza la pregunta en la pantalla
    @SuppressLint("StringFormatMatches")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun renderQuesOnScreen(pregunta: List<Pregunta>, index: Int) {
        selectedOption = null // Resetea la selección al mostrar una nueva pregunta
        resetOptionStyles() // Restablece los estilos de las opciones

        if (i == 14) {
            binding.nextBtn.text = "FINISH"
        }

        if (i > 14) {
            // Aquí es donde se finaliza el cuestionario y se guarda el historial
            Toast.makeText(this, "correct = $correct, wrong $incorrect, points $points", Toast.LENGTH_SHORT).show()

            viewModel1.insert(
                Historial(
                    id = null,
                    username = userName,
                    categoria = categoriaChosen,
                    puntaje = points,
                    fecha = currentDate(),
                    tiempo = currentTime()
                )
            )

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("categoria", categoriaChosen)
            intent.putExtra("correct", correct)
            intent.putExtra("incorrect", incorrect)
            intent.putExtra("currentDate", currentDate())
            intent.putExtra("currentTime", currentTime())
            intent.putExtra("pointScoredCurrent", points)
            intent.putExtra("totalPointsTillDate", totalPoints)

            startActivity(intent)
        } else {
            val idx = (index + 1)
            binding.questionNumber.text = getString(R.string.questionNumber, idx)
            binding.questionText.text = pregunta[index].pregunta
            binding.op1Text.text = pregunta[index].op1
            binding.op2Text.text = pregunta[index].op2
            binding.op3Text.text = pregunta[index].op3
            binding.op4Text.text = pregunta[index].op4

            binding.nextBtn.setOnClickListener {
                if (selectedOption != null) {
                    checkRespuesta(pregunta[index].respuesta)

                    Handler(Looper.getMainLooper()).postDelayed({
                        i++
                        renderQuesOnScreen(pregunta, i)
                    }, 500) // Espera 1 segundo antes de cargar la siguiente pregunta
                } else {
                    Toast.makeText(this, "Selecciona una respuesta", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun showCorrectRespuesta(correctRespuesta: String) {

        when (correctRespuesta) {
            binding.op1Text.text.toString() -> binding.op1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            binding.op2Text.text.toString() -> binding.op2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            binding.op3Text.text.toString() -> binding.op3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            binding.op4Text.toString() -> binding.op4.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
        }

        // Si la opción seleccionada es incorrecta, la marca con rojo
        if (selectedOption != null) {
            selectedOption?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.incorrect_red))
        }
    }


    // Comprueba si la opción seleccionada es la correcta
    private fun checkRespuesta(correctRespuesta: String) {
        val selectedText = when (selectedOption) {
            binding.op1 -> binding.op1Text.text.toString()
            binding.op2 -> binding.op2Text.text.toString()
            binding.op3 -> binding.op3Text.text.toString()
            binding.op4 -> binding.op4Text.text.toString()
            else -> ""
        }


        if (selectedText == correctRespuesta) {
            correct()
        } else {
            incorrect()
            showCorrectRespuesta(correctRespuesta)
        }
    }

    private fun correct() {
        correct++
        points += 5
        selectedOption?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
    }

    private fun incorrect() {
        incorrect++
        points -= 2
        selectedOption?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.incorrect_red))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getmatematicasQues() {
        val l: List<Pregunta> = viewModel.getTodasLasPreguntas("matematicas")
        renderQuesOnScreen(l, 0)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getliteraturaQues() {
        val l: List<Pregunta> = viewModel.getTodasLasPreguntas("literatura")
        renderQuesOnScreen(l, 0)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getgeografiaQues() {
        val l: List<Pregunta> = viewModel.getTodasLasPreguntas("geografia")
        renderQuesOnScreen(l, 0)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun currentDate(): String {
        return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun currentTime(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    override fun onRestart() {
        onBackPressed()
        super.onRestart()
    }


}