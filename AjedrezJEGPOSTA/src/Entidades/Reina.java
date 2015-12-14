package Entidades;

public class Reina extends Ficha{
	
	public Reina(){
		
	}
	
	
	
	public boolean validarMovimiento (int antFila, int antColumna, int proxFila, int proxColumna) {

		if (proxFila > 7 || proxFila < 0)
			return false;
		if (proxColumna > 7 || proxColumna < 0)
			return false;

		Torre t;
		Alfil a;
	
		t = new Torre();
		a = new Alfil();
		
		if (t.validarMovimiento(antFila, antColumna, proxFila, proxColumna) || a.validarMovimiento(antFila, antColumna, proxFila, proxColumna))
			{return true;}
		else{return false;}
	}
	

	


}
