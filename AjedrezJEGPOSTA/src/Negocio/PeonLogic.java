package Negocio;

import DataBase.PeonAdapter;

import java.util.ArrayList;

import Entidades.Jugador;
import Entidades.Peon;


public class PeonLogic 
{
private DataBase.PeonAdapter jugadorData;
	
	public PeonLogic()
	{
		jugadorData=new DataBase.PeonAdapter();
	}
	
	
	public ArrayList<Peon> getPeon(int id)
	{
		return jugadorData.getPeon(id);
	}
	

	public void insertPeon(Peon alfi)
	{
		jugadorData.insertPeon(alfi);
	}
	public void updatePeon(Peon alfi)
	{
		jugadorData.updatePeon(alfi);
	}
	
	
}