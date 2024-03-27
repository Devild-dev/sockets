package com.mycompany.sockets;

import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException{
               
        ServerSocket server = null;
        
        try{
            //instancia o serverSocket ouvindo a porta 12345
            server = new ServerSocket(12345); 
            System.out.println("servidor iniciado na porta 12345");
            
            while(true){
             //o método accept() bloqueia a execução até que o servidor receba uma solicitação de conexã pelo cliente*/
                Socket client = server.accept();
                new Manager(client);
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            
            try{
                if(server != null){
                    server.close();
                }
            }catch(IOException e1){
                //Erro por porta estar ocupada ou servidor fechado
                System.out.println("Erro: "+ e1.getMessage());            }
        }
        finally{
            System.out.println("...");
        }
        
    }
}
