package Negocio;



import java.util.ArrayList;

import DataBase.ReyAdapter;
import Entidades.Reina;
import Entidades.Rey;


public class ReyLogic 
{
	private DataBase.ReyAdapter jugadorData;
	
	public ReyLogic()
	{
		jugadorData=new DataBase.ReyAdapter();
	}
	
	
	public ArrayList<Rey> getRey(int id)
	{
		return jugadorData.getRey(id);
	}
	
	public void insertRey(Rey alfi)
	{
		jugadorData.insertRey(alfi);
	}
	public void updateRey(Rey alfi)
	{
		jugadorData.updateRey(alfi);
	}
}
