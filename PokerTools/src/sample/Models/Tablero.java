package sample.Models;
import java.util.ArrayList;
public class Tablero {
    ArrayList<Carta> Cartas ;
    public Tablero(ArrayList<Carta> cartas) {
        Cartas = cartas;
    }
   public Tablero()
    {
        Cartas = new ArrayList<>();
    }
}