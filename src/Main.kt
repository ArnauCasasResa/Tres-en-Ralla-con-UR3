import java.io.PrintWriter
import java.net.ServerSocket
import java.util.Random
import java.util.Scanner

fun main() {
    //Conexion Socket
    val port = 5858
    // Obrir el servidor

    val serverSocket = ServerSocket(port)
    println("Attempting to start socket server...")
    // Obrir la porta a clients
    val clientSocket = serverSocket.accept()
    println("Connected succesfully")
    val output = PrintWriter(clientSocket.getOutputStream(), true)
    //-------------------------------------------------------------------------------------------------
    //Cosas para el juego
    val scan = Scanner(System.`in`)
    val juego = TresEnRalla()
    var salida = false
    val menuOptions= listOf("1.Poner ficha","2.Consultar Tablero","3.Exit")

    while (!salida){

        println("---------------------------")
        println("TURNO DEL ${juego.turno}")
        println("---------------------------")
        for (i in menuOptions){
            println(i)
        }
        val optionSelected = scan.nextInt()
        when(optionSelected){
            1->{
                val posiciones=seleccionarPosiciones(juego.turno)
                println(posiciones)
                val envio=enviarRobotPosiFicha(juego.turno,posiciones)
                if (juego.comprovacionFichaPossible(posiciones.first,posiciones.second)) {
                    output.println(envio)
                }
                juego.ponerFicha(posiciones.first,posiciones.second,output,envio)
            }
            2->{juego.mostrarTablero()}
            3->{salida=true}
        }
        if (juego.comprobacionGanador().first){
            salida=true
        }
    }
    if (juego.comprobacionGanador().first){
        println("ENHORABUENA HAS GANADOR")
    }
    println("¡GRACIAS POR JUGAR!")
    serverSocket.close()
}

fun seleccionarPosiciones(player:String):Pair<Int,Int>{
    var fila = 0
    var columna = 0
    val nRandom= Random()
    if (player=="JUGADOR1"){
        val scan = Scanner(System.`in`)
        println("Que fila quieres seleccionar para poner tu ficha?")
        fila=scan.nextInt()
        println("Que columna quieres seleccionar para poner tu ficha?")
        columna=scan.nextInt()
    }else{
        fila=nRandom.nextInt(3) + 1
        columna=nRandom.nextInt(3) + 1
    }

    return Pair(columna-1,fila-1)
}
fun enviarRobotPosiFicha(jugador:String,posiciones:Pair<Int,Int>):String{
    var mensaje=""
    when(posiciones){
        Pair(0,0)->{mensaje+="1"}
        Pair(1,0)->{mensaje+="2"}
        Pair(2,0)->{mensaje+="3"}
        Pair(0,1)->{mensaje+="4"}
        Pair(1,1)->{mensaje+="5"}
        Pair(2,1)->{mensaje+="6"}
        Pair(0,2)->{mensaje+="7"}
        Pair(1,2)->{mensaje+="8"}
        Pair(2,2
        )->{mensaje+="9"}
    }
    return if(jugador=="JUGADOR1"){
        "$mensaje X"
    }else{
        "$mensaje O"
    }
}