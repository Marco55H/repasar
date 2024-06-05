package tesoro;

import java.util.Random;

public class Funciones {
	final static int TAMTABLERO = 5;
	static int xTesoro;
	static int yTesoro;
	static int xJugador = 1;
	static int yJugador = 1;

	static void generaPosicionTesoro() {
		Random r = new Random();
		xTesoro = r.nextInt(1, TAMTABLERO + 1);
		yTesoro = r.nextInt(1, TAMTABLERO + 1);
	}

	static void pintaTablero() {
		for (int i = 0; i <= TAMTABLERO; i++) {
			System.out.print(i);

			for (int j = 1; j <= TAMTABLERO; j++) {
				if (i == 0) {
					System.out.print("\t" + j);
				}
				if (xJugador == i && yJugador == j) {
					for (int x = 1; x <= j; x++) {
						System.out.print("\t");
					}
					System.out.print("J");
				}
			}
			System.out.println();
			System.out.println();
		}
	}

	int mueveJugador(String cadena) {
		int devuelve;
		devuelve = 0;

		if (cadena.equalsIgnoreCase("ARRIBA") && xJugador > 1) {
			xJugador--;
		} else if (cadena.equalsIgnoreCase("ABAJO") && xJugador < TAMTABLERO) {
			xJugador++;
		} else if (cadena.equalsIgnoreCase("IZQUIERDA") && yJugador > 1) {
			yJugador--;
		} else if (cadena.equalsIgnoreCase("DERECHA") && yJugador < TAMTABLERO) {
			yJugador++;
		} else {
			devuelve = -1;
		}

		return devuelve;
	}

	boolean buscaTesoro() {
		boolean encontrado = false;

		if (xJugador == xTesoro && yJugador == yTesoro) {
			encontrado = true;
		}

		return encontrado;
	}

}
