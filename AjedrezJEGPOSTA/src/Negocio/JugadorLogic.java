package Negocio;



import DataBase.JugadorAdapter;
import Entidades.Jugador;


public class JugadorLogic 
{
	private DataBase.JugadorAdapter jugadorData;
	
	public JugadorLogic()
	{
		jugadorData=new DataBase.JugadorAdapter();
	}
	
	
	public Jugador getJugador(int dni)
	{
		return jugadorData.getJugador(dni);
	}
	
	
	public void insertJugador(Jugador alfi)
	{
		jugadorData.insertJugador(alfi);
	}
	public void updateJugador(Jugador alfi)
	{
		jugadorData.updateJugador(alfi);
	}
	
	
}
