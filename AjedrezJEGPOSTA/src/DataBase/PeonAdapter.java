package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Entidades.Peon;

public class PeonAdapter extends Conexion {

	public ArrayList<Peon> getPeon(int id) 
	{
		ArrayList<Peon> peones=new ArrayList<Peon>();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from peones where id_partida="+id);

				while(registro.next()) 
				{
				Peon p = new Peon();
				p.setId(Integer.parseInt(registro.getString("id_peon")));
				p.setColumna(Integer.parseInt(registro.getString("posY")));
				p.setFila(Integer.parseInt(registro.getString("posX")));
	            p.setColor(registro.getString("color"));
	            p.setId_partida(Integer.parseInt(registro.getString("id_partida")));
	            if(Integer.parseInt(registro.getString("state"))==1)
				{ 
					p.setState(true);
				}
				else
				{ p.setState(false); }
				
				peones.add(p);
				}
			
				
		} 
		
		catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	
		return peones;
	}
	
	public void insertPeon(Peon pe) 
	{
		
		try {
			
			String query = "insert into peones(id_peon,color,posX,posY,id_partida,state)" + " values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, pe.getId());
		      preparedStmt.setString (2, pe.getColor());
		      preparedStmt.setInt (3, pe.getFila());
		      preparedStmt.setInt (4, pe.getColumna());
		      preparedStmt.setInt (5, pe.getId_partida());
		      preparedStmt.setBoolean(6, pe.isState());    
		      
		      
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updatePeon(Peon pe) 
	{
		
		try {
			
			String query = "update peones set id_peon = ?,color= ?,posX= ?, posY= ?, id_partida=?,state=? where id_alfil="+pe.getId();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
			 preparedStmt.setInt (1, pe.getId());
		      preparedStmt.setString (2, pe.getColor());
		      preparedStmt.setInt (3, pe.getFila());
		      preparedStmt.setInt (4, pe.getColumna());
		      preparedStmt.setInt (5, pe.getId_partida());
		      preparedStmt.setBoolean(6, pe.isState());    
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
}

