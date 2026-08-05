package ar.edu.unlp.objetos.uno.ej08;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class ToDoItem {
	
	private String nombre;
	private ToDoItemState state;
	private List<String> comentarios;
	private LocalTime inicio;
	private LocalTime fin;

   public ToDoItem(String name) {
        this.nombre = name;
        this.state = new Pending();
        this.comentarios = new ArrayList<String>();
        this.inicio = null;
        this.fin = null;
   }

   public void setInicio(LocalDate inicio) {
	   this.inicio = inicio;
   }

   public void setFin(LocalDate fin) {
	   this.fin = fin;
   }
   
   public void setState(ToDoItemState state) {
	   this.state = state;
   }

	/**
* Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
* pending. Si se encuentra en otro estado, no hace nada.
*/
        public void start() {
        	this.state.start(this);
        }

	/**
* Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress sí * su estado es paused. Caso contrario (pending o finished) genera un error
* informando la causa específica del mismo.
*/
        public void togglePause() {
        	this.state.togglePause(this);
        }


	/**
* Pasa el ToDoItem a finished, siempre y cuando su estado actual sea 
* in-progress o paused. Si se encuentra en otro estado, no hace nada.
*/
        public void finish() {
        	this.state.finish(this);
        }


	/**
* Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
* hasta que se finalizó. En caso de que no esté finalizado, el tiempo que
* haya transcurrido hasta el momento actual. Si el ToDoItem no se inició,
* genera un error informando la causa específica del mismo.
*/
        public Duration workedTime() {
        	if ((inicio != null) && (fin != null)){
        		return Duration.between(inicio, fin);
        	}
        	return null;
   
        }


/**
* Agrega un comentario al ToDoItem siempre y cuando no haya finalizado. Caso
* contrario no hace nada."
*/
        public void addComment(String comment) {
        	this.comentarios.add(comment);
        	
        }
}

