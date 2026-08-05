package ar.edu.unlp.objetos.uno.ej08;

public class Pending implements ToDoItemState {
	

	public Pending() {
		super();
	}


	@Override
	public void start(ToDoItem contexto) {
		contexto.setState(new InProgress());
		contexto.setInicio(LocalDate.now());
	}

	@Override
	public void togglePause(ToDoItem contexto) {
		throw new RuntimeException("No se puede pausar algo pendiente");	
	}

	@Override
	public void finish(ToDoItem contexto) {
	}

	

}
