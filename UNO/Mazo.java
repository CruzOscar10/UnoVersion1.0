package UNO;

//Mazo.java
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
 private ArrayList<Carta> cartas;

 public Mazo() {
     cartas = new ArrayList<>();
     String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};

     for (String color : colores) {
         for (int numero = 0; numero <= 9; numero++) {
             cartas.add(new Carta(color, numero));
             cartas.add(new Carta(color, numero)); // Dos cartas por número
         }
     }

     barajar();
 }

 public void barajar() {
     Collections.shuffle(cartas);
 }

 public Carta robarCarta() {
     if (!cartas.isEmpty()) {
         return cartas.remove(0);
     }
     return null;
 }

 public boolean estaVacio() {
     return cartas.isEmpty();
 }
}