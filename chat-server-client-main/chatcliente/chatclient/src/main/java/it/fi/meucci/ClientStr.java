package it.fi.meucci;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
public class ClientStr {
    String nomeServer="localhost";
    int portaServer = 7777;
    Socket miosocket;
    BufferedReader tastiera; 
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalSever;


    public Socket connetti(){
        System.out.println("2 CLIENT partito in esecuzione: ");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer);
            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalSever = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        }

        catch (UnknownHostException e){
            System.err.println("Host sconosciuto");
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);
        }

        return miosocket;
    }

    public void comunica(){
        try{
            for(;;){
                
                //serializzazione della lisa e invio
                ObjectMapper lista = new ObjectMapper();
                ArrayList<Biglietto> bigliettiSelezionati = new ArrayList<Biglietto>();
                Messago listaVuota = new Messago(bigliettiSelezionati);
                outVersoServer.writeBytes(lista.writeValueAsString(listaVuota) + "\n");
                
                String bigliettiDisponibili = inDalSever.readLine();
                Messago messaggio = lista.readValue(bigliettiDisponibili, Messago.class);

                stringaUtente = tastiera.readLine();
                outVersoServer.writeBytes(stringaUtente+'\n');

                stringaRicevutaDalServer= inDalSever.readLine();

                System.out.println("Biglietti disponibili:");
                for (int i = 0; i < messaggio.getSize(); i++) {
                System.out.println("ID: " + messaggio.biglietti.get(i).getId() + " - " + messaggio.biglietti.get(i).getPosto());
            }
            }
            //System.out.println("9 CLIENT: termina nelaborazione e chiude connessione");
            //miosocket.close();
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione");
            System.exit(1);
        }
        }

}
