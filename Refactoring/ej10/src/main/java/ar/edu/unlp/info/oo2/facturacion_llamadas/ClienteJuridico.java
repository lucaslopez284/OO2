package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteJuridico extends Cliente {
	
	private String cuit;

	public ClienteJuridico(String cuit) {
		super();
		this.cuit = cuit;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	@Override
	public void setDni(String data) {
		// TODO Auto-generated method stub
		
	}
	
	

}
