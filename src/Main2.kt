import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.util.Scanner

fun main() {
    val port = 5858
    // Obrir el servidor
    val serverSocket = ServerSocket(port)
    println("Attempting to start socket server...")

    // Obrir la porta a clients
    val clientSocket = serverSocket.accept()
    println("Connected succesfully")
    val output = PrintWriter(clientSocket.getOutputStream(), true)

    // Llegir el que diu el robot
    /*
    val input = BufferedReader(InputStreamReader(clientSocket.getInputStream(),"utf8"))
    val actualPose: String = input.readLine()
    println("This is my actual pose :$actualPose")
    */

    // actual pose to final pose

        output.println("(0.222887,0.141989,0.24792,1.23286,-1.20128,-1.22264)")



    //Tancar el server
    serverSocket.close()
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