package ar.edu.unlp.objetos.uno.ej25;

public class CoseguroNull implements CoseguroInterfaz {

	@Override
	public double getDescuento() {
		return 0;
	}

	@Override
	public int getAntiguedad() {
		return 0;
	}

	@Override
	public double getMontoCoberturaViajes() {
		return 0;
	}

}
