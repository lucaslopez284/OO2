package ar.edu.unlp.objetos.uno.ej25;

public class Premium extends PlanMedico {

	@Override
	public double montoFijo(Afiliado unAfiliado) {
		return 33000 - unAfiliado.getDescuentoCoseguro();
	}

	@Override
	public double grupoFamiliar(Afiliado unAfiliado) {
		if(unAfiliado.getFamiliaresACargo() > 4) {
			return 2800 * (unAfiliado.getFamiliaresACargo() - 4);
		}
		return 0;
	}

	@Override
	public double coberturaViajera(Afiliado unAfiliado) {
		return 3000 + unAfiliado.getSalario() * 0.01 - unAfiliado.getMontoCoberturaViajes();
	}

	@Override
	public double seguroInternacion(Afiliado unAfiliado) {
		return this.montoFijo(unAfiliado) * 0.05;
	}

}
