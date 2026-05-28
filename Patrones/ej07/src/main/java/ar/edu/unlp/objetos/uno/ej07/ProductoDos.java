package ar.edu.unlp.objetos.uno.ej07;

import java.util.ArrayList;
import java.util.List;

public class ProductoDos extends ProductoFinanciero {
	
	List<ProductoFinanciero> lista;
	
	

	public ProductoDos() {
		lista = new ArrayList <ProductoFinanciero>();
		CompraBonoBajoRiesgo bonoBajoRiesgo = new CompraBonoBajoRiesgo(5);
		CompraDolares compraDolares = new CompraDolares(1000);
		PlazoFijo plazoFijo = new PlazoFijo(35, 5); 
		CompraPesos compraPesos = new CompraPesos (950);
		lista.add(bonoBajoRiesgo);
		lista.add(compraDolares);
		lista.add(plazoFijo);
		lista.add(compraPesos);
	}

	@Override
	public double retornoInversion(double montoInicial) {
		// TODO Auto-generated method stub
		return this.lista.stream().mapToDouble(producto -> producto.retornoInversion(montoInicial)).sum();
	}

}
