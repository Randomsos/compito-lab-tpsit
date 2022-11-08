package it.fi.meucci;

public class Biglietto {

    int id=0;
    String Posto;
    
    

    public Biglietto(int id, String numero_biglietto) {
        this.id = id;
        Posto = numero_biglietto;
    }

    public Biglietto() {
    }    
    
    //GETTER E SETTER

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPosto() {
        return Posto;
    }
    public void setPosto(String numero_biglietto) {
        Posto = numero_biglietto;
    }

    
}
