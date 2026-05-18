package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class TipoCliente {
	public abstract void crearCliente(Cliente cliente, String nombre, TipoCliente tipo, String tel, String data);
	protected void setearVariablesRepetidas(Cliente cliente, String nombre, TipoCliente tipo, String tel) {
		cliente.setNombre(nombre);
		cliente.setNumeroTelefono(tel);
		cliente.setTipo(tipo);
	}
	
	public abstract double descuento(double monto, Empresa empresa);

}
