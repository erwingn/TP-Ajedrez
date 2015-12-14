package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Entidades.Reina;

public class ReinaAdapter extends Conexion {
	public ArrayList<Reina> getReina(int id) 
	{
		ArrayList<Reina> reinas=new ArrayList<Reina>();
		try {
			
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery("select * from reinas where id_partida="+id);

				while(registro.next()) {
				Reina r= new Reina();
				r.setId(Integer.parseInt(registro.getString("id_reina")));
				r.setColumna(Integer.parseInt(registro.getString("posY")));
				r.setFila(Integer.parseInt(registro.getString("posX")));
	            r.setColor(registro.getString("color"));
	            r.setId_partida(Integer.parseInt(registro.getString("id_partida")));
	            if(Integer.parseInt(registro.getString("state"))==1)
				{ 
					r.setState(true);
				}
				else
				{ r.setState(false); }
				
				reinas.add(r);
			}
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
	return reinas;
	}
	
	public void insertReina(Reina re) 
	{
		
		try {
			
			String query = "insert into reinas(id_reina,color,posX,posY,id_partida,state)" + " values (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
		      preparedStmt.setInt (1, re.getId());
		      preparedStmt.setString (2, re.getColor());
		      preparedStmt.setInt (3, re.getFila());
		      preparedStmt.setInt (4, re.getColumna());
		      preparedStmt.setInt (5, re.getId_partida());
		      preparedStmt.setBoolean(6, re.isState());    
		      
		      
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
	
	public void updateReina(Reina re) 
	{
		
		try {
			
			String query = "update alfiles set id_reina = ?,color= ?,posX= ?, posY= ?, id_partida=?,state=? where id_alfil="+re.getId();
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			
			 preparedStmt.setInt (1, re.getId());
		      preparedStmt.setString (2, re.getColor());
		      preparedStmt.setInt (3, re.getFila());
		      preparedStmt.setInt (4, re.getColumna());
		      preparedStmt.setInt (5, re.getId_partida());
		      preparedStmt.setBoolean(6, re.isState());    
		      
		      preparedStmt.execute();
			
	
		} catch(SQLException ex)
			{
			System.out.println(ex.toString());
			}
		 
	
	}
}
