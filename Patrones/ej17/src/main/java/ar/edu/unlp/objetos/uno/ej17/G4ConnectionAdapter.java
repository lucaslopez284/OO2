package ar.edu.unlp.objetos.uno.ej17;

public class G4ConnectionAdapter implements Connection {
	private G4Connection g4;

	public G4ConnectionAdapter(G4Connection g4) {
		this.g4 = g4;
	}

	@Override
	public String sendData(String data, int crc) {
		// TODO Auto-generated method stub
		return g4.toString();
	}

	@Override
	public String pict() {
		// TODO Auto-generated method stub
		return g4.symb();
	}

}
