package Capstone.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capstone.Database.CapstoneFall2015DB;

@WebServlet("/Person/All")
public class PersonList extends CapstoneServlet 
{
	private static final long serialVersionUID = 1L;
      
    public PersonList()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Set the servlet name
    	setName("PersonList");
    	
    	//build the list of people
    	CapstoneFall2015DB db = new CapstoneFall2015DB();
		db.addPerson(p);
    	
    	//let the super class do its work
    	super.doGet(request, response);
	}

}
