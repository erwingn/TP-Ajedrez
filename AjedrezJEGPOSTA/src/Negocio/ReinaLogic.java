package Negocio;

import DataBase.ReinaAdapter;

import java.util.ArrayList;

import Entidades.Peon;
import Entidades.Reina;


public class ReinaLogic 
{
	private DataBase.ReinaAdapter jugadorData;
	
	public ReinaLogic()
	{
		jugadorData=new DataBase.ReinaAdapter();
	}
	
	public ArrayList<Reina> getReina(int id)
	{
		return jugadorData.getReina(id);
	}
	
	public void insertReina(Reina alfi)
	{
		jugadorData.insertReina(alfi);
	}
	public void updateReina(Reina alfi)
	{
		jugadorData.updateReina(alfi);
	}
	
}