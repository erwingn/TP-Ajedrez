package DataBase;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



import com.mysql.jdbc.PreparedStatement;

import Entidades.Jugador;;

public class JugadorAdapter extends Conexion
{
	
	
	public Jugador getJugador(int dni) 
	{
		Jugador juga=new Jugador();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from jugadores where dni="+dni);
			if(registro.next())
			{
			juga.setApellido(registro.getString("apellido"));
			juga.setNombre(registro.getString("nombre"));
			juga.setDni(Integer.parseInt(registro.getString("dni")));
			}
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString()+"asodasopdapodia");
			}
		 
	return juga; 
	
	}
	

	public void insertJugador(Jugador juga) 
	{
		
		try {
			
			String query = "insert into jugadores(dni,nombre,apellido)" + " values (?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, juga.getDni());
		      preparedStmt.setString (2, juga.getNombre());
		      preparedStmt.setString (3, juga.getApellido());
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updateJugador(Jugador juga) 
	{
		
		try {
			
			String query = "update jugadores set dni = ?,nombre= ?,apellido= ? where dni="+juga.getDni();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, juga.getDni());
		      preparedStmt.setString (2, juga.getNombre());
		      preparedStmt.setString (3, juga.getApellido());
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}

	

}
	
	

	
	
	

	
	
	
	
	
	
