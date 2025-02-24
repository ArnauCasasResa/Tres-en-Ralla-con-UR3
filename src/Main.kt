import java.io.PrintWriter
import java.net.ServerSocket
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
                val posiciones=seleccionarPosiciones()
                juego.ponerFicha(posiciones.first,posiciones.second,output)
                val envio=enviarRobotPosiFicha(juego.turno,posiciones)
                output.println(envio)
                juego.cambiarTurno()
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
}


/*
   val port = 5858
    // Obrir el servidor
    val serverSocket = ServerSocket(port)
    println("Attempting to start socket server...")

    // Obrir la porta a clients
    val clientSocket = serverSocket.accept()
    val output = PrintWriter(clientSocket.getOutputStream(), true)

    // Llegir el que diu el robot
    val input = BufferedReader(InputStreamReader(clientSocket.getInputStream(),"utf8"))
    val actualPose: String = input.readLine()
    println("This is my actual pose :$actualPose")


    // actual pose to final pose
    while(true){
        output.println("(0.222887,0.141989,0.24792,1.23286,-1.20128,-1.22264)")

    }

    //Tancar el server
    serverSocket.close()
 */

fun seleccionarPosiciones():Pair<Int,Int>{
    val scan = Scanner(System.`in`)
    println("Que fila quieres seleccionar para poner tu ficha?")
    val fila=scan.nextInt()
    println("Que columna quieres seleccionar para poner tu ficha?")
    val columna=scan.nextInt()
    return Pair(columna-1,fila-1)
}
fun enviarRobotPosiFicha(jugador:String,posiciones:Pair<Int,Int>):String{
    var mensaje=""
    when(posiciones){
        Pair(0,0)->{mensaje+="1"}
        Pair(0,2)->{mensaje+="2"}
        Pair(0,2)->{mensaje+="3"}
        Pair(1,0)->{mensaje+="4"}
        Pair(1,1)->{mensaje+="5"}
        Pair(1,2)->{mensaje+="6"}
        Pair(2,0)->{mensaje+="7"}
        Pair(2,1)->{mensaje+="8"}
        Pair(2,2)->{mensaje+="9"}
    }
    return if(jugador=="JUGADOR1"){
        "$mensaje X"
    }else{
        "$mensaje O"
    }
}