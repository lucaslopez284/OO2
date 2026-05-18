package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Internacional implements TipoLlamada {

	@Override
	public double calcularMonto(Llamada llamada) {
		return llamada.getDuracion() * 150 + (llamada.getDuracion() * 150 * 0.21) + 50;
	}

}
