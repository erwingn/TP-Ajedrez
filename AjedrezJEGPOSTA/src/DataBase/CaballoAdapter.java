package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Entidades.Caballo;

public class CaballoAdapter extends Conexion {

	public ArrayList<Caballo> getCaballo(int id) 
	{
		ArrayList<Caballo> horse=new ArrayList<Caballo>();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from caballos where id_partida="+id);
			
				while(registro.next()) {
				Caballo caba = new Caballo();
				caba.setId(Integer.parseInt(registro.getString("id_caballo")));
				caba.setColumna(Integer.parseInt(registro.getString("posY")));
				caba.setFila(Integer.parseInt(registro.getString("posX")));
	            caba.setColor(registro.getString("color"));
	            caba.setId_partida(Integer.parseInt(registro.getString("id_partida")));
	            if(Integer.parseInt(registro.getString("state"))==1)
				{ 
					caba.setState(true);
				}
				else
				{ caba.setState(false); }
				
				horse.add(caba);
				}
				
	
		} 
		catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	
		return horse;
	}
	
	public void insertCaballo(Caballo cabal) 
	{
		
		try {
			
			String query = "insert into caballos(id_caballo,color,posX,posY,id_partida,state)" + " values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, cabal.getId());
		      preparedStmt.setString (2, cabal.getColor());
		      preparedStmt.setInt (3, cabal.getFila());
		      preparedStmt.setInt (4, cabal.getColumna());
		      preparedStmt.setInt (5, cabal.getId_partida());
		      preparedStmt.setBoolean(6, cabal.isState());    
		      
		      
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updateCaballo(Caballo cabal) 
	{
		
		try {
			
			String query = "update caballos set id_alfil = ?,color= ?,posX= ?, posY= ?, id_partida=?,state=? where id_caballo="+cabal.getId();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
			 preparedStmt.setInt (1, cabal.getId());
		      preparedStmt.setString (2, cabal.getColor());
		      preparedStmt.setInt (3, cabal.getFila());
		      preparedStmt.setInt (4, cabal.getColumna());
		      preparedStmt.setInt (5, cabal.getId_partida());
		      preparedStmt.setBoolean(6, cabal.isState());    
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
}
