package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Nacional implements TipoLlamada {

	@Override
	public double calcularMonto(Llamada llamada) {
		return llamada.getDuracion() * 3 + (llamada.getDuracion() * 3 * 0.21);
	}

}
