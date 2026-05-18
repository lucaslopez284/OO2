package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Juridico extends TipoCliente {
	
	public void crearCliente(Cliente cliente, String nombre, TipoCliente tipo, String tel, String cuit) {
		super.setearVariablesRepetidas(cliente, nombre, tipo, tel);
		cliente.setCuit(cuit);
	}
	
	public double descuento(double monto, Empresa empresa) {
		return monto * empresa.descuentoJur;
	}

}
