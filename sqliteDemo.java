package net.codejava;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class sqliteDemo {
	public static void  main(String[] args) {
		String jdbcUrl="jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3380500\\mydb.db";
		try {
		Connection connection=DriverManager.getConnection(jdbcUrl);
		String sql="SELECT * FROM movies";
		
		Statement statement=connection.createStatement();
		
		ResultSet result=statement.executeQuery(sql);
		
		while(result.next()) {
			String M_name=result.getString("M_name");
			String Actor=result.getString("Actor");
			String Actress=result.getString("Actress");
			String Director=result.getString("Director");
			String year=result.getString("year");
			
			System.out.println(M_name + "|" + Actor + "|" + Actress +"|" + Director + "|" + year );
		}
		
		
		}catch(SQLException e) {
			System.out.println("Error connecting to sqlite databases");
			e.printStackTrace();
			
		}
	}

}
