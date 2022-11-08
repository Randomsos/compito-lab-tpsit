package it.fi.meucci;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServerStr {

    ServerSocket server = null;
    Socket client = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoCliente;
    
    public static ArrayList<Biglietto> biglietti = new ArrayList<>();
    private static int ID_biglietti = 0;

    public ServerStr(){
        Biglietto prova1 = new Biglietto(1, "palco-1");
        Biglietto prova2 = new Biglietto(2, "palco-2");
        Biglietto prova3 = new Biglietto(3, "palco-3");

        biglietti.add(prova1);
        biglietti.add(prova2);
        biglietti.add(prova3);
    }

    public void avvia(){
        try{
            ServerSocket serversocket = new ServerSocket(7777);
            for(;;){
                System.out.println("Attesa di un cliente...");
                Socket socket =  serversocket.accept();
                System.out.println("Client accettato" + '\n');
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            } 
        }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Errore durante l'istanza del server");
                System.exit(1);
            }
        }




}
