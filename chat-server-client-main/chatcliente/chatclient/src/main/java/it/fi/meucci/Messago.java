package it.fi.meucci;

import java.util.ArrayList;

public class Messago {

    ArrayList<Biglietto> biglietti = new ArrayList<>();
    
    public Messago (){}
    public Messago(ArrayList<Biglietto> lista_biglietti) {
        this.biglietti = lista_biglietti;
    }

    

    //GETTER E SETTER
    public ArrayList<Biglietto> getBiglietti() {
        return biglietti;
    }
    public void setBiglietti(ArrayList<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public int getSize(){
        return biglietti.size();
    }
    
    
}