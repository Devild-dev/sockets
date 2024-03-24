package com.mycompany.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//estende a classe Thread para conectar mais de um cliente
public class Manager extends Thread{
    private Socket cliente;
    private String nomeCliente;
    
    //criar uma array do tipo agenda
    Agenda a = new Agenda("Davi","davi@email.com","71999999999");
    Agenda b = new Agenda("Joao","joao@gmail.com","75988888888");
    Agenda c = new Agenda("Maria","maria@gmail.com","73977777777");
        
    ArrayList<Agenda> ListaAgenda = new ArrayList<Agenda>();
    Agenda agenda = new Agenda(null,null,null);
    String opc;        
    String sair = "0";
    
    public Manager(Socket cliente){
        this.cliente = cliente;
        start();
    }
    
    @Override
    public void run(){
         ListaAgenda.add(0,a);
         ListaAgenda.add(1,b);
         ListaAgenda.add(2,c);
        try{
            //lê as mensagens do cliente
            BufferedReader buffer = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            //escreve as mensagens
            PrintWriter print = new PrintWriter(cliente.getOutputStream(), true);
            
            print.println("Digite o nome, e-mail ou número desejado para consulta:");
            
            Agenda mensagem = new Agenda(null,null,null);
            
            do{
                print.println("----------------------------------------------");
                print.println("| Digite 1 para procurar pelo nome           |");
                print.println("----------------------------------------------");
                print.println("----------------------------------------------");
                print.println("| Digite 2 para procurar pelo e-mail         |");
                print.println("----------------------------------------------");
                print.println("----------------------------------------------");
                print.println("| Digite 3 para procurar pelo Nº do Celular  |");
                print.println("----------------------------------------------");
            
            opc = buffer.readLine();
            String msg;    
                switch(opc){
                    case "1":
                        print.println("Digite o nome");
                        mensagem.setNome(buffer.readLine());
                        mensagem.setEmail(null);
                        mensagem.setCelular(null);
                        print.println("Teste 1"+ mensagem.getNome());
                        print.println("Teste 1"+ mensagem.getEmail());
                        print.println("Teste 1"+ mensagem.getCelular());
                        break;
                    case "2":
                        print.println("Digite o e-mail");
                        mensagem.setEmail(buffer.readLine());
                        mensagem.setNome(null);
                        mensagem.setCelular(null);
                        print.println("Teste 2"+ mensagem.getNome());
                        print.println("Teste 2"+ mensagem.getEmail());
                        print.println("Teste 2"+ mensagem.getCelular());
                        break;
                    case "3":
                        print.println("Digite o Nº do celular");
                        mensagem.setCelular(buffer.readLine()); 
                        mensagem.setNome(null);
                        mensagem.setCelular(null);
                        print.println("Teste 3"+ mensagem.getNome());
                        print.println("Teste 3"+ mensagem.getEmail());
                        print.println("Teste 3"+ mensagem.getCelular());
                        break;
                    default:
                        print.println("\nValor inválido, tente novamente!\n");
                    } 
                while(true){
                    if (mensagem.getNome().equals("Davi")) {
                        print.println("Nome: " + ListaAgenda.get(0).getNome() + "\nE-mail: " + ListaAgenda.get(0).getEmail() + "\nCelular: " + ListaAgenda.get(0).getCelular());
                    } else if (mensagem.getNome().equals("Joao")) {
                        print.println("Nome: " + ListaAgenda.get(1).getNome() + "\nE-mail: " + ListaAgenda.get(1).getEmail() + "\nCelular: " + ListaAgenda.get(1).getCelular());
                    } else if ((mensagem.getNome().equals("Maria"))) {
                        print.println("Nome: " + ListaAgenda.get(2).getNome() + "\nE-mail: " + ListaAgenda.get(2).getEmail() + "\nCelular: " + ListaAgenda.get(2).getCelular());
                    } else {
                        print.println("Nome desconhecido");
                    }
                    break;
                }
        }while(sair != "1");
            
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }   
    }
}


