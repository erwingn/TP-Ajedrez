package Entidades;

public abstract class Ficha{

	boolean state;
	int id;
	int id_partida;
	String color;	
	int fila, columna;
	
	public int getId() {
		return id;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ficha() {
		
	}

	public int getId_partida() {
		return id_partida;
	}

	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}


	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public boolean validarMovimiento (int antFila, int antColumna, int proxFila, int proxColumna) {
		return true;
	}
	

}	