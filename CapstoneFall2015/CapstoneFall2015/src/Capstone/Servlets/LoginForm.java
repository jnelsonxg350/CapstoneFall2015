package Capstone.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginForm")
public class LoginForm extends CapstoneServlet 
{
	private static final long serialVersionUID = 1L;
    
    public LoginForm()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Check for and send the error message
		if(request.getParameter("message") != null)
		{
			addDynamicHtml("${Message}", "<div class='form-group'> " +
                    		"<div class='alert alert-danger col-lg-offset-4 col-lg-6' role='alert'>" +	
                    		request.getParameter("message") +
                    	    "</div>");
		}
		else
		{
			addDynamicHtml("${Message}", "");
		}
		
		//Set the servlet name
    	setName("LoginForm");
    	//let the super class do its work
    	super.doGet(request, response);
	}

}
