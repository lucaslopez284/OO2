package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private TipoCliente tipo;
	private String nombre;
	private String numeroTelefono;
	
	

	public TipoCliente getTipo() {
		return tipo;
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public abstract void setDni(String data);
	
	public abstract void setCuit(String data);

}
