package ar.edu.unlp.objetos.uno.ej07;

import java.util.ArrayList;
import java.util.List;

public class ProductoTresFactory implements FactoryProductoCombinado {

	@Override
	public ProductoFinanciero factoryMethod() {
		return new ProductoTres();
	}

}
