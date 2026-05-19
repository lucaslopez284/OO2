package ar.edu.unlp.objetos.uno.ej25;

public class Integral extends PlanMedico {

	@Override
	protected double montoFijo(Afiliado unAfiliado) {
		return 22000;
	}

	@Override
	protected double grupoFamiliar(Afiliado unAfiliado) {
		return unAfiliado.getFamiliaresACargo() * 3000 + unAfiliado.getSalario() * 0.01;
	}

	@Override
	protected double coberturaViajera(Afiliado unAfiliado) {
		double total = unAfiliado.getSalario() * 0.3;
		if(unAfiliado.tieneCoseguro()) {
			total= total - 10000 * unAfiliado.getAntiguedadCoseguro();
		}
		return total;
	}

	@Override
	protected double seguroInternacion(Afiliado unAfiliado) {
		return this.montoFijo(unAfiliado) * 0.05; 
	}

}
