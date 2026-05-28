package ar.edu.unlp.objetos.uno.ej07;

import java.util.ArrayList;
import java.util.List;

public class ProductoTres extends ProductoFinanciero {
	List<ProductoFinanciero> lista;
	
	

	public ProductoTres() {
		lista = new ArrayList <ProductoFinanciero>();
		CompraBonoAltoRiesgo bonoAltoRiesgo = new CompraBonoAltoRiesgo(5);
		CompraBonoBajoRiesgo bonoBajoRiesgo = new CompraBonoBajoRiesgo(5);
		PlazoFijo plazoFijo = new PlazoFijo(35, 5); 
		lista.add(bonoAltoRiesgo);
		lista.add(bonoBajoRiesgo);
		lista.add(plazoFijo);
	}



	@Override
	public double retornoInversion(double montoInicial) {
		// TODO Auto-generated method stub
		return this.lista.stream().mapToDouble(producto -> producto.retornoInversion(montoInicial)).sum();
	}

}
