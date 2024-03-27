package com.mycompany.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//estende a classe Thread para conectar mais de um cliente
public class Manager extends Thread{
    private Socket cliente;
        
    //criar uma array do tipo agenda
    ArrayList<Agenda> ListaAgenda = new ArrayList<Agenda>();
    Agenda agenda = new Agenda(null,null,null);
    String opc;        
    String sair = "0";
    
    //Preenche o array para testes
    Agenda a = new Agenda("Davi","davi@email.com","71999999999");
    Agenda b = new Agenda("Joao","joao@gmail.com","75988888888");
    Agenda c = new Agenda("Maria","maria@gmail.com","73977777777");
    
    
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
            BufferedReader buffer = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter print = new PrintWriter(cliente.getOutputStream(), true);
            
            do{
                print.println("-------------------------------------------------------------");
                print.println("| Digite 1 para procurar pelo nome                          |");
                print.println("-------------------------------------------------------------");
                print.println("-------------------------------------------------------------");
                print.println("| Digite 2 para procurar pelo e-mail                        |");
                print.println("-------------------------------------------------------------");
                print.println("-------------------------------------------------------------");
                print.println("| Digite 3 para procurar pelo Nº do Celular                 |");
                print.println("-------------------------------------------------------------");
                print.println("-------------------------------------------------------------");
                print.println("| Digite 4 p/ nome, e-mail ou número desejado para consulta:|");
                print.println("-------------------------------------------------------------");    
                             
            opc = buffer.readLine();
            String msg;    
                switch(opc){
                    case "1":
                        print.println("Digite o nome");
                        msg = buffer.readLine();
                        agenda = verificaNome(ListaAgenda, msg);
                        break;
                    case "2":
                        print.println("Digite o e-mail");
                        msg = buffer.readLine();
                        agenda = verificaEmail(ListaAgenda, msg);
                        break;
                    case "3":
                        print.println("Digite o Nº do celular");
                        msg = buffer.readLine();
                        agenda = verificaCelular(ListaAgenda, msg);
                        break;
                    case "4":
                        print.println("Digite algum dado para encontrar");
                        msg = buffer.readLine();
                        agenda = verificaFull(ListaAgenda, msg);
                        break;
                    default:
                        print.println("\nValor inválido, tente novamente!\n");
                    }
                while(true){
                    print.println(agenda.getNome()+"\n"+agenda.getEmail()+"\n"+agenda.getCelular()+"\n");
                    break;
                }
            }while(sair != "1");
            
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }   
    }

    public Agenda verificaNome(ArrayList<Agenda> AgendaList, String s) {
        Agenda a = new Agenda(null, null, null);

        for (int i = 0; i < AgendaList.size(); i++) {
            if (AgendaList.get(i).getNome().equalsIgnoreCase(s)) {
                a = AgendaList.get(i);
                break;
            } else {
                a.setNome("Nome não encontrado");
                a.setCelular("Nº não encontrado");
                a.setEmail("E-mail não encontrado");
            }
        }
        return a;
    }

    public Agenda verificaEmail(ArrayList<Agenda> AgendaList, String s) {
        Agenda a = new Agenda(null, null, null);

        for (int i = 0; i < AgendaList.size(); i++) {
            if (AgendaList.get(i).getEmail().equalsIgnoreCase(s)) {
                a = AgendaList.get(i);
                break;
            } else {
                a.setNome("Nome não encontrado");
                a.setCelular("Nº não encontrado");
                a.setEmail("E-mail não encontrado");
            }
        }
        return a;
    }

    public Agenda verificaCelular(ArrayList<Agenda> AgendaList, String s) {
        Agenda a = new Agenda(null, null, null);

        for (int i = 0; i < AgendaList.size(); i++) {
            if (AgendaList.get(i).getCelular().equalsIgnoreCase(s)) {
                a = AgendaList.get(i);
                break;
            } else {
                a.setNome("Nome não encontrado");
                a.setCelular("Nº não encontrado");
                a.setEmail("E-mail não encontrado");
            }
        }
        return a;
    }

    public Agenda verificaFull(ArrayList<Agenda> AgendaList, String s) {
        Agenda a = new Agenda(null, null, null);

        for (int i = 0; i < AgendaList.size(); i++) {
            if (AgendaList.get(i).getNome().equalsIgnoreCase(s)) {
                a = AgendaList.get(i);
                break;
            } else if (AgendaList.get(i).getEmail().equalsIgnoreCase(s)) {
                a = AgendaList.get(i);
                break;
            } else if (AgendaList.get(i).getCelular().equalsIgnoreCase(s)) {
                a = AgendaList.get(i);
                break;
            } else {
                a.setNome("Nome não encontrado");
                a.setCelular("Nº não encontrado");
                a.setEmail("E-mail não encontrado");
            }
        }
        return a;
    }
}