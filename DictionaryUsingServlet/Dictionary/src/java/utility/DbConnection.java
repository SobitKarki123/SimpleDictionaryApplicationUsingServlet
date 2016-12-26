/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
public class DbConnection {
    
    public static Connection getConnection() throws Exception{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
                     
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/entries", "root", "root");
                   
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return con;
	}
	public void closeConnection(Connection con)  throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
}




