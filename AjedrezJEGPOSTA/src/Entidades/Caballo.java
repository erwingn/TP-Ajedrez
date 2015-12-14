package Entidades;



public class Caballo extends Ficha{
	
	public Caballo(){
		
	}
	
	
	public boolean validarMovimiento(int filaAnt, int colAnt, int filaN, int colN)
	{
		boolean ban = false;
		if(filaAnt!=filaN && colAnt!=colN) { if(Math.abs(filaAnt-filaN)==2 && Math.abs(colAnt-colN)==1) {ban=true;} }
		if(filaAnt!=filaN && colAnt!=colN) { if(Math.abs(filaAnt-filaN)==1 && Math.abs(colAnt-colN)==2) {ban=true;} }
		return ban;
	}
	
	
}