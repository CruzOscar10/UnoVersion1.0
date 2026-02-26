package UNO;

//Juego.java
import java.util.Scanner;

public class Juego {
 private Mazo mazo;
 private Mano manoJugador;
 private Mano manoComputadora;
 private Carta cartaSuperior;
 private Scanner scanner;

 public Juego() {
     mazo = new Mazo();
     manoJugador = new Mano();
     manoComputadora = new Mano();
     scanner = new Scanner(System.in);

     // Repartir 7 cartas a cada uno
     for (int i = 0; i < 7; i++) {
         manoJugador.agregarCarta(mazo.robarCarta());
         manoComputadora.agregarCarta(mazo.robarCarta());
     }

     // Carta inicial
     cartaSuperior = mazo.robarCarta();
 }

 public void iniciar() {
     System.out.println("=== INICIA EL JUEGO UNO ===");

     while (true) {
         // --- TURNO JUGADOR ---
         System.out.println("\nCarta en mesa: " + cartaSuperior);
         System.out.println("Tus cartas:");
         manoJugador.mostrarMano();

         boolean jugo = false;

         while (!jugo) {
             System.out.println("Elige índice de carta o -1 para robar:");
             
             int opcion;
             if (scanner.hasNextInt()) {
                 opcion = scanner.nextInt();
             } else {
                 System.out.println("Entrada inválida, escribe un número.");
                 scanner.next(); // Limpiar entrada
                 continue;
             }

             if (opcion == -1) {
                 Carta robada = mazo.robarCarta();
                 if (robada != null) {
                     manoJugador.agregarCarta(robada);
                     System.out.println("Robaste: " + robada);
                 } else {
                     System.out.println("El mazo está vacío, no puedes robar.");
                 }
                 jugo = true;
             } else if (opcion >= 0 && opcion < manoJugador.tamaño()) {
                 Carta seleccionada = manoJugador.obtenerCarta(opcion);
                 if (seleccionada.esValida(cartaSuperior)) {
                     cartaSuperior = manoJugador.jugarCarta(opcion);
                     System.out.println("Jugaste: " + cartaSuperior);
                     jugo = true;
                 } else {
                     System.out.println("Carta no válida. Debe coincidir color o número.");
                 }
             } else {
                 System.out.println("Índice inválido.");
             }
         }

         if (manoJugador.tamaño() == 0) {
             System.out.println("🎉 ¡Jugador gana!");
             break;
         }

         // --- TURNO COMPUTADORA ---
         System.out.println("\nTurno de la computadora...");

         boolean computadoraJugo = false;

         // Intenta jugar carta de la mano
         for (int i = 0; i < manoComputadora.tamaño(); i++) {
             Carta carta = manoComputadora.obtenerCarta(i);
             if (carta.esValida(cartaSuperior)) {
                 cartaSuperior = manoComputadora.jugarCarta(i);
                 System.out.println("Computadora jugó: " + cartaSuperior);
                 computadoraJugo = true;
                 break;
             }
         }

         // Si no pudo jugar, roba carta
         if (!computadoraJugo) {
             Carta robada = mazo.robarCarta();
             if (robada != null) {
                 System.out.println("Computadora roba: " + robada);
                 if (robada.esValida(cartaSuperior)) {
                     cartaSuperior = robada;
                     System.out.println("Computadora jugó la carta robada: " + cartaSuperior);
                 } else {
                     manoComputadora.agregarCarta(robada);
                 }
             } else {
                 System.out.println("Mazo vacío. Computadora no puede robar.");
             }
         }

         if (manoComputadora.tamaño() == 0) {
             System.out.println("💻 ¡Computadora gana!");
             break;
         }
     }

     System.out.println("\n=== FIN DEL JUEGO ===");
 }
}