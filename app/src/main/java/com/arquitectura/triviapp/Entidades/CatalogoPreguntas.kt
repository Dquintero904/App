package com.arquitectura.triviapp.Entidades

class CatalogoPreguntas {

    fun insertAll(): List<Pregunta> {

        val iList: MutableList<Pregunta> = mutableListOf()

        val q1 = Pregunta(
            id = null,
            pregunta = "¿Cuál de los siguientes no es un número primo?",
            op1 = "31",
            op2 = "61",
            op3 = "71",
            op4 = "91",
            respuesta  = "91",
            categoria = "matematicas"
        )

        val q2 = Pregunta(
            id = null,
            pregunta = "¿Qué número mínimo debe sumarse a 1056 para que el resultado sea divisible completamente por 23?",
            op1 = "2",
            op2 = "3",
            op3 = "18",
            op4 = "21",
            respuesta  = "2",
            categoria = "matematicas"
        )

        val q3 = Pregunta(
            id = null,
            pregunta = "¿1397 x 1397 = ?",
            op1 = "1981709",
            op2 = "1951609",
            op3 = "18362619",
            op4 = "2031719",
            respuesta  = "1951609",
            categoria = "matematicas"
        )

        val q4 = Pregunta(
            id = null,
            pregunta = "El mayor número de 4 dígitos exactamente divisible por 88 es:",
            op1 = "8888",
            op2 = "9768",
            op3 = "9988",
            op4 = "9944",
            respuesta  = "9944",
            categoria = "matematicas"
        )

        val q5 = Pregunta(
            id = null,
            pregunta = "¿Cuál de los siguientes es un número primo?",
            op1 = "33",
            op2 = "81",
            op3 = "93",
            op4 = "97",
            respuesta  = "97",
            categoria = "matematicas"
        )

        val q6 = Pregunta(
            id = null,
            pregunta = "El porcentaje de tierra irrigada en la India es aproximadamente",
            op1 = "45%",
            op2 = "65%",
            op3 = "35%",
            op4 = "25%",
            respuesta  = "35%",
            categoria = "geografia"
        )

        val q7 = Pregunta(
            id = null,
            pregunta = "¿Cuál es la capital del subcontinente indio?",
            op1 = "Berlín",
            op2 = "Delhi",
            op3 = "Chennai",
            op4 = "Estocolmo",
            respuesta  = "Delhi",
            categoria = "geografia"
        )

        val q8 = Pregunta(
            id = null,
            pregunta = "El estado con la mayor área de cobertura forestal en la India es",
            op1 = "Arunachal Pradesh",
            op2 = "Haryana",
            op3 = "Madhya Pradesh",
            op4 = "Assam",
            respuesta  = "Madhya Pradesh",
            categoria = "geografia"
        )

        val q9 = Pregunta(
            id = null,
            pregunta = "Las montañas más antiguas de la India son:",
            op1 = "Aravalis",
            op2 = "Vindhyas",
            op3 = "Satpuras",
            op4 = "Colinas Nilgiri",
            respuesta  = "Aravalis",
            categoria = "geografia"
        )

        val q10 = Pregunta(
            id = null,
            pregunta = "¿Qué país tiene la mayor población?",
            op1 = "India",
            op2 = "Japón",
            op3 = "China",
            op4 = "Shillong",
            respuesta  = "China",
            categoria = "geografia"
        )

        val q11 = Pregunta(
            id = null,
            pregunta = "¿Sobre cuál de estos personajes escribió Mark Twain?",
            op1 = "Niño azul",
            op2 = "Dennis el travieso",
            op3 = "Caperucita roja",
            op4 = "Tom Sawyer",
            respuesta  = "Tom Sawyer",
            categoria = "literatura"
        )

        val q12 = Pregunta(
            id = null,
            pregunta = "¿Quién escribió \"Matar a un ruiseñor\"?",
            op1 = "Dr. Seuss",
            op2 = "Harper Lee",
            op3 = "Ronald Reagan",
            op4 = "John Lennon",
            respuesta  = "Harper Lee",
            categoria = "literatura"
        )

        val q13 = Pregunta(
            id = null,
            pregunta = "¿Cuál obra de Shakespeare presenta a amantes que se suicidan?",
            op1 = "Romeo y Julieta",
            op2 = "La paloma solitaria",
            op3 = "Desayuno en Tiffany's",
            op4 = "Corre conejo corre",
            respuesta  = "Romeo y Julieta",
            categoria = "literatura"
        )

        val q14 = Pregunta(
            id = null,
            pregunta = "¿Qué describe mejor \"Rebelión en la granja\" de George Orwell?",
            op1 = "Mujeres/Ciclos mensuales",
            op2 = "Babe Ruth/Yankees",
            op3 = "Dinosaurios/Barney",
            op4 = "Animales/Comunismo",
            respuesta  = "Animales/Comunismo",
            categoria = "literatura"
        )

        val q15 = Pregunta(
            id = null,
            pregunta = "¿Qué libro se centra en un caballo?",
            op2 = "Rebelión en la granja",
            op1 = "Los Muppets",
            op3 = "Belleza negra",
            op4 = "Atrapado sin salida",
            respuesta  = "Belleza negra",
            categoria = "literatura"
        )

        val q16 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el valor de π (Pi) aproximado a dos decimales?",
            op1 = "3.12",
            op2 = "3.14",
            op3 = "3.16",
            op4 = "3.18",
            respuesta  = "3.14",
            categoria = "matematicas"
        )

        val q17 = Pregunta(
            id = null,
            pregunta = "¿Cuánto es 12 al cuadrado?",
            op1 = "124",
            op2 = "132",
            op3 = "144",
            op4 = "154",
            respuesta  = "144",
            categoria = "matematicas"
        )

        val q18 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el resultado de 25 x 25?",
            op1 = "525",
            op2 = "625",
            op3 = "725",
            op4 = "825",
            respuesta  = "625",
            categoria = "matematicas"
        )

        val q19 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el valor absoluto de -15?",
            op1 = "-15",
            op2 = "15",
            op3 = "0",
            op4 = "-1",
            respuesta  = "15",
            categoria = "matematicas"
        )

        val q20 = Pregunta(
            id = null,
            pregunta = "¿Cuál es la raíz cuadrada de 64?",
            op1 = "6",
            op2 = "7",
            op3 = "8",
            op4 = "9",
            respuesta  = "8",
            categoria = "matematicas"
        )

        val q21 = Pregunta(
            id = null,
            pregunta = "¿Cuántos grados tiene un triángulo equilátero en total?",
            op1 = "90",
            op2 = "180",
            op3 = "270",
            op4 = "360",
            respuesta  = "180",
            categoria = "matematicas"
        )

        val q22 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el número primo más pequeño?",
            op1 = "1",
            op2 = "2",
            op3 = "3",
            op4 = "5",
            respuesta  = "2",
            categoria = "matematicas"
        )

        val q23 = Pregunta(
            id = null,
            pregunta = "Si un coche recorre 60 km en una hora, ¿cuánto tiempo tomará recorrer 180 km a la misma velocidad?",
            op1 = "2 horas",
            op2 = "3 horas",
            op3 = "4 horas",
            op4 = "5 horas",
            respuesta  = "3 horas",
            categoria = "matematicas"
        )

        val q24 = Pregunta(
            id = null,
            pregunta = "¿Cuántos lados tiene un decágono?",
            op1 = "8",
            op2 = "9",
            op3 = "10",
            op4 = "12",
            respuesta  = "10",
            categoria = "matematicas"
        )

        val q25 = Pregunta(
            id = null,
            pregunta = "¿Cuál es la fórmula del área de un círculo?",
            op1 = "πr²",
            op2 = "2πr",
            op3 = "r²",
            op4 = "πd",
            respuesta  = "πr²",
            categoria = "matematicas"
        )

        val q26 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el río más largo del mundo?",
            op1 = "Río Amazonas",
            op2 = "Río Nilo",
            op3 = "Río Yangtsé",
            op4 = "Río Misisipi",
            respuesta  = "Río Nilo",
            categoria = "geografia"
        )

        val q27 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el país más grande del mundo por área?",
            op1 = "China",
            op2 = "Estados Unidos",
            op3 = "Rusia",
            op4 = "Canadá",
            respuesta  = "Rusia",
            categoria = "geografia"
        )

        val q28 = Pregunta(
            id = null,
            pregunta = "¿En qué continente se encuentra el desierto del Sahara?",
            op1 = "Asia",
            op2 = "África",
            op3 = "América del Sur",
            op4 = "Oceanía",
            respuesta  = "África",
            categoria = "geografia"
        )

        val q29 = Pregunta(
            id = null,
            pregunta = "¿Cuál es la montaña más alta del mundo?",
            op1 = "Monte Kilimanjaro",
            op2 = "Monte Everest",
            op3 = "Mont Blanc",
            op4 = "Monte Aconcagua",
            respuesta  = "Monte Everest",
            categoria = "geografia"
        )

        val q30 = Pregunta(
            id = null,
            pregunta = "¿Qué país tiene más islas en el mundo?",
            op1 = "Suecia",
            op2 = "Filipinas",
            op3 = "Indonesia",
            op4 = "Maldivas",
            respuesta  = "Suecia",
            categoria = "geografia"
        )

        val q31 = Pregunta(
            id = null,
            pregunta = "¿Cuál es la capital de Canadá?",
            op1 = "Toronto",
            op2 = "Ottawa",
            op3 = "Vancouver",
            op4 = "Montreal",
            respuesta  = "Ottawa",
            categoria = "geografia"
        )

        val q32 = Pregunta(
            id = null,
            pregunta = "¿Qué océano baña las costas occidentales de América del Sur?",
            op1 = "Océano Atlántico",
            op2 = "Océano Índico",
            op3 = "Océano Pacífico",
            op4 = "Océano Ártico",
            respuesta  = "Océano Pacífico",
            categoria = "geografia"
        )

        val q33 = Pregunta(
            id = null,
            pregunta = "¿En qué país se encuentra la torre inclinada de Pisa?",
            op1 = "España",
            op2 = "Francia",
            op3 = "Italia",
            op4 = "Grecia",
            respuesta  = "Italia",
            categoria = "geografia"
        )

        val q34 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el país más poblado del mundo?",
            op1 = "India",
            op2 = "China",
            op3 = "Estados Unidos",
            op4 = "Brasil",
            respuesta  = "China",
            categoria = "geografia"
        )

        val q35 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el país más pequeño del mundo por área?",
            op1 = "Mónaco",
            op2 = "San Marino",
            op3 = "Vaticano",
            op4 = "Liechtenstein",
            respuesta  = "Vaticano",
            categoria = "geografia"
        )

        val q36 = Pregunta(
            id = null,
            pregunta = "¿Quién escribió la novela \"Cien años de soledad\"?",
            op1 = "Pablo Neruda",
            op2 = "Gabriel García Márquez",
            op3 = "Mario Vargas Llosa",
            op4 = "Jorge Luis Borges",
            respuesta  = "Gabriel García Márquez",
            categoria = "literatura"
        )

        val q37 = Pregunta(
            id = null,
            pregunta = "¿Cuál es la obra más famosa de Miguel de Cervantes?",
            op1 = "El Lazarillo de Tormes",
            op2 = "Don Quijote de la Mancha",
            op3 = "La Celestina",
            op4 = "La Regenta",
            respuesta  = "Don Quijote de la Mancha",
            categoria = "literatura"
        )

        val q38 = Pregunta(
            id = null,
            pregunta = "¿En qué país nació William Shakespeare?",
            op1 = "Francia",
            op2 = "España",
            op3 = "Inglaterra",
            op4 = "Italia",
            respuesta  = "Inglaterra",
            categoria = "literatura"
        )

        val q39 = Pregunta(
            id = null,
            pregunta = "¿Qué autor escribió la novela \"Moby Dick\"?",
            op1 = "Herman Melville",
            op2 = "Mark Twain",
            op3 = "Jules Verne",
            op4 = "Robert Louis Stevenson",
            respuesta  = "Herman Melville",
            categoria = "literatura"
        )

        val q40 = Pregunta(
            id = null,
            pregunta = "¿Qué poeta chileno escribió \"Veinte poemas de amor y una canción desesperada\"?",
            op1 = "Pablo Neruda",
            op2 = "Gabriela Mistral",
            op3 = "Octavio Paz",
            op4 = "César Vallejo",
            respuesta  = "Pablo Neruda",
            categoria = "literatura"
        )

        val q41 = Pregunta(
            id = null,
            pregunta = "¿Qué obra es famosa por la frase \"Ser o no ser, esa es la cuestión\"?",
            op1 = "Macbeth",
            op2 = "El Rey Lear",
            op3 = "Hamlet",
            op4 = "Otelo",
            respuesta  = "Hamlet",
            categoria = "literatura"
        )

        val q42 = Pregunta(
            id = null,
            pregunta = "¿Quién es el autor de \"El gran Gatsby\"?",
            op1 = "Ernest Hemingway",
            op2 = "F. Scott Fitzgerald",
            op3 = "John Steinbeck",
            op4 = "William Faulkner",
            respuesta  = "F. Scott Fitzgerald",
            categoria = "literatura"
        )

        val q43 = Pregunta(
            id = null,
            pregunta = "¿Qué novela de George Orwell describe un futuro distópico bajo un régimen totalitario?",
            op1 = "Rebelión en la granja",
            op2 = "1984",
            op3 = "Un mundo feliz",
            op4 = "Fahrenheit 451",
            respuesta  = "1984",
            categoria = "literatura"
        )

        val q44 = Pregunta(
            id = null,
            pregunta = "¿Quién escribió \"Orgullo y prejuicio\"?",
            op1 = "Charlotte Brontë",
            op2 = "Emily Brontë",
            op3 = "Mary Shelley",
            op4 = "Jane Austen",
            respuesta  = "Jane Austen",
            categoria = "literatura"
        )

        val q45 = Pregunta(
            id = null,
            pregunta = "¿Cuál es el título de la famosa obra épica de Homero?",
            op1 = "La Ilíada",
            op2 = "La Eneida",
            op3 = "La Odisea",
            op4 = "Los trabajos de Hércules",
            respuesta  = "La Ilíada",
            categoria = "literatura"
        )


        iList.add(q1)
        iList.add(q2)
        iList.add(q3)
        iList.add(q4)
        iList.add(q5)
        iList.add(q6)
        iList.add(q7)
        iList.add(q8)
        iList.add(q9)
        iList.add(q10)
        iList.add(q11)
        iList.add(q12)
        iList.add(q13)
        iList.add(q14)
        iList.add(q15)
        iList.add(q16)
        iList.add(q17)
        iList.add(q18)
        iList.add(q19)
        iList.add(q20)
        iList.add(q21)
        iList.add(q22)
        iList.add(q23)
        iList.add(q24)
        iList.add(q25)
        iList.add(q26)
        iList.add(q27)
        iList.add(q28)
        iList.add(q29)
        iList.add(q30)
        iList.add(q31)
        iList.add(q32)
        iList.add(q33)
        iList.add(q34)
        iList.add(q35)
        iList.add(q36)
        iList.add(q37)
        iList.add(q38)
        iList.add(q39)
        iList.add(q40)
        iList.add(q41)
        iList.add(q42)
        iList.add(q43)
        iList.add(q44)
        iList.add(q45)



        return iList
    }
}