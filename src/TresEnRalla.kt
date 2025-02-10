class TresEnRalla {
    var turno = "JUGADOR1"
    private var tablero = mutableListOf(
        mutableListOf("n", "n", "n"),
        mutableListOf("n", "n", "n"),
        mutableListOf("n", "n", "n")
    )

    private fun cambiarTurno() {
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
        if (comprovacionFichaPossible(columna, fila) == true) {
            if (turno == "JUGADOR1") {
                tablero[fila][columna] = "X"
            } else if (turno == "JUGADOR2") {
                tablero[fila][columna] = "O"
            }
            cambiarTurno()
        } else {
            println("En esta casilla no se puede poner una ficha, ya hay una ficha alli!")
        }
    }

    private fun comprovacionFichaPossible(columna: Int, fila: Int): Boolean {
        var sePuede = false
        if (tablero[fila][columna] != "n") {
            sePuede = true
        }
        return sePuede
    }
    fun comprobacionGanador(){
        //TODO
    }
}