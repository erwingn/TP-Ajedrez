package Entidades;

public class Rey extends Ficha{
	
	public Rey(){
		
	}
	
	
	public boolean validarMovimiento (int antFila, int antColumna, int proxFila, int proxColumna) {	

		if (proxFila > 7 || proxFila < 0)
			return false;
		if (proxColumna > 7 || proxColumna < 0)
			return false;		

		int difFil, difCol;

		difFil = this.fila - proxFila;
		difCol = this.columna - proxColumna;
		
		if (Math.abs(difFil) <= 1 && Math.abs(difCol)<= 1) {
			return true;
		}
		else 
			return false;
	}
	
}
