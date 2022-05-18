package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		String sql="SELECT nome "+  
				"FROM parola " +
				"WHERE nome=?";
		boolean corretto;
		try {
		Connection conn= ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, anagramma);
		ResultSet rs= st.executeQuery();
		if(rs.next()) {
			corretto=true;
		}else {
			corretto=false;
		}
		conn.close();
		return corretto;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
