package ar.edu.unlp.objetos.uno.ej08;

public class InProgress implements ToDoItemState {
	
	@Override
	public void start(ToDoItem contexto) {
	}

	@Override
	public void togglePause(ToDoItem contexto) {
		contexto.setState(new Paused());
	}

	@Override
	public void finish(ToDoItem contexto) {
		contexto.setState(new Finish());
		contexto.setFin(LocalDate.now());
	}

}
