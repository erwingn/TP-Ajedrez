package Negocio;

import DataBase.CaballoAdapter;

import java.util.ArrayList;

import Entidades.Alfil;
import Entidades.Caballo;


public class CaballoLogic 
{
private DataBase.CaballoAdapter jugadorData;
	
	public CaballoLogic()
	{
		jugadorData=new DataBase.CaballoAdapter();
	}
	
	
	public ArrayList<Caballo> getCaballo(int id)
	{
		return jugadorData.getCaballo(id);
	}
	public void insertCaballo(Caballo alfi)
	{
		jugadorData.insertCaballo(alfi);
	}
	public void updateCaballo(Caballo alfi)
	{
		jugadorData.updateCaballo(alfi);
	}
	
	
}