package it.fi.meucci;

//import com.fasterxml.jackson.databind.node.NumericNode;

public class BigliettoServer {

    int id=0;
    String Numero_biglietto;

    

    public BigliettoServer(int id, String numero_biglietto) {
        this.id = id;
        Numero_biglietto = numero_biglietto;
    }

    //GETTER E SETTER

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero_biglietto() {
        return Numero_biglietto;
    }
    public void setNumero_biglietto(String numero_biglietto) {
        Numero_biglietto = numero_biglietto;
    }

    
    
}
