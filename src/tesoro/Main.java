package tesoro;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String movimiento = "";
		Funciones tesoro = new Funciones();

		Funciones.generaPosicionTesoro();
		System.out.println(Funciones.xTesoro + ":" + Funciones.xTesoro);
		
		System.out.println("Bienvenido al encontrar el tesoro");
		while (!tesoro.buscaTesoro()) {

			Funciones.pintaTablero();

			System.out.println("Escribe ARRIBA, ABAJO, IZQUIERDA o DERECHA para moverte");
			movimiento = sc.next();

			if (tesoro.mueveJugador(movimiento) == 0) {
				System.out.println("Te movistes");
			} else {
				System.out.println("Cuidado!! te vas a salir del tablero");
			}

		}
		System.out.println("Encontraste el tesoro!!!");
	}
}
