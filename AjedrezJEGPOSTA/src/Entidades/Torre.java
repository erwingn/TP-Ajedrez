package Entidades;

public class Torre extends Ficha {
	
	public Torre(){
		
	}
	
	public boolean validarMovimiento (int antFila, int antColumna, int proxFila, int proxColumna) {

		if (proxFila > 7 || proxFila < 0)
			return false;
		if (proxColumna > 7 || proxColumna < 0)
			return false;
		

		if ((this.fila == proxFila) || (this.columna == proxColumna)) {
			return true;
		}
		else 
			return false;
	}
	

}
