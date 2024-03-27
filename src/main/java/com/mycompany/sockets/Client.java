package com.mycompany.sockets;

import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) throws IOException{
        try{
            Socket cliente = new Socket("localhost", 12345);
            //lendo mensagens do servidor
            new Thread(){
                @Override
                public void run(){
                    try{
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                        
                        
                        while (true) {                            
                            String mensagem = buffer.readLine();
                            System.out.println("Resposta do servidor: " + mensagem);
                        }
                    }catch(IOException e){
                        System.out.println("Erro: "+ e.getMessage());
                    }
                }
            }.start();
            
            //escrevendo para o servidor
            PrintWriter print = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader bufferTerminal = new BufferedReader(new InputStreamReader(System.in));
            
            while(true){
                String mensagemTerminal = bufferTerminal.readLine();
                print.println(mensagemTerminal);
            }
            
        }catch(Exception e){
            System.out.println("Erro :"+ e.getMessage());
        }
    }
}