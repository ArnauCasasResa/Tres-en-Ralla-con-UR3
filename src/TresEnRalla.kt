import java.io.PrintWriter

class TresEnRalla {
    var turno = "JUGADOR1"
    private var tablero = mutableListOf(
        mutableListOf("n", "n", "n"),
        mutableListOf("n", "n", "n"),
        mutableListOf("n", "n", "n")
    )

    fun cambiarTurno() {
        if (turno == "JUGADOR1") {
            turno = "JUGADOR2"
        } else if (turno == "JUGADOR2") {
            turno = "JUGADOR1"
        }
    }

    fun mostrarTablero() {
        for (fila in tablero) {
            for (casilla in fila) {
                print(casilla)
            }
            println()
        }
    }

    fun ponerFicha(columna: Int, fila: Int) {
        if (comprovacionFichaPossible(columna, fila)) {
            if (turno == "JUGADOR1") {
                tablero[fila][columna] = "X"
                //conexion.println(mensaje)
            } else if (turno == "JUGADOR2") {
                tablero[fila][columna] = "O"
            }
            cambiarTurno()
        } else {
            println("En esta casilla no se puede poner una ficha, ya hay una ficha alli!")
        }
    }

    fun comprovacionFichaPossible(columna: Int, fila: Int): Boolean {
        var sePuede = true
        if (tablero[fila][columna] != "n") {
            sePuede = false
        }
        return sePuede
    }
    fun comprobacionGanador(): Pair<Boolean, String> {
        var ganador = false
        var jugadorGanador = ""

        // Comprobar filas
        for (fila in tablero) {
            if (fila[0] != "n" && fila[0] == fila[1] && fila[1] == fila[2]) {
                ganador = true
                jugadorGanador = if (fila[0] == "X") "JUGADOR1" else "JUGADOR2"
            }
        }

        // Comprobar columnas
        for (columna in 0..2) {
            if (tablero[0][columna] != "n" && tablero[0][columna] == tablero[1][columna] && tablero[1][columna] == tablero[2][columna]) {
                ganador = true
                jugadorGanador = if (tablero[0][columna] == "X") "JUGADOR1" else "JUGADOR2"
            }
        }

        // Comprobar diagonales
        if (tablero[0][0] != "n" && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            ganador = true
            jugadorGanador = if (tablero[0][0] == "X") "JUGADOR1" else "JUGADOR2"
        }
        if (tablero[0][2] != "n" && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            ganador = true
            jugadorGanador = if (tablero[0][2] == "X") "JUGADOR1" else "JUGADOR2"
        }

        return Pair(ganador, jugadorGanador)
    }
}