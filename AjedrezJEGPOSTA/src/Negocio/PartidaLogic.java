package Negocio;

import DataBase.PartidaAdapter;




import Entidades.Partida;


public class PartidaLogic 
{
private DataBase.PartidaAdapter jugadorData;
	
	public PartidaLogic()
	{
		jugadorData=new DataBase.PartidaAdapter();
	}
	
	
	public Partida getPartida(int id)
	{
		return jugadorData.getPartida(id);
	}
	
	public void insertPartida(Partida alfi)
	{
		jugadorData.insertPartida(alfi);
	}
	
	

	
}