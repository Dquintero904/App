package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.PreguntaDTO;
import co.vinni.soapproyectobase.entidades.Pregunta;
import co.vinni.soapproyectobase.repositorios.RepositorioPregunta;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ServicioPregunta implements Serializable {


    private ModelMapper modelMapper;


    @Autowired
    private RepositorioPregunta repositorioPregunta;


    @PostConstruct
    public void insertAllPreguntas() {
        List<PreguntaDTO> preguntaDTOs = crearPreguntas();


        for (PreguntaDTO dto : preguntaDTOs) {
            // Buscar si la pregunta ya existe en la base de datos
            List<Pregunta> existentes = repositorioPregunta.findByPregunta(dto.getPregunta());


            if (existentes.isEmpty()) {


                Pregunta nuevaPregunta = modelMapper.map(dto, Pregunta.class);
                repositorioPregunta.save(nuevaPregunta);
            } else {


                Pregunta preguntaExistente = existentes.get(0);


                preguntaExistente.setEstado(dto.isEstado());




                repositorioPregunta.save(preguntaExistente);
            }
        }
    }


    private List<PreguntaDTO> crearPreguntas() {
        return List.of(


                // Mate

                // Preguntas fáciles
                new PreguntaDTO(null, "¿Cuánto es 5 + 3?", "6", "7", "8", "9", "8", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el valor de π (Pi) aproximadamente?", "3", "2", "4", "1", "3", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 10 - 6?", "5", "6", "3", "4", "4", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 2 * 2?", "2", "4", "6", "8", "4", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 12 ÷ 4?", "1", "2", "3", "4", "3", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 6 + 5?", "10", "11", "12", "13", "11", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 9 - 4?", "4", "5", "6", "7", "5", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 3 * 3?", "6", "8", "9", "12", "9", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 15 ÷ 5?", "2", "3", "4", "5", "3", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 7 + 6?", "12", "13", "14", "15", "13", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el resultado de 4 * 5?", "15", "20", "25", "30", "20", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 18 ÷ 3?", "5", "6", "7", "8", "6", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 5 + 9?", "12", "13", "14", "15", "14", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 8 - 3?", "4", "5", "6", "7", "5", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 7 * 2?", "12", "13", "14", "15", "14", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 30 ÷ 6?", "5", "4", "3", "2", "5", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 10 + 5?", "12", "13", "14", "15", "15", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 6 * 3?", "17", "18", "19", "20", "18", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 16 ÷ 4?", "3", "4", "5", "6", "4", "matematicas", "facil",true),
                new PreguntaDTO(null, "¿Cuánto es 9 + 7?", "14", "15", "16", "17", "16", "matematicas", "facil",true),



                // Preguntas intermedias
                new PreguntaDTO(null, "¿Cuánto es 25 * 3?", "60", "70", "75", "80", "75", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Qué es el resultado de 100 ÷ 5?", "10", "15", "20", "25", "20", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 8^2 (8 al cuadrado)?", "64", "32", "16", "81", "64", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el valor de la raíz cuadrada de 144?", "10", "11", "12", "13", "12", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 12 * 12?", "120", "132", "144", "156", "144", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el valor absoluto de -15?", "15", "-15", "0", "1", "15", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 15 ÷ 0.5?", "30", "7.5", "15", "10", "30", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es el perímetro de un cuadrado con lados de 5 cm?", "10 cm", "15 cm", "20 cm", "25 cm", "20 cm", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es el área de un círculo con radio 7 (π=3.14)?", "154", "44", "66", "132", "154", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "Si un tren viaja a 80 km/h, ¿cuánto tiempo tardará en recorrer 240 km?", "1 hora", "2 horas", "3 horas", "4 horas", "3 horas", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 7^3 (7 al cubo)?", "147", "343", "512", "729", "343", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 36 ÷ 6?", "5", "6", "7", "8", "6", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "Si x = 3, ¿cuánto es 5x + 4?", "14", "15", "16", "17", "19", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el valor de 3 + 4 * 2?", "11", "14", "17", "18", "11", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 9 * (5 + 3)?", "72", "68", "64", "80", "72", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 2^5 (2 elevado a 5)?", "30", "32", "35", "40", "32", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el área de un triángulo con base 6 cm y altura 8 cm?", "24 cm²", "28 cm²", "32 cm²", "36 cm²", "24 cm²", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 250 ÷ 25?", "8", "9", "10", "12", "10", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuánto es 15 * (8 ÷ 2)?", "60", "75", "80", "90", "60", "matematicas", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el valor de 4x - 7 si x = 5?", "12", "13", "14", "15", "13", "matematicas", "intermedio",true),

                // Preguntas difíciles
                new PreguntaDTO(null, "¿Cuánto es 15 * 17?", "245", "255", "265", "275", "255", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es la raíz cúbica de 27?", "1", "2", "3", "4", "3", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Qué es el valor de 2^5 (2 elevado a la 5)?", "16", "32", "64", "128", "32", "matematicas", "dificil",true),
                new PreguntaDTO(null, "Si x = 3 y y = 4, ¿cuál es el valor de 2x + 3y?", "12", "15", "18", "21", "18", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es la derivada de 3x^2?", "6x", "3x", "9x", "2x", "6x", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el seno de 30 grados?", "0.5", "1", "0.707", "0", "0.5", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es 45 ÷ 1.5?", "20", "25", "30", "35", "30", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el logaritmo en base 10 de 1000?", "1", "2", "3", "4", "3", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es el valor de 7!", "5000", "5040", "4000", "4030", "5040", "matematicas", "dificil",true),
                new PreguntaDTO(null, "Si a + b = 10 y a - b = 4, ¿cuánto vale a?", "2", "4", "7", "8", "7", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es 5^4?", "500", "625", "720", "800", "625", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Qué es el valor de ln(e^2)?", "1", "2", "3", "e^2", "2", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es la integral de 5x^2?", "5x^3/3", "5x^3", "x^3", "5x^3/2", "5x^3/3", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es 2 + 3i * 4 - 5i?", "8 - 7i", "8 + 7i", "10 + 7i", "10 - 7i", "8 - 7i", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el valor de 3 + 2 * (5 - 3)?", "7", "8", "9", "10", "7", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es la derivada de sin(x)?", "cos(x)", "sin(x)", "-cos(x)", "-sin(x)", "cos(x)", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es la ecuación de la recta tangente a y = x^2 en x = 2?", "y = 2x - 4", "y = 2x + 4", "y = 4x - 4", "y = 4x + 4", "y = 4x - 4", "matematicas", "dificil",true),
                new PreguntaDTO(null, "Si a^2 + b^2 = 25, ¿cuál es el valor de a si b = 3?", "4", "5", "6", "7", "4", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es el límite de (x^2 - 4) / (x - 2) cuando x tiende a 2?", "2", "4", "1", "0", "4", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es 5 * (3 + 2)^2?", "75", "85", "100", "120", "75", "matematicas", "dificil",true),
                new PreguntaDTO(null, "¿Cuánto es 2 * pi * 3?", "18.84", "19.42", "20.56", "21.56", "18.84", "matematicas", "dificil",true),


                //geografia
                // Preguntas fáciles
                new PreguntaDTO(null, "¿Cuál es el continente más grande?", "África", "América", "Asia", "Europa", "Asia", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el océano más grande del mundo?", "Atlántico", "Índico", "Ártico", "Pacífico", "Pacífico", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra la Torre Eiffel?", "España", "Italia", "Francia", "Reino Unido", "Francia", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es la capital de España?", "Madrid", "Barcelona", "Sevilla", "Valencia", "Madrid", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el país más grande de América del Sur?", "Argentina", "Brasil", "Perú", "Chile", "Brasil", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el río más largo del mundo?", "Amazonas", "Nilo", "Misisipi", "Yangtsé", "Nilo", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra Egipto?", "Europa", "África", "Asia", "Oceanía", "África", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el país más poblado del mundo?", "Estados Unidos", "India", "Rusia", "China", "China", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el país más pequeño del mundo?", "Mónaco", "San Marino", "Liechtenstein", "Vaticano", "Vaticano", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra la Estatua de la Libertad?", "Inglaterra", "Francia", "Estados Unidos", "Canadá", "Estados Unidos", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el océano entre América y Europa?", "Atlántico", "Índico", "Pacífico", "Ártico", "Atlántico", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el Machu Picchu?", "México", "Perú", "Chile", "Colombia", "Perú", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es la capital de Francia?", "Roma", "Madrid", "París", "Londres", "París", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Qué océano baña las costas de Australia?", "Atlántico", "Índico", "Pacífico", "Ártico", "Pacífico", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el país más grande de África?", "Nigeria", "Sudáfrica", "Argelia", "Egipto", "Argelia", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra Japón?", "Asia", "Europa", "América", "Oceanía", "Asia", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra el Amazonas?", "Asia", "América", "Europa", "África", "América", "geografia", "facil",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra Australia?", "Asia", "Europa", "América", "Oceanía", "Oceanía", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el país más grande de Europa?", "Francia", "Alemania", "Rusia", "España", "Rusia", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Dónde se encuentra el Taj Mahal?", "Pakistán", "India", "Nepal", "Sri Lanka", "India", "geografia", "facil",true),
                new PreguntaDTO(null, "¿Cuál es la capital de Estados Unidos?", "Nueva York", "Los Ángeles", "Washington D.C.", "Chicago", "Washington D.C.", "geografia", "facil",true),

                // Preguntas intermedias
                new PreguntaDTO(null, "¿Cuál es la montaña más alta del mundo?", "Monte Everest", "K2", "Makalu", "Kangchenjunga", "Monte Everest", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el desierto del Sahara?", "Arabia Saudita", "Sudán", "Egipto", "Marruecos", "Egipto", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es la capital de Australia?", "Sídney", "Melbourne", "Canberra", "Perth", "Canberra", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra el Monte Kilimanjaro?", "Asia", "Europa", "África", "América del Sur", "África", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el país más grande del mundo?", "Canadá", "China", "Estados Unidos", "Rusia", "Rusia", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es la capital de Canadá?", "Toronto", "Vancouver", "Montreal", "Ottawa", "Ottawa", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el río más largo de América del Sur?", "Paraná", "Amazonas", "Orinoco", "Río de la Plata", "Amazonas", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el famoso volcán Monte Fuji?", "China", "Corea del Sur", "Japón", "Filipinas", "Japón", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es la capital de México?", "Guadalajara", "Monterrey", "Ciudad de México", "Tijuana", "Ciudad de México", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué país se encuentra la Gran Muralla China?", "Japón", "Corea del Norte", "China", "Mongolia", "China", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra el río Nilo?", "Asia", "África", "Europa", "Oceanía", "África", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el Lago Titicaca?", "Bolivia", "Perú", "Chile", "Argentina", "Bolivia", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Qué continente tiene la mayor cantidad de países?", "Asia", "África", "Europa", "América", "África", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el océano entre África y Australia?", "Atlántico", "Índico", "Pacífico", "Ártico", "Índico", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Qué país tiene la mayor cantidad de habitantes en Europa?", "Francia", "Rusia", "Alemania", "España", "Rusia", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué país se encuentra la ciudad de Petra?", "Egipto", "Jordania", "Israel", "Siria", "Jordania", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el río más largo de África?", "Amazonas", "Nilo", "Yangtsé", "Misisipi", "Nilo", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿En qué continente se encuentra la isla de Madagascar?", "Asia", "África", "América", "Oceanía", "África", "geografia", "intermedio",true),
                new PreguntaDTO(null, "¿Qué mar conecta el océano Atlántico con el mar Mediterráneo?", "Mar Negro", "Mar Rojo", "Mar Caribe", "Mar de Gibraltar", "Mar de Gibraltar", "geografia", "intermedio",true),

                // Preguntas difíciles
                new PreguntaDTO(null, "¿Cuál es el país más grande de África?", "Argelia", "Sudáfrica", "Nigeria", "Egipto", "Argelia", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es la capital de Nueva Zelanda?", "Sídney", "Auckland", "Wellington", "Canberra", "Wellington", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Qué país tiene más islas en el mundo?", "Filipinas", "Suecia", "Noruega", "Indonesia", "Suecia", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el lago más profundo del mundo?", "Lago Baikal", "Lago Superior", "Lago Tanganica", "Lago Victoria", "Lago Baikal", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el Monte Aconcagua?", "Chile", "Perú", "Argentina", "Bolivia", "Argentina", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el país más pequeño de América del Sur?", "Uruguay", "Surinam", "Guyana", "Paraguay", "Surinam", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Qué cordillera separa a Europa de Asia?", "Alpes", "Cáucaso", "Urales", "Himalayas", "Urales", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el desierto más grande de Asia?", "Desierto de Gobi", "Desierto de Thar", "Desierto del Karakum", "Desierto Arábigo", "Desierto de Gobi", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es la capital de Mongolia?", "Ulán Bator", "Astana", "Taskent", "Biskek", "Ulán Bator", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el país más poblado de África?", "Egipto", "Sudáfrica", "Nigeria", "Etiopía", "Nigeria", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Dónde se encuentra la ciudad de Dubrovnik?", "Italia", "Croacia", "Serbia", "Bulgaria", "Croacia", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra la ciudad de Marrakech?", "Marruecos", "Egipto", "Sudán", "Túnez", "Marruecos", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el continente con la mayor cantidad de países?", "Asia", "Europa", "África", "América", "África", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el río más largo de América del Norte?", "Río Colorado", "Río Mississippi", "Río Misisipi", "Río Bravo", "Río Misisipi", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el volcán Eyjafjallajökull?", "Islandia", "Noruega", "Suecia", "Finlandia", "Islandia", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Qué isla es conocida como la isla de los pingüinos?", "Antártida", "Galápagos", "Tierra del Fuego", "Falkland", "Tierra del Fuego", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el punto más bajo de la Tierra?", "Mar Muerto", "Valle de la Muerte", "Gran Cañón", "Abyssal Plain", "Mar Muerto", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra la ciudad de Petra?", "Israel", "Palestina", "Jordania", "Siria", "Jordania", "geografia", "dificil",true),
                new PreguntaDTO(null, "¿En qué país se encuentra el monte Kilimanjaro?", "Kenia", "Tanzania", "Uganda", "Zambia", "Tanzania", "geografia", "dificil",true),

                // Literatura
                // Preguntas fáciles
                new PreguntaDTO(null, "¿Quién escribió 'Don Quijote de la Mancha'?", "Gabriel García Márquez", "Miguel de Cervantes", "Federico García Lorca", "Lope de Vega", "Miguel de Cervantes", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién es el autor de 'Cien años de soledad'?", "Jorge Luis Borges", "Mario Vargas Llosa", "Gabriel García Márquez", "Pablo Neruda", "Gabriel García Márquez", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del detective creado por Arthur Conan Doyle?", "Hercule Poirot", "Sherlock Holmes", "Philip Marlowe", "Sam Spade", "Sherlock Holmes", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Romeo y Julieta'?", "William Shakespeare", "Christopher Marlowe", "Charles Dickens", "Jane Austen", "William Shakespeare", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Matar a un ruiseñor'?", "George Orwell", "Harper Lee", "Ernest Hemingway", "F. Scott Fitzgerald", "Harper Lee", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del personaje principal de 'Moby Dick'?", "Capitán Ahab", "Ishmael", "Queequeg", "Starbuck", "Capitán Ahab", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'La Odisea'?", "Sófocles", "Homero", "Virgilio", "Eurípides", "Homero", "literatura", "facil",true),
                new PreguntaDTO(null, "¿En qué país nació el poeta Pablo Neruda?", "México", "Colombia", "Chile", "Argentina", "Chile", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Orgullo y prejuicio'?", "Jane Austen", "Emily Brontë", "Mary Shelley", "Virginia Woolf", "Jane Austen", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién es el autor de 'La metamorfosis'?", "Franz Kafka", "Friedrich Nietzsche", "Thomas Mann", "Jean-Paul Sartre", "Franz Kafka", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Qué escritor creó el personaje de 'Drácula'?", "Bram Stoker", "Mary Shelley", "Edgar Allan Poe", "H.G. Wells", "Bram Stoker", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Las aventuras de Tom Sawyer'?", "Mark Twain", "Charles Dickens", "Nathaniel Hawthorne", "Herman Melville", "Mark Twain", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el título original de 'Don Quijote de la Mancha'?", "El ingenioso hidalgo Don Quijote de la Mancha", "Don Quijote de la Mancha", "El caballero de la triste figura", "El hombre de la lanza rota", "El ingenioso hidalgo Don Quijote de la Mancha", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'El retrato de Dorian Gray'?", "Oscar Wilde", "George Bernard Shaw", "James Joyce", "Samuel Beckett", "Oscar Wilde", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'La guerra de los mundos'?", "H.G. Wells", "Jules Verne", "Isaac Asimov", "Arthur C. Clarke", "H.G. Wells", "literatura", "facil",true),
                new PreguntaDTO(null, "¿En qué país nació el escritor Gabriel García Márquez?", "México", "Colombia", "Argentina", "Chile", "Colombia", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Las flores del mal'?", "Paul Verlaine", "Arthur Rimbaud", "Charles Baudelaire", "Gérard de Nerval", "Charles Baudelaire", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'El gran Gatsby'?", "F. Scott Fitzgerald", "Ernest Hemingway", "John Steinbeck", "William Faulkner", "F. Scott Fitzgerald", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Quién escribió 'La divina comedia'?", "Dante Alighieri", "Virgilio", "Homero", "Petrarca", "Dante Alighieri", "literatura", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del protagonista de 'Cien años de soledad'?", "José Arcadio Buendía", "Aureliano Buendía", "Melquíades", "Macondo", "José Arcadio Buendía", "literatura", "facil",true),
                new PreguntaDTO(null, "¿En qué año se publicó '1984' de George Orwell?", "1935", "1945", "1955", "1965", "1945", "literatura", "facil",true),

                // Preguntas intermedias
                new PreguntaDTO(null, "¿Quién es el autor de 'El gran Gatsby'?", "John Steinbeck", "F. Scott Fitzgerald", "Ernest Hemingway", "William Faulkner", "F. Scott Fitzgerald", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'Crimen y castigo'?", "Lev Tolstói", "Antón Chéjov", "Fiódor Dostoyevski", "Iván Turguénev", "Fiódor Dostoyevski", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'El retrato de Dorian Gray'?", "Oscar Wilde", "George Bernard Shaw", "James Joyce", "Samuel Beckett", "Oscar Wilde", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién es el autor de la trilogía 'El Señor de los Anillos'?", "J.R.R. Tolkien", "C.S. Lewis", "George R.R. Martin", "Philip Pullman", "J.R.R. Tolkien", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Qué obra literaria narra la historia de Jean Valjean?", "Los Miserables", "El Conde de Montecristo", "La guerra y la paz", "Madame Bovary", "Los Miserables", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién es el autor de '1984'?", "Aldous Huxley", "Ray Bradbury", "George Orwell", "H.G. Wells", "George Orwell", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'El amor en los tiempos del cólera'?", "Isabel Allende", "Gabriel García Márquez", "Mario Vargas Llosa", "Julio Cortázar", "Gabriel García Márquez", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'Cumbres Borrascosas'?", "Emily Brontë", "Charlotte Brontë", "Jane Austen", "Louisa May Alcott", "Emily Brontë", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el título original de 'Orgullo y prejuicio'?", "Pride and Honor", "Pride and Prejudice", "Prejudiced Pride", "Sense and Prejudice", "Pride and Prejudice", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿En qué libro aparece el personaje 'Gregorio Samsa'?", "El proceso", "El castillo", "La metamorfosis", "América", "La metamorfosis", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'La cabaña del tío Tom'?", "Harriet Beecher Stowe", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald", "Harriet Beecher Stowe", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿En qué novela aparece el personaje 'Hannibal Lecter'?", "El silencio de los corderos", "Psicosis", "El resplandor", "Drácula", "El silencio de los corderos", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Qué autor de 'Los hermanos Karamazov'?", "Lev Tolstói", "Fiódor Dostoyevski", "Antón Chéjov", "Iván Turguénev", "Fiódor Dostoyevski", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el nombre de la autora de 'Cumbres Borrascosas'?", "Charlotte Brontë", "Emily Brontë", "Mary Shelley", "Louisa May Alcott", "Emily Brontë", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿En qué obra aparece el personaje de 'Raskólnikov'?", "Crimen y castigo", "El maestro y Margarita", "La guerra y la paz", "Anna Karenina", "Crimen y castigo", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'La peste'?", "Albert Camus", "Jean-Paul Sartre", "Simone de Beauvoir", "Friedrich Nietzsche", "Albert Camus", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Qué escritor creó a 'Sherlock Holmes'?", "Agatha Christie", "Arthur Conan Doyle", "Edgar Allan Poe", "J.K. Rowling", "Arthur Conan Doyle", "literatura", "intermedio",true),
                new PreguntaDTO(null, "¿Quién escribió 'El hombre invisible'?", "H.G. Wells", "Jules Verne", "Isaac Asimov", "Arthur C. Clarke", "H.G. Wells", "literatura", "intermedio",true),

                // Preguntas difíciles
                new PreguntaDTO(null, "¿Quién escribió 'Ulises'?", "James Joyce", "Samuel Beckett", "Virginia Woolf", "T.S. Eliot", "James Joyce", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el verdadero nombre de Mark Twain?", "Samuel Langhorne Clemens", "Edgar Allan Poe", "William Faulkner", "Henry James", "Samuel Langhorne Clemens", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió 'La montaña mágica'?", "Franz Kafka", "Thomas Mann", "Hermann Hesse", "Stefan Zweig", "Thomas Mann", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Qué poeta escribió 'Canto a mí mismo'?", "Walt Whitman", "Emily Dickinson", "Robert Frost", "Ezra Pound", "Walt Whitman", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Qué novela de Marcel Proust forma parte de 'En busca del tiempo perdido'?", "El tiempo recobrado", "A la sombra de las muchachas en flor", "Por el camino de Swann", "La prisionera", "Por el camino de Swann", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Las uvas de la ira'?", "Ernest Hemingway", "John Steinbeck", "William Faulkner", "F. Scott Fitzgerald", "John Steinbeck", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el título de la famosa obra de teatro escrita por Tennessee Williams?", "Un tranvía llamado deseo", "Muerte de un viajante", "El zoo de cristal", "La gata sobre el tejado de zinc", "Un tranvía llamado deseo", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Qué obra escribió Friedrich Nietzsche?", "Así habló Zaratustra", "El extranjero", "El ser y la nada", "Crimen y castigo", "Así habló Zaratustra", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió 'Madame Bovary'?", "Émile Zola", "Honoré de Balzac", "Gustave Flaubert", "Guy de Maupassant", "Gustave Flaubert", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió 'El ruido y la furia'?", "Ernest Hemingway", "William Faulkner", "John Dos Passos", "F. Scott Fitzgerald", "William Faulkner", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Qué escritor publicó 'El retrato de Dorian Gray'?", "Oscar Wilde", "George Bernard Shaw", "J.R.R. Tolkien", "William Faulkner", "Oscar Wilde", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿En qué libro aparece el personaje de 'Oskar Schindler'?", "La lista de Schindler", "El niño con el pijama de rayas", "Los hombres que no amaban a las mujeres", "El diario de Ana Frank", "La lista de Schindler", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió 'El dolor de los demás'?", "Marguerite Duras", "Simone de Beauvoir", "Georges Simenon", "Albert Camus", "Marguerite Duras", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el tema principal de 'La campana de cristal'?", "La guerra", "La depresión", "La rebelión", "La nostalgia", "La depresión", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Qué autor escribió 'Fahrenheit 451'?", "Aldous Huxley", "Ray Bradbury", "George Orwell", "Isaac Asimov", "Ray Bradbury", "literatura", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió 'El maestro y Margarita'?", "Fiódor Dostoyevski", "Mijaíl Bulgákov", "Vladimir Nabokov", "Antón Chéjov", "Mijaíl Bulgákov", "literatura", "dificil",true),


                // Entretenamiento
                // Preguntas fáciles
                new PreguntaDTO(null, "¿Quién es el protagonista de la serie 'Breaking Bad'?", "Jesse Pinkman", "Saul Goodman", "Hank Schrader", "Walter White", "Walter White", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Cuál es la famosa saga de películas donde aparece 'Darth Vader'?", "Harry Potter", "El Señor de los Anillos", "Star Wars", "Matrix", "Star Wars", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Cómo se llama el personaje principal de 'Toy Story'?", "Buzz Lightyear", "Woody", "Rex", "Slinky", "Woody", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Quién es el creador del personaje 'Sherlock Holmes'?", "Agatha Christie", "Arthur Conan Doyle", "Edgar Allan Poe", "Raymond Chandler", "Arthur Conan Doyle", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿En qué película animada aparece el personaje de Simba?", "Shrek", "El Rey León", "Madagascar", "Buscando a Nemo", "El Rey León", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del actor que interpreta a 'Jack Sparrow' en 'Piratas del Caribe'?", "Orlando Bloom", "Johnny Depp", "Brad Pitt", "Tom Cruise", "Johnny Depp", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Quién es el villano principal de 'Los Vengadores: Infinity War'?", "Loki", "Thanos", "Ultrón", "Hela", "Thanos", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Qué banda interpretó la canción 'Bohemian Rhapsody'?", "The Beatles", "Led Zeppelin", "Queen", "Pink Floyd", "Queen", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Qué película ganó el Óscar a la mejor película en 2020?", "1917", "Joker", "Parasite", "Once Upon a Time in Hollywood", "Parasite", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el verdadero nombre de 'Iron Man'?", "Steve Rogers", "Tony Stark", "Bruce Wayne", "Peter Parker", "Tony Stark", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Quién cantó la canción 'Thriller'?", "Prince", "Elvis Presley", "Michael Jackson", "Madonna", "Michael Jackson", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Qué actor interpretó a 'Hannibal Lecter' en 'El silencio de los corderos'?", "Johnny Depp", "Anthony Hopkins", "Brad Pitt", "Morgan Freeman", "Anthony Hopkins", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿En qué película aparece el personaje de 'Elsa'?", "Frozen", "La Bella y la Bestia", "Moana", "Cenicienta", "Frozen", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Cuál es la famosa frase de la película 'El regreso del Jedi'?", "May the Force be with you", "Hasta la vista, baby", "I am your father", "Do or do not, there is no try", "May the Force be with you", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Qué famosa película está basada en un libro de J.R.R. Tolkien?", "Harry Potter", "El Señor de los Anillos", "Las Crónicas de Narnia", "Percy Jackson", "El Señor de los Anillos", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿En qué película animada aparece el personaje de 'Ratatouille'?", "Finding Nemo", "Ratatouille", "Toy Story", "Monsters Inc.", "Ratatouille", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Qué cantante se hizo famoso con la canción 'Shape of You'?", "Ed Sheeran", "Adele", "Justin Bieber", "Shawn Mendes", "Ed Sheeran", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Quién cantó la canción 'Like a Virgin'?", "Madonna", "Celine Dion", "Britney Spears", "Ariana Grande", "Madonna", "entretenimiento", "facil",true),
                new PreguntaDTO(null, "¿Quién es el creador de la saga 'Harry Potter'?", "J.R.R. Tolkien", "George R.R. Martin", "J.K. Rowling", "Suzanne Collins", "J.K. Rowling", "entretenimiento", "facil",true),

                // Preguntas intermedias
                new PreguntaDTO(null, "¿Quién dirigió la película 'Inception'?", "Martin Scorsese", "Steven Spielberg", "Christopher Nolan", "Quentin Tarantino", "Christopher Nolan", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿En qué año se estrenó la película 'Titanic'?", "1997", "1999", "2001", "1995", "1997", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué actor interpretó al Joker en 'El caballero de la noche'?", "Jack Nicholson", "Joaquin Phoenix", "Heath Ledger", "Jared Leto", "Heath Ledger", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el nombre real de la cantante conocida como 'Lady Gaga'?", "Stefani Joanne Angelina Germanotta", "Robyn Fenty", "Alecia Beth Moore", "Katheryn Hudson", "Stefani Joanne Angelina Germanotta", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Quién es el creador de la serie animada 'Los Simpson'?", "Matt Groening", "Seth MacFarlane", "Trey Parker", "Mike Judge", "Matt Groening", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del actor que interpretó a 'Forrest Gump'?", "Tom Hanks", "Brad Pitt", "Leonardo DiCaprio", "George Clooney", "Tom Hanks", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿En qué película de Pixar aparece el personaje de 'Wall-E'?", "Ratatouille", "Up", "Wall-E", "Monsters, Inc.", "Wall-E", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué famoso director de cine es conocido por películas como 'Pulp Fiction' y 'Kill Bill'?", "Christopher Nolan", "Quentin Tarantino", "Steven Spielberg", "James Cameron", "Quentin Tarantino", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Quién ganó el Grammy al mejor álbum del año en 2021?", "Taylor Swift", "Beyoncé", "Billie Eilish", "Dua Lipa", "Taylor Swift", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Cuál es el nombre de la ciudad ficticia donde vive Batman?", "Metropolis", "Gotham", "Star City", "Central City", "Gotham", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué película ganó el Óscar a la mejor película en 2017?", "La La Land", "Moonlight", "Spotlight", "Birdman", "Moonlight", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué cantante tiene el apodo de 'The Weeknd'?", "Drake", "The Weeknd", "Post Malone", "Kanye West", "The Weeknd", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué película de terror se basa en la historia de un payaso llamado Pennywise?", "La casa del terror", "Eso", "El conjuro", "El aro", "Eso", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué actor protagoniza la película 'Indiana Jones'?", "Harrison Ford", "Tom Hanks", "Bruce Willis", "Matt Damon", "Harrison Ford", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué serie de televisión se desarrolla en un hospital psiquiátrico llamado 'Asylum'?", "American Horror Story: Asylum", "Stranger Things", "The Haunting of Hill House", "Bates Motel", "American Horror Story: Asylum", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué cantante lanzó el álbum 'Lover'?", "Ariana Grande", "Ed Sheeran", "Taylor Swift", "Billie Eilish", "Taylor Swift", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué personaje de Disney tiene la famosa frase 'Hakuna Matata'?", "Simba", "Pumba", "Timon", "Mufasa", "Pumba", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿En qué película aparece el personaje de 'Shrek'?", "Toy Story", "Shrek", "Monsters, Inc.", "Kung Fu Panda", "Shrek", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Quién cantó la canción 'I Will Always Love You'?", "Celine Dion", "Whitney Houston", "Mariah Carey", "Adele", "Whitney Houston", "entretenimiento", "intermedio",true),
                new PreguntaDTO(null, "¿Qué famosa serie de Netflix tiene como protagonista a un joven llamado 'Joe Goldberg'?", "The Crown", "Stranger Things", "You", "13 Reasons Why", "You", "entretenimiento", "intermedio",true),

                // Preguntas intermedias
                new PreguntaDTO(null, "¿Qué banda sonora compuso Ennio Morricone para la película 'El bueno, el feo y el malo'?", "La misión", "Cinema Paradiso", "El bueno, el feo y el malo", "Por un puñado de dólares", "El bueno, el feo y el malo", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es la primera película de la saga de James Bond?", "Goldfinger", "Dr. No", "Thunderball", "Desde Rusia con amor", "Dr. No", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del personaje interpretado por Clint Eastwood en 'El bueno, el feo y el malo'?", "El hombre sin nombre", "William Munny", "Harry Callahan", "Joe Kidd", "El hombre sin nombre", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Qué película de Akira Kurosawa inspiró el western 'Los siete magníficos'?", "Trono de sangre", "Yojimbo", "Ran", "Los siete samuráis", "Los siete samuráis", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Quién escribió el guion de la película 'Taxi Driver'?", "Quentin Tarantino", "Paul Schrader", "Francis Ford Coppola", "Stanley Kubrick", "Paul Schrader", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Quién es el autor de la novela 'El padrino', que inspiró la famosa película?", "Truman Capote", "Ernest Hemingway", "Mario Puzo", "John Steinbeck", "Mario Puzo", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Quién ganó el primer premio Óscar como mejor actriz en 1929?", "Greta Garbo", "Claudette Colbert", "Mary Pickford", "Janet Gaynor", "Janet Gaynor", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el verdadero nombre de Freddie Mercury, el vocalista de Queen?", "Farrokh Bulsara", "Zoroaster Mercury", "Fred Balsar", "Farid Mercuria", "Farrokh Bulsara", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre de la película ganadora del Óscar a mejor película en 2015?", "Birdman", "Spotlight", "La La Land", "Mad Max: Fury Road", "Birdman", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Cuál fue la primera película animada en ganar un Óscar?", "Blanca Nieves y los siete enanitos", "Pinocho", "Fantasía", "Bambi", "Blanca Nieves y los siete enanitos", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Qué actor interpretó al personaje de 'Daniel Day-Lewis' en 'Mi pie izquierdo'?", "Daniel Day-Lewis", "Leonardo DiCaprio", "Tom Hanks", "Johnny Depp", "Daniel Day-Lewis", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el nombre del personaje interpretado por Jack Nicholson en 'El resplandor'?", "Jack Torrance", "Dr. Jekyll", "Anton Chigurh", "Hannibal Lecter", "Jack Torrance", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿En qué año se estrenó la película '2001: Odisea del espacio'?", "1965", "1970", "1968", "1962", "1968", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿En qué película aparece el personaje de 'Boba Fett'?", "Star Wars: El imperio contraataca", "Star Wars: Una nueva esperanza", "Star Wars: El retorno del Jedi", "Star Wars: Los últimos Jedi", "Star Wars: El imperio contraataca", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Quién dirigió la película 'El padrino'?", "Stanley Kubrick", "Martin Scorsese", "Francis Ford Coppola", "John Ford", "Francis Ford Coppola", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Qué cantante escribió la famosa canción 'Like a Rolling Stone'?", "Bob Dylan", "Neil Young", "Paul Simon", "Bruce Springsteen", "Bob Dylan", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Quién fue el creador del personaje de 'Hannibal Lecter'?", "John Grisham", "Stephen King", "Thomas Harris", "Clive Barker", "Thomas Harris", "entretenimiento", "dificil",true),
                new PreguntaDTO(null, "¿Qué famoso actor fue conocido como el 'Rey del Rock'?", "Elvis Presley", "James Dean", "Marlon Brando", "Paul Newman", "Elvis Presley", "entretenimiento", "dificil",true),

                // Deportes
                // Preguntas fáciles
                new PreguntaDTO(null, "¿Cuántos jugadores tiene un equipo de fútbol en el campo?", "9", "10", "11", "12", "11", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué país se celebraron los Juegos Olímpicos de 2016?", "Brasil", "China", "Grecia", "Japón", "Brasil", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué deporte practica Roger Federer?", "Tenis", "Fútbol", "Baloncesto", "Ciclismo", "Tenis", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cómo se llama la liga profesional de baloncesto en Estados Unidos?", "NFL", "MLB", "NBA", "NHL", "NBA", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué país ha ganado más Copas del Mundo de fútbol?", "Italia", "Argentina", "Brasil", "Alemania", "Brasil", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cuántos puntos vale un gol en el fútbol?", "1", "2", "3", "4", "1", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué selección ganó la Copa del Mundo en 2018?", "Brasil", "Francia", "Argentina", "Alemania", "Francia", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Quién es conocido como 'El Rey del Fútbol'?", "Lionel Messi", "Diego Maradona", "Pelé", "Cristiano Ronaldo", "Pelé", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué deporte se utiliza una raqueta y una pelota pequeña?", "Tenis de mesa", "Bádminton", "Tenis", "Squash", "Tenis", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué jugador es apodado 'La Pulga'?", "Cristiano Ronaldo", "Lionel Messi", "Neymar", "Zinedine Zidane", "Lionel Messi", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué país se celebraron los Juegos Olímpicos de 2008?", "China", "Brasil", "Grecia", "Japón", "China", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué deportista es conocido como 'El Mejor Futbolista del Mundo'?", "Lionel Messi", "Cristiano Ronaldo", "Pelé", "Maradona", "Lionel Messi", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cuántos puntos vale un tiro libre en baloncesto?", "1", "2", "3", "4", "1", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el deporte nacional de Japón?", "Fútbol", "Béisbol", "Sumo", "Ciclismo", "Sumo", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué país nació el fútbol?", "España", "Inglaterra", "Argentina", "Francia", "Inglaterra", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué equipo de fútbol tiene como estadio el Camp Nou?", "Real Madrid", "Manchester United", "Barcelona", "Boca Juniors", "Barcelona", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué país ganó el mundial de fútbol en 2014?", "España", "Brasil", "Francia", "Alemania", "Alemania", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué deporte practicaba Michael Jordan?", "Béisbol", "Baloncesto", "Fútbol", "Golf", "Baloncesto", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Quién ganó la medalla de oro en baloncesto en los Juegos Olímpicos de 2020?", "Estados Unidos", "España", "Francia", "Australia", "Estados Unidos", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué equipo de baloncesto tiene como logo un alce?", "Los Angeles Lakers", "Boston Celtics", "Milwaukee Bucks", "Miami Heat", "Milwaukee Bucks", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué deporte se usan pelotas de diferentes tamaños y colores?", "Tenis", "Fútbol", "Bádminton", "Béisbol", "Tenis", "deportes", "facil",true),

                // Preguntas intermedias
                new PreguntaDTO(null, "¿Cuántos jugadores tiene un equipo de fútbol en el campo?", "9", "10", "11", "12", "11", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué país se celebraron los Juegos Olímpicos de 2016?", "Brasil", "China", "Grecia", "Japón", "Brasil", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué deporte practica Roger Federer?", "Tenis", "Fútbol", "Baloncesto", "Ciclismo", "Tenis", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cómo se llama la liga profesional de baloncesto en Estados Unidos?", "NFL", "MLB", "NBA", "NHL", "NBA", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué país ha ganado más Copas del Mundo de fútbol?", "Italia", "Argentina", "Brasil", "Alemania", "Brasil", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cuántos puntos vale un gol en el fútbol?", "1", "2", "3", "4", "1", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué selección ganó la Copa del Mundo en 2018?", "Brasil", "Francia", "Argentina", "Alemania", "Francia", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Quién es conocido como 'El Rey del Fútbol'?", "Lionel Messi", "Diego Maradona", "Pelé", "Cristiano Ronaldo", "Pelé", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué deporte se utiliza una raqueta y una pelota pequeña?", "Tenis de mesa", "Bádminton", "Tenis", "Squash", "Tenis", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué jugador es apodado 'La Pulga'?", "Cristiano Ronaldo", "Lionel Messi", "Neymar", "Zinedine Zidane", "Lionel Messi", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué país se celebraron los Juegos Olímpicos de 2008?", "China", "Brasil", "Grecia", "Japón", "China", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué deportista es conocido como 'El Mejor Futbolista del Mundo'?", "Lionel Messi", "Cristiano Ronaldo", "Pelé", "Maradona", "Lionel Messi", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cuántos puntos vale un tiro libre en baloncesto?", "1", "2", "3", "4", "1", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Cuál es el deporte nacional de Japón?", "Fútbol", "Béisbol", "Sumo", "Ciclismo", "Sumo", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué país nació el fútbol?", "España", "Inglaterra", "Argentina", "Francia", "Inglaterra", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué equipo de fútbol tiene como estadio el Camp Nou?", "Real Madrid", "Manchester United", "Barcelona", "Boca Juniors", "Barcelona", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué país ganó el mundial de fútbol en 2014?", "España", "Brasil", "Francia", "Alemania", "Alemania", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué deporte practicaba Michael Jordan?", "Béisbol", "Baloncesto", "Fútbol", "Golf", "Baloncesto", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Quién ganó la medalla de oro en baloncesto en los Juegos Olímpicos de 2020?", "Estados Unidos", "España", "Francia", "Australia", "Estados Unidos", "deportes", "facil",true),
                new PreguntaDTO(null, "¿Qué equipo de baloncesto tiene como logo un alce?", "Los Angeles Lakers", "Boston Celtics", "Milwaukee Bucks", "Miami Heat", "Milwaukee Bucks", "deportes", "facil",true),
                new PreguntaDTO(null, "¿En qué deporte se usan pelotas de diferentes tamaños y colores?", "Tenis", "Fútbol", "Bádminton", "Béisbol", "Tenis", "deportes", "facil",true),

                // Preguntas difíciles
                new PreguntaDTO(null, "¿Quién es el único jugador en la historia en ganar tres Copas del Mundo de fútbol?", "Maradona", "Pelé", "Zidane", "Beckenbauer", "Pelé", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Cuál es el récord de medallas olímpicas de Michael Phelps?", "23", "25", "28", "30", "28", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué club ha ganado más títulos de la UEFA Champions League?", "Barcelona", "Real Madrid", "Manchester United", "AC Milan", "Real Madrid", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿En qué año ganó Roger Federer su primer título de Grand Slam?", "2002", "2003", "2004", "2005", "2003", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién fue el primer campeón mundial de Fórmula 1?", "Niki Lauda", "Juan Manuel Fangio", "Giuseppe Farina", "Alain Prost", "Giuseppe Farina", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿En qué país se inventó el baloncesto?", "Estados Unidos", "Canadá", "Francia", "Inglaterra", "Canadá", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué selección de rugby ha ganado más veces la Copa del Mundo?", "Australia", "Inglaterra", "Nueva Zelanda", "Sudáfrica", "Nueva Zelanda", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién es el máximo goleador histórico de la NBA?", "Kobe Bryant", "Michael Jordan", "Karl Malone", "Kareem Abdul-Jabbar", "Kareem Abdul-Jabbar", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién es el tenista más joven en ganar un título de Grand Slam?", "Boris Becker", "Rafael Nadal", "Pete Sampras", "Björn Borg", "Boris Becker", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué piloto ha ganado más títulos de MotoGP?", "Valentino Rossi", "Marc Márquez", "Giacomo Agostini", "Mick Doohan", "Giacomo Agostini", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién fue el primer futbolista en ganar cinco Balones de Oro?", "Cristiano Ronaldo", "Lionel Messi", "Michel Platini", "Johan Cruyff", "Michel Platini", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué país ganó la Copa del Mundo de Rugby en 1995?", "Australia", "Sudáfrica", "Nueva Zelanda", "Inglaterra", "Sudáfrica", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién fue el primer piloto en ganar un Mundial de F1 con un coche híbrido?", "Sebastian Vettel", "Lewis Hamilton", "Kimi Räikkönen", "Nico Rosberg", "Sebastian Vettel", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué país ha ganado más Copas Mundiales de Cricket?", "India", "Australia", "Inglaterra", "Pakistán", "Australia", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién es el jugador con más goles en la historia de la Champions League?", "Lionel Messi", "Cristiano Ronaldo", "Raúl", "Karim Benzema", "Cristiano Ronaldo", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué boxeador tiene más títulos mundiales de peso completo?", "Muhammad Ali", "Joe Frazier", "George Foreman", "Vitali Klitschko", "Vitali Klitschko", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién es el atleta con más títulos mundiales en atletismo?", "Usain Bolt", "Michael Johnson", "Carl Lewis", "Florence Griffith-Joyner", "Carl Lewis", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Qué equipo de fútbol fue el primero en ganar la Copa Libertadores de América?", "Boca Juniors", "Peñarol", "Independiente", "River Plate", "Independiente", "deportes", "dificil",true),
                new PreguntaDTO(null, "¿Quién fue el primer futbolista en superar los 1000 goles oficiales?", "Pelé", "Ferenc Puskás", "Romario", "Cristiano Ronaldo", "Ferenc Puskás", "deportes", "dificil",true)


        );
    }


    public List<PreguntaDTO> getTodasLasPreguntas(String categoria , String dificultad) {
        List<Pregunta> preguntas = repositorioPregunta.findByCategoriaAndDificultadAndEstado(categoria , dificultad , true);


        Collections.shuffle(preguntas);


        List<Pregunta> preguntasAleatorias = preguntas.subList(0, Math.min(10, preguntas.size()));


        return preguntasAleatorias.stream()
                .map(pregunta -> modelMapper.map(pregunta, PreguntaDTO.class))
                .collect(Collectors.toList());
    }


}

