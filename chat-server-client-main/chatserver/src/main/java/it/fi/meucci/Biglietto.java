package it.fi.meucci;

//import com.fasterxml.jackson.databind.node.NumericNode;

public class Biglietto {

    int id=0;
    String posto;

    //GETTER E SETTER

    public Biglietto(int id, String posto) {
        this.id = id;
        this.posto = posto;
    }


    public Biglietto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }    
    
    
}
