package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Fisico extends TipoCliente {
	
	public void crearCliente(Cliente cliente, String nombre, TipoCliente tipo, String tel, String dni) {
		super.setearVariablesRepetidas(cliente, nombre, tipo, tel);
		cliente.setDni(dni);
	}
	
	public double descuento(double monto, Empresa empresa) {
		return monto * empresa.descuentoFis;
	}
	

}
