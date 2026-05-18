package ar.edu.unlp.objetos.uno.ej25;

import java.time.LocalDate;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Afiliado pedro = new Afiliado("Pedro", 2, 100000, LocalDate.of(2006, 4, 15), new ArrayList<PlanMedico>(), new Obligatorio());
		System.out.println(pedro.calcularMonto());
		System.out.println(pedro.getPlan().montoFijo(pedro));
	}

}
