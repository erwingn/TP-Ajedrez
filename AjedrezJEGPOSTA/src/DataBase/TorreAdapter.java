package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;


import Entidades.Torre;

public class TorreAdapter extends Conexion {

	public ArrayList<Torre> getTorre(int id) 
	{
		ArrayList<Torre> tor=new ArrayList<Torre>();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from torres where id_partida="+id);

				while(registro.next()) {
				Torre t= new Torre();
				t.setId(Integer.parseInt(registro.getString("id_torre")));
				t.setColumna(Integer.parseInt(registro.getString("posY")));
				t.setFila(Integer.parseInt(registro.getString("posX")));
				t.setColor(registro.getString("color"));
				t.setId_partida(Integer.parseInt(registro.getString("id_partida")));
				if(Integer.parseInt(registro.getString("state"))==1)
				{ 
					t.setState(true);
				}
				else
				{ t.setState(false); }
					
				
				
				tor.add(t);
			
			}
			
	
		} 
		catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	return tor;
	}
	
	public void insertTorre(Torre te) 
	{
		
		try {
			
			String query = "insert into torres(id_torre,color,posX,posY,id_partida,state)" + " values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, te.getId());
		      preparedStmt.setString (2, te.getColor());
		      preparedStmt.setInt (3, te.getFila());
		      preparedStmt.setInt (4, te.getColumna());
		      preparedStmt.setInt (5, te.getId_partida());
		      preparedStmt.setBoolean(6, te.isState());    
		      
		      
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updateTorre(Torre to) 
	{
		
		try {
			
			String query = "update torres set id_torre = ?,color= ?,posX= ?, posY= ?, id_partida=?,state=? where id_alfil="+to.getId();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
			 preparedStmt.setInt (1, to.getId());
		      preparedStmt.setString (2, to.getColor());
		      preparedStmt.setInt (3, to.getFila());
		      preparedStmt.setInt (4, to.getColumna());
		      preparedStmt.setInt (5, to.getId_partida());
		      preparedStmt.setBoolean(6, to.isState());    
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
}


