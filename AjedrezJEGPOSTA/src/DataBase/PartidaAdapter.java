package DataBase;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import com.mysql.jdbc.PreparedStatement;

import Entidades.*;

public class PartidaAdapter extends Conexion {
	
	public Partida getPartida(int id) 
	{
		Partida parti=new Partida();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from partidas where id_partida="+id);
			if(registro.next())
			{
				parti.setId(Integer.parseInt(registro.getString("id_partida")));
				parti.setJ1(Integer.parseInt(registro.getString("jugador1")));
				parti.setJ2(Integer.parseInt(registro.getString("jugador2")));
			}
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	return parti;
	}
	
	public void insertPartida(Partida juga) 
	{
		
		try {
			
			String query = "insert into partidas(id_partida,jugador1,jugador2)" + " values (?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, juga.getId());
		      preparedStmt.setInt (2, juga.getJ1());
		      preparedStmt.setInt (3, juga.getJ2());
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	

}
