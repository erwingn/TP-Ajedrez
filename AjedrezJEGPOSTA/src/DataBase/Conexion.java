package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	 protected String _usuario="root";
	 protected String _pwd= "erwin";
	 protected static String _bd="dbajedrez1";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 protected Connection conn = null;
	 
	 public Conexion() {
	  
	   try{
	     Class.forName("com.mysql.jdbc.Connection");
	     conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
	     if(conn != null)
	     {
	       System.out.println("Conexi-n a base de datos "+_url+" . . . Ok");
	     }
	   }
	   catch(SQLException ex)
	   {
	      System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url+ex.getMessage());
	   }
	   catch(ClassNotFoundException ex)
	   {
	      System.out.println(ex);
	   }  
	 }
	}
