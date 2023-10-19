package com.neymar.demorest;

import java.util.*;
import java.sql.*;

public class AlienRepositary {

	
	Connection conn = null;
	
	public AlienRepositary() {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/reki";
			String user = "root";
			String pass = "rekildo3012";
			conn = DriverManager.getConnection(url,user,pass);
			
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public List<Alien> getAliens() throws SQLException{
		
		List<Alien> aliens = new ArrayList<>();

		Statement st = conn.createStatement();
		String query = "select * from alien";
		ResultSet res = st.executeQuery(query);
		
		while(res.next()) {
			Alien a = new Alien();
			a.setId(res.getInt(1));
			a.setName(res.getString(2));
			a.setPoints(res.getInt(3));
			
			aliens.add(a);
		}
		return aliens;
	}
	
	public Alien getAlien(int id) throws SQLException {
	
		Statement st = conn.createStatement();
		String query = "select * from alien id=" + id;
		ResultSet res = st.executeQuery(query);
		Alien a = new Alien();
		if(res.next()) {
			a.setId(res.getInt(1));
			a.setName(res.getString(2));
			a.setPoints(res.getInt(3));
		}
		return a;
	}

	public void create(Alien a1) throws SQLException {

		String query = "insert into alien values(?,?,?)";
		
		PreparedStatement st = conn.prepareStatement(query);
		st.setInt(1, a1.getId());
		st.setString(2,a1.getName());
		st.setInt(3, a1.getPoints());
		
		st.executeUpdate();
		
	}
	
	public void update(Alien a1) throws SQLException {

		String query = "update alien set name=?, points=? where id=?";
		 
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1,a1.getName());
		st.setInt(2, a1.getPoints());
		st.setInt(3, a1.getId());
		
		st.executeUpdate();
		
	}

	public void delete(int id) throws SQLException {
		String query = "delete from alien where id="+id;

		Statement st = conn.createStatement();
		st.execute(query);
		
	}
	
	
}
