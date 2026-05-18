package ar.edu.unlp.objetos.uno.ej25;

public class Obligatorio extends PlanMedico {

	@Override
	public double montoFijo(Afiliado unAfiliado) {
		return 15000;
	}

	@Override
	public double grupoFamiliar(Afiliado unAfiliado) {
		double total = 3500 * unAfiliado.getFamiliaresACargo();
		total = total - unAfiliado.getFamiliaresACargo() * unAfiliado.getDescuentoCoseguro();
		return total;
		
	}

	@Override
	public double coberturaViajera(Afiliado unAfiliado) {
		double total = unAfiliado.getSalario() * 0.01;
		total = total - unAfiliado.getMontoCoberturaViajes();
		return total;
	}

	@Override
	public double seguroInternacion(Afiliado unAfiliado) {
		return 0;
	}

}
