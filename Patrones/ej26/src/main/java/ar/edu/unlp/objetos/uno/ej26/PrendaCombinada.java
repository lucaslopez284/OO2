package ar.edu.unlp.objetos.uno.ej26;

import java.util.ArrayList;
import java.util.List;

public class PrendaCombinada extends Bien {
	
	private List<Bien> bienes;

	public PrendaCombinada(List<Bien> bienes) {
		super(0.5);
		this.bienes = bienes;
	}
	
	public PrendaCombinada() {
		super(0.5);
		this.bienes = new ArrayList<Bien>();
	}
	
	public void agregarBien(Bien unBien) {
		this.bienes.add(unBien);
	}
	
	public void eliminarBien(Bien unBien) {
		this.bienes.remove(unBien);
	}
	
	public double valor() {
		return this.bienes.stream().mapToDouble(bien -> bien.valor()).sum();
	}

}
