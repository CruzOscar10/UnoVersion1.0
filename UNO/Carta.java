package UNO;

public class Carta {
 private String color;
 private int numero;

 public Carta(String color, int numero) {
     this.color = color;
     this.numero = numero;
 }

 public String getColor() {
     return color;
 }

 public int getNumero() {
     return numero;
 }

 // Una carta es válida si coincide color o número
 public boolean esValida(Carta cartaSuperior) {
     return this.color.equals(cartaSuperior.getColor()) ||
            this.numero == cartaSuperior.getNumero();
 }

 @Override
 public String toString() {
     return "[" + color + "|" + numero + "]";
 }
}