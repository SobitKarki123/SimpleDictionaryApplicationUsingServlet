/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import utility.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {
    	DbConnection cm;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public DictionaryDAO() {
		try {
                    con = DbConnection.getConnection();
		} catch (Exception e) {
                    e.printStackTrace();
		}
	}
    public List<Entries> SearchWord(String word) {
		try {
                     List<Entries> entriesList;
          
                    String sql = "SELECT * FROM entries.entry where word = '"+word+"'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(sql);
                    if (rs == null){
                        return null;
                    }
                       
                    entriesList = new ArrayList<>();
                    while (rs.next()) {
                        Entries f = new Entries(rs.getString("word").trim(), rs.getString("wordtype").trim(),
                                        rs.getString("definition").trim());
                        entriesList.add(f);

                    }
                    
                    return entriesList;
                    
		} catch (Exception e) {
                    e.printStackTrace();
		}
		return null;
	}
    
}
