package it.fi.meucci;

import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

class ServerThread extends Thread {

    ServerSocket socket = null;
    Socket client = null;
    String stringRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalCliente;
    DataOutputStream outVersoCliente;

    public ServerThread(Socket socket) {
        this.client = socket;
    }

    public void run() {
        try {
            comunica();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void comunica() throws Exception {
        inDalCliente = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoCliente = new DataOutputStream(client.getOutputStream());
        ObjectMapper message = new ObjectMapper();
        for (;;) {
            stringRicevuta = inDalCliente.readLine();
            Messaggo messaggio = message.readValue(stringRicevuta, Messaggo.class); 

            if (messaggio.getLista_biglietti().size() == 0){
                Messaggo m = new Messaggo(ServerStr.biglietti);
                outVersoCliente.writeBytes(message.writeValueAsString(m) + "\n");
            }

            else {

                ArrayList<Biglietto> biglietti_acquistati = new ArrayList<>();

                for (int i = 0; i < messaggio.getLista_biglietti().size(); i++) {
                    for (int j = 0; j < ServerStr.biglietti.size(); j++) {
                        if (messaggio.getLista_biglietti().get(i).id == ServerStr.biglietti.get(j).id){
                            biglietti_acquistati.add(messaggio.getLista_biglietti().get(i));
                            ServerStr.biglietti.remove(j);
                            j--;
                        }
                    }
                }

                Messaggo messagio = new Messaggo(biglietti_acquistati);
                outVersoCliente.writeBytes(message.writeValueAsString(messagio) + "\n");
        }
        outVersoCliente.close();
        inDalCliente.close();
        System.out.println("chiusura socket" + client);
        client.close();
    }
}

}