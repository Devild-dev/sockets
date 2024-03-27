package com.mycompany.sockets;

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args){
        try{
            DatagramSocket server = new DatagramSocket(12346);
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            server.receive(packet);
            String response = new String(packet.getData());
            System.out.println("Resposta do dado: "+ response);
            server.close();
        }catch(IOException e){
            System.out.println("Erro: " + e);
        }
    }
}
