package Negocio;



import java.util.ArrayList;

import DataBase.TorreAdapter;
import Entidades.Rey;
import Entidades.Torre;


public class TorreLogic 
{
	private DataBase.TorreAdapter jugadorData;
	
	public TorreLogic()
	{
		jugadorData=new DataBase.TorreAdapter();
	}
	
	
	public ArrayList<Torre> getTorre(int id)
	{
		return jugadorData.getTorre(id);
	}
	public void insertTorre(Torre alfi)
	{
		jugadorData.insertTorre(alfi);
	}
	public void updateTorre(Torre alfi)
	{
		jugadorData.updateTorre(alfi);
	}
}
	