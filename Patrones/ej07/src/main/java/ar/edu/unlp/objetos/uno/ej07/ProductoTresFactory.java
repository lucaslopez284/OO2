package ar.edu.unlp.objetos.uno.ej07;

public class ProductoTresFactory implements FactoryProductoCombinado {

	@Override
	public ProductoFinanciero factoryMethod() {
		return new ProductoTres();
	}

}
