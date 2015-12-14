package Negocio;

import DataBase.AlfilAdapter;

import java.util.ArrayList;

import Entidades.Alfil;


public class AlfilLogic 
{
private DataBase.AlfilAdapter jugadorData;
	
	public AlfilLogic()
	{
		jugadorData=new DataBase.AlfilAdapter();
	}
	
	
	public ArrayList<Alfil> getAlfil(int id)
	{
		return jugadorData.getAlfil(id);
	}
	
	public void insertAlfil(Alfil alfi)
	{
		jugadorData.insertAlfil(alfi);
	}
	public void updateAlfil(Alfil alfi)
	{
		jugadorData.updateAlfil(alfi);
	}
	
	
}
