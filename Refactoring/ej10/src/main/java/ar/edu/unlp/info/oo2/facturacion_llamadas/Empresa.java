package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	static double descuentoJur = 0.15;
	static double descuentoFis = 0;

	public boolean agregarNumeroTelefono(String str) {
		if (!guia.getLineas().contains(str)) {
			guia.getLineas().add(str);
			return true;
		}
		return false;
	}

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	public Cliente registrarUsuario(String data, String nombre, TipoCliente tipo) {
		Cliente cliente = new Cliente();
		String telefono = this.obtenerNumeroLibre();
		tipo.crearCliente(cliente, nombre, tipo, telefono, data);
		clientes.add(cliente);
		return cliente;
	}

	public Llamada registrarLlamada(Cliente origen, Cliente destino, TipoLlamada tipoLlamada, int duracion) {
		Llamada llamada = new Llamada(tipoLlamada, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double montoTotal = 0;
		for (Llamada llamada : cliente.llamadas) {
			double montoLlamada = llamada.getTipoDeLlamada().calcularMonto(llamada);
			montoLlamada-= cliente.getTipo().descuento(montoLlamada, this);
			montoTotal += montoLlamada;
		}
		return montoTotal;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}
