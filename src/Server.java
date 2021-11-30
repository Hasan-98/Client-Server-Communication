/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;

/**
 *
 * @author hasan
 */
public class Server{
    public static void main(String [] args){
//        if (args.length < 1){
//            return;
//        }
//
//        String conn = args[0];
//        String host = args[1];
      //  int portNumber = Integer.parseInt(args[2]);
        int portNumber =4999;

            try{
               ServerSocket serverSocket = new ServerSocket(portNumber);
               System.out.println("Server is listening on port " + portNumber);
               while(true){
                   Socket socket = serverSocket.accept();
                   System.out.println("Client Found");
                   new ServerThread(socket).start();

               }
            }catch(Exception e){
                System.out.println("Server exception: " + e.getMessage());
                e.printStackTrace();
            }
        }


}
