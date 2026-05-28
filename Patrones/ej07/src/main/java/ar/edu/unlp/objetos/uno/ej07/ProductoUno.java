package ar.edu.unlp.objetos.uno.ej07;

import java.util.ArrayList;
import java.util.List;

public class ProductoUno extends ProductoFinanciero {
	
	List<ProductoFinanciero> lista;
	
	

	public ProductoUno() {
		lista = new ArrayList <ProductoFinanciero>();
		CompraDolares compraDolares = new CompraDolares(1000); 
		PlazoFijo plazoFijo = new PlazoFijo(35, 5); 
		CompraPesos compraPesos = new CompraPesos (950);
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
