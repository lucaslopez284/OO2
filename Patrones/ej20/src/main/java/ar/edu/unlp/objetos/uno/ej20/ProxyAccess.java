package ar.edu.unlp.objetos.uno.ej20;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProxyAccess implements DatabaseAccess {
	private String password;
	private boolean loggedIn; 
	private DatabaseRealAccess dbRealAccess;
	private static final Logger logger = Logger.getLogger(ProxyAccess.class.getName());
	
	
	
	
	
	
	public ProxyAccess(String password, DatabaseRealAccess database) {
		super();
		this.password = password;
		this.loggedIn = false;
		this.dbRealAccess = database;
	}

	public void logIn(String password) {
		if (this.password.equals(password)) {
			this.loggedIn = true;
		}
	}
	
	public void logOut() {
		this.loggedIn = false;
	}
	
	private boolean isLoggedIn() {
		return this.loggedIn;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.isLoggedIn()) {
			logger.info("Se realizara una busqueda");
			return this.dbRealAccess.getSearchResults(queryString);
		}
		logger.severe("Acceso invalido");
		return new ArrayList<>();
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.isLoggedIn()) {
			logger.warning("Se realizara una insercion");
			return this.dbRealAccess.insertNewRow(rowData);
		}
		logger.severe("Acceso invalido");
		return 0;
	}
	

}
