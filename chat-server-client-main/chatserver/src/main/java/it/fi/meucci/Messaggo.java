package it.fi.meucci;
import java.util.ArrayList;

public class Messaggo {
    ArrayList<Biglietto> lista_biglietti = new ArrayList<>();
    
    public Messaggo(ArrayList<Biglietto> lista_biglietti) {
        this.lista_biglietti = lista_biglietti;
    }

    public Messaggo (){}

    public ArrayList<Biglietto> getLista_biglietti() {
        return lista_biglietti;
    }

    public void setLista_biglietti(ArrayList<Biglietto> lista_biglietti) {
        this.lista_biglietti = lista_biglietti;
    }

    public int getId(int i){
        return lista_biglietti.get(i).id;
    }
    
    public String getPosto(int i){
        return lista_biglietti.get(i).getPosto();
    }
}

