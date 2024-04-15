package com.mycompany.sockets;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPCliente {
    public static void main(String[] args){
        
        try{
            Scanner read = new Scanner(System.in); 
            DatagramSocket client = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            
            int a = 0;
            int b = 0;
            int soma = 0;
            
            System.out.println("Digite um número");
            a = read.nextInt();
            System.out.println("Digite outro número");
            b = read.nextInt();
            //soma = a + b;
            soma = Soma(a,b);
            
            String str = soma + "";
            System.out.println("Soma igual a: "+ soma);
            
            byte[] buf = str.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, add, 12346);
            client.send(packet);
            client.close();
        }catch(IOException e){
            System.out.println("Erro: " + e);
        }
    }
    
    public static int Soma(int a, int b){
        int c;
        c = a+b;
        return c;
    }
    public static int Subtracao(int a, int b){
        int c;
        c = a-b;
        return c;
    }
    public static int Multiplicacao(int a, int b){
        int c;
        c = a*b;
        return c;
    }
    public static int Divisao(int a, int b){
        int c;
        if(a>b){
           c = a/b;
        }else{
            c = b/a;
        }
        return c;
    }
}
