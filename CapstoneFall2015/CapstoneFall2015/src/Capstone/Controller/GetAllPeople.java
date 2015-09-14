package Capstone.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Capstone.Database.CapstoneFall2015DB;

@WebServlet("/Person/All")
public class GetAllPeople extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public GetAllPeople() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Make a connection to the database
		CapstoneFall2015DB db = new CapstoneFall2015DB();
		
		//Serialize list to JSON
		Gson gson = new Gson();
		String json = gson.toJson(db.getPeople());
		//set response type
		response.setContentType("application/json");
		//return JSON object
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		
	}

}
