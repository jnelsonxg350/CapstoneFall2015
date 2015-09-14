package Capstone.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capstone.Database.CapstoneFall2015DB;

import com.google.gson.Gson;

@WebServlet("/Person/*")
public class GetPerson extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public GetPerson()
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = "";
		try 
		{
			//try to get the incoming ID
			id = request.getPathInfo().split("/")[1];
			
			//Make a connection to the database
			CapstoneFall2015DB db = new CapstoneFall2015DB();
			
			//Serialize list to JSON
			Gson gson = new Gson();
			String json = gson.toJson(db.getPerson(id));
			//set response type
			response.setContentType("application/json");
			//return JSON object
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} 
		catch (Exception e) 
		{
			//there was a problem
			System.out.println(e.getMessage());
			PrintWriter out = response.getWriter();
			out.print(e.getMessage());
			out.flush();
		}
		
	}

}
