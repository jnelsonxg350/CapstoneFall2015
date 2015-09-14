package Capstone.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capstone.Database.CapstoneFall2015DB;

@WebServlet("/Person/Delete")
public class DeletePerson extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    public DeletePerson() 
    {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = "";
		try 
		{
			//try to get the incoming ID
			id = (String)request.getParameter("id");
			//Make a connection to the database
			CapstoneFall2015DB db = new CapstoneFall2015DB();			
			db.deletePerson(id);
			
		} 
		catch (Exception e) 
		{
			//there was a problem
			System.out.println(e.getMessage());
		}		
	}

}
