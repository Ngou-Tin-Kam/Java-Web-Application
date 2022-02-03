package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JsonReaderDao;
import dao.ReadBetsDao;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JsonReaderDao jsonReaderDao;
	private ReadBetsDao readBetsDao;
	private List listOfBets;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		jsonReaderDao = new JsonReaderDao();
		jsonReaderDao.uploadJson();
		
		readBetsDao = new ReadBetsDao();
		listOfBets = readBetsDao.readBets();
		request.setAttribute("betList", listOfBets);
		
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}
}
