class TresEnRalla{
    var turno="player1"
    var tablero = listOf(listOf("n","n","n"),listOf("n","n","n"),listOf("n","n","n"))
    fun cambiarTurno(){
        if (turno=="player1"){
            turno="player2"
        }else if(turno=="player2"){
            turno="player1"
        }
    }
    fun mostrarTablero(){
        for(fila in tablero){
            for(casilla in fila){
                print(casilla)
            }
            println()
        }
    }
}