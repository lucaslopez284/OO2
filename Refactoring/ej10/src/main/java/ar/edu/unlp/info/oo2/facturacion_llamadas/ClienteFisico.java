package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteFisico extends Cliente {
	
	private String dni;

	public ClienteFisico(String dni) {
		super();
		this.dni = dni;
	}

	public String getCuit() {
		return dni;
	}

	public void setCuit(String dni) {
		this.dni = dni;
	}

	@Override
	public void setDni(String data) {
	}

}
