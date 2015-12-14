package Entidades;


public class Alfil extends Ficha {
	
	public Alfil(){
		
	}
	
	public boolean validarMovimiento (int antFila, int antColumna, int proxFila, int proxColumna) {
			
			if (proxFila > 7 || proxFila < 0)
				return false;
			if (proxColumna > 7 || proxColumna < 0)
				return false;
	
			int difFil, difCol;
		
			difFil = Math.abs(this.fila - proxFila);
			difCol = Math.abs(this.columna - proxColumna);
			
			if ( (difFil == difCol) ) {
				return true;
			}
			else 
				return false;
			
			
		}
}