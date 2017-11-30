package com.training.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.PlayerDaoImpl;
import com.training.entity.Player;
import com.training.utils.MySqlConnection;

public class FindByIdController {

	
	public void handRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
        Connection con = MySqlConnection.getMySqlConnection();

                 PlayerDaoImpl dao = new PlayerDaoImpl(con);
                 
                 String strJryNumber = request.getParameter("jerseyNumber");
		         long jerseyNumber = Long.parseLong(strJryNumber);
		         Player player =null;
                 try {
					 player = dao.find(jerseyNumber);
				} catch (SQLException e) {
							e.printStackTrace();
				}
                 request.setAttribute("foundPlayer", player);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowPlayer.jsp");
                 dispatcher.forward(request, response);
	}
}
