package com.training.daos;

import com.training.ifaces.GenericDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.*;

public class PlayerDaoImpl implements GenericDAO<Player> {

	private Connection con;
	
	
	public PlayerDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Player t) throws SQLException {
	
		String sql = "insert into USTPlayer values(?,?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, t.getJerseyNumber());
		pstmt.setString(2, t.getPlayerName());
		pstmt.setInt(3, t.getMatchesPlayed());
		pstmt.setInt(4, t.getRunsScored());
		pstmt.setInt(5, t.getWicketTaken());
		pstmt.setInt(6, t.getRating());
		
		int rowAdded = pstmt.executeUpdate();
		
		return rowAdded;
	}

	private Player rowMapper(ResultSet rs) throws SQLException
	{
		long jerseyNumber = rs.getLong("jerseyNumber");
		String playerName = rs.getString("playerName");
		 int matchesPlayed= rs.getInt("matchesPlayed");
				 int wicketTaken=rs.getInt("wicketTaken");
						 int runsScored= rs.getInt("runsScored");
						 int rating = rs.getInt("rating");
		Player player = new Player(jerseyNumber, playerName, matchesPlayed, wicketTaken, runsScored, rating);
	  return player;
	}
	
	@Override
	public Player find(long key)  throws SQLException{
	
		Player player =null;
		String sql = "select * from USTPlayer where jerseyNumber=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, key);
		
		ResultSet rs = pstmt.executeQuery();
		
		 if(rs.next())
		 {
			 player= rowMapper(rs);
		 }
		return player;
	}

	@Override
	public List<Player> findAll() throws SQLException{
		
     String sql = "select * from USTPlayer ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Player> playerList = new ArrayList<Player>();
		  while(rs.next())
		  {
			   Player player = rowMapper(rs);
			   playerList.add(player);
		  }
		
		return playerList;
	}

	@Override
	public int remove(long key) throws SQLException{
	
		String sql = "delete from USTPlayer where jerseyNumber=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, key);

		 int rowDeleted = pstmt.executeUpdate();
		 
		return rowDeleted;
	}

}
