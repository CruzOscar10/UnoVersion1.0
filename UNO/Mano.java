package UNO;

//Mano.java
import java.util.ArrayList;

public class Mano {
 private ArrayList<Carta> cartas;

 public Mano() {
     cartas = new ArrayList<>();
 }

 public void agregarCarta(Carta carta) {
     cartas.add(carta);
 }

 public Carta jugarCarta(int indice) {
     if (indice >= 0 && indice < cartas.size()) {
         return cartas.remove(indice);
     }
     return null;
 }

 public int tamaño() {
     return cartas.size();
 }

 public Carta obtenerCarta(int indice) {
     return cartas.get(indice);
 }

 public void mostrarMano() {
     for (int i = 0; i < cartas.size(); i++) {
         System.out.println(i + ": " + cartas.get(i));
     }
 }
}