package com.training.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.PlayerDaoImpl;
import com.training.entity.Player;
import com.training.utils.MySqlConnection;

/**
 * Servlet implementation class AddPlayerServlet
 */
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con =null;
	
    public AddPlayerServlet() {
        super();
    
                  con = MySqlConnection.getMySqlConnection();
                   
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
        try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		         String playerName = request.getParameter("playerName");
		         
		         String strJryNumber = request.getParameter("jerseyNumber");
		         long jerseyNumber = Long.parseLong(strJryNumber);
		         
		         
		         String strMatches = request.getParameter("matchPlayed");
		         int matchesPlayed = Integer.parseInt(strMatches);
		         
		         
		         String strWickets = request.getParameter("wicketTaken");
		         int wicketTaken = Integer.parseInt(strWickets);
		         
		         String strRunScored = request.getParameter("runScored");
		         int runsscored = Integer.parseInt(strRunScored);
		         
		         String strRating = request.getParameter("rating");
		         int rating = Integer.parseInt(strRating);
		         
		         
		         Player player = new Player(jerseyNumber,playerName,matchesPlayed,wicketTaken,runsscored,rating);
		         
		         System.out.println(player);
		         
		         PlayerDaoImpl dao = new PlayerDaoImpl(con);
		         try {
					int rowAdded = dao.add(player);
					
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println(rowAdded + " Row Added");
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
		         
		         
		         
	}

}
