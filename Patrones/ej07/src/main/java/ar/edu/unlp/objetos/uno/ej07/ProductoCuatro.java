package ar.edu.unlp.objetos.uno.ej07;

import java.util.*;

public class ProductoCuatro extends ProductoFinanciero {
	
	List<ProductoFinanciero> lista;
	
	

	public ProductoCuatro() {
		lista = new ArrayList <ProductoFinanciero>();
		CompraBonoAltoRiesgo bonoAltoRiesgo1 = new CompraBonoAltoRiesgo(5);
		CompraBonoAltoRiesgo bonoAltoRiesgo2 = new CompraBonoAltoRiesgo(5);
		CompraBonoAltoRiesgo bonoAltoRiesgo3 = new CompraBonoAltoRiesgo(5);
		lista.add(bonoAltoRiesgo1);
		lista.add(bonoAltoRiesgo2);
		lista.add(bonoAltoRiesgo3);
	}

	@Override
	public double retornoInversion(double montoInicial) {
		// TODO Auto-generated method stub
		return this.lista.stream().mapToDouble(producto -> producto.retornoInversion(montoInicial)).sum();
	}

}
