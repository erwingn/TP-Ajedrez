package DataBase;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Entidades.*;

public class AlfilAdapter extends Conexion {

	public ArrayList<Alfil> getAlfil(int id) 
	{
		ArrayList<Alfil> alf=new ArrayList<Alfil>();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from alfiles where id_partida="+id);

				while(registro.next()) {
				Alfil alfi = new Alfil();
				alfi.setId(Integer.parseInt(registro.getString("id_alfil")));
				alfi.setColumna(Integer.parseInt(registro.getString("posY")));
				alfi.setFila(Integer.parseInt(registro.getString("posX")));
	            alfi.setColor(registro.getString("color"));
	            alfi.setId_partida(Integer.parseInt(registro.getString("id_partida")));
	            if(Integer.parseInt(registro.getString("state"))==1)
				{ 
					alfi.setState(true);
				}
				else
				{ alfi.setState(false); }
				
				alf.add(alfi);
				}
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	return alf;
	
	}
	
	public void insertAlfil(Alfil alfi) 
	{
		
		try {
			
			String query = "insert into alfiles(id_alfil,color,posX,posY,id_partida,state)" + " values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, alfi.getId());
		      preparedStmt.setString (2, alfi.getColor());
		      preparedStmt.setInt (3, alfi.getFila());
		      preparedStmt.setInt (4, alfi.getColumna());
		      preparedStmt.setInt (5, alfi.getId_partida());
		      preparedStmt.setBoolean(6, alfi.isState());    
		      
		      
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updateAlfil(Alfil alfi) 
	{
		
		try {
			
			String query = "update alfiles set id_alfil = ?,color= ?,posX= ?, posY= ?, id_partida=?,state=? where id_alfil="+alfi.getId();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
			 preparedStmt.setInt (1, alfi.getId());
		      preparedStmt.setString (2, alfi.getColor());
		      preparedStmt.setInt (3, alfi.getFila());
		      preparedStmt.setInt (4, alfi.getColumna());
		      preparedStmt.setInt (5, alfi.getId_partida());
		      preparedStmt.setBoolean(6, alfi.isState());    
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
}
