package com.training.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.PlayerDaoImpl;
import com.training.entity.Player;
import com.training.utils.MySqlConnection;

public class FindAllController {

	public void handRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
        Connection con = MySqlConnection.getMySqlConnection();

                 PlayerDaoImpl dao = new PlayerDaoImpl(con);
                 
		         List<Player> playerList =null;
                 try {
					 playerList = dao.findAll();
				} catch (SQLException e) {
							e.printStackTrace();
				}
                 request.setAttribute("playerList", playerList);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowAllPlayer.jsp");
                 dispatcher.forward(request, response);
	}

}
