package Capstone.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Default")
public class Default extends CapstoneServlet 
{
	private static final long serialVersionUID = 1L;

    public Default() 
    {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
    	//Set the servlet name
    	setName("Default");
    	//Set the dynamic page html
    	addDynamicHtml("${myMessage}", "This is my dynamic message");
    	//let the super class do its work
    	super.doGet(request, response);
	}

}
