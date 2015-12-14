package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Entidades.Rey;

public class ReyAdapter extends Conexion {

	public ArrayList<Rey> getRey(int id) 
	{
		ArrayList<Rey> reyes=new ArrayList<Rey>();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from reyes where id_partida="+id);

				while(registro.next()) {
				Rey rey= new Rey();
				rey.setId(Integer.parseInt(registro.getString("id_rey")));
				rey.setColumna(Integer.parseInt(registro.getString("posY")));
				rey.setFila(Integer.parseInt(registro.getString("posX")));
				rey.setColor(registro.getString("color"));
				rey.setId_partida(Integer.parseInt(registro.getString("id_partida")));
				if(Integer.parseInt(registro.getString("state"))==1)
				{ 
					rey.setState(true);
				}
				else
				{ rey.setState(false); }
				
				reyes.add(rey);
				
			}
			
	
		}  
		catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	return reyes;
	}
	
	public void insertRey(Rey rere) 
	{
		
		try {
			
			String query = "insert into reyes(id_rey,color,posX,posY,id_partida,state)" + " values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, rere.getId());
		      preparedStmt.setString (2, rere.getColor());
		      preparedStmt.setInt (3, rere.getFila());
		      preparedStmt.setInt (4, rere.getColumna());
		      preparedStmt.setInt (5, rere.getId_partida());
		      preparedStmt.setBoolean(6, rere.isState());    
		      
		      
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updateRey(Rey rere) 
	{
		
		try {
			
			String query = "update reyes set id_rey = ?,color= ?,posX= ?, posY= ?, id_partida=?,state=? where id_alfil="+rere.getId();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
			 preparedStmt.setInt (1, rere.getId());
		      preparedStmt.setString (2, rere.getColor());
		      preparedStmt.setInt (3, rere.getFila());
		      preparedStmt.setInt (4, rere.getColumna());
		      preparedStmt.setInt (5, rere.getId_partida());
		      preparedStmt.setBoolean(6, rere.isState());    
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
}
