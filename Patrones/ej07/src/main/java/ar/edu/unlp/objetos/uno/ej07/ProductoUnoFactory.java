package ar.edu.unlp.objetos.uno.ej07;

public class ProductoUnoFactory implements FactoryProductoCombinado {

	@Override
	public ProductoFinanciero factoryMethod() {
		return new ProductoUno();
	}

}
