package ar.edu.unlp.objetos.uno.ej07;

public class ProductoDosFactory implements FactoryProductoCombinado {
	
	@Override
	public ProductoFinanciero factoryMethod() {
		return new ProductoDos();
	}

}
