package ar.edu.unlp.objetos.uno.ej26;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Alquiler alquiler = new Alquiler(LocalDate.of(2026, 1, 10), LocalDate.of(2026, 11, 10), 100);
		Automovil automovil = new Automovil(2024, 100, 1000);
		PrendaCombinada prendaCombinada = new PrendaCombinada();
		prendaCombinada.agregarBien(alquiler);
		prendaCombinada.agregarBien(automovil);
		System.out.println(prendaCombinada.valor());
	}

}
