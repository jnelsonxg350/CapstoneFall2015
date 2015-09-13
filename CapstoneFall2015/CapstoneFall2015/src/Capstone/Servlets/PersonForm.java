package Capstone.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Person")
public class PersonForm extends CapstoneServlet
{
	private static final long serialVersionUID = 1L;
    
    public PersonForm()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Build a script to send to the page
		String script  = "";
		
		/////Set the form fields
		if(request.getParameter("PersonID") != null)
		{
			addDynamicHtml("${PersonID}", request.getParameter("PersonID"));
		}
		else
		{
			addDynamicHtml("${PersonID}", "");
		}
		
		if(request.getParameter("FirstName") != null)
		{
			addDynamicHtml("${FirstName}", request.getParameter("FirstName"));
		}
		else
		{
			addDynamicHtml("${FirstName}","");
		}
		
		if(request.getParameter("LastName") != null)
		{
			addDynamicHtml("${LastName}", request.getParameter("LastName"));
		}
		else
		{
			addDynamicHtml("${LastName}", "");
		}
		
		if(request.getParameter("Gender") != null)
		{
			script += "selectGender('" + request.getParameter("Gender") + "');";
		}	
		
		if(request.getParameter("State") != null)
		{
			script += "selectState('" + request.getParameter("State") + "');";
		}
		
		if(request.getParameter("Zip") != null)
		{
			addDynamicHtml("${Zip}", request.getParameter("Zip"));
		}
		else
		{
			addDynamicHtml("${Zip}", "");
		}
		
		if(request.getParameter("EmailAddress") != null)
		{
			addDynamicHtml("${EmailAddress}", request.getParameter("EmailAddress"));
		}
		else
		{
			addDynamicHtml("${EmailAddress}", "");
		}
		
		if(request.getParameter("PhoneNumber") != null)
		{
			addDynamicHtml("${PhoneNumber}", request.getParameter("PhoneNumber"));
		}
		else
		{
			addDynamicHtml("${PhoneNumber}", "");
		}
		
		if(request.getParameter("Birthday") != null)
		{
			addDynamicHtml("${Birthday}", request.getParameter("Birthday"));
		}
		else
		{
			addDynamicHtml("${Birthday}", "");
		}
		
		//Check for and send the error message
		if(request.getAttribute("Message") != null)
		{
			System.out.println("here");
			addDynamicHtml("${Message}", "<div class='form-group'> " +
                    		"<div class='alert alert-danger col-lg-offset-4 col-lg-6' role='alert'>" +	
                    		request.getAttribute("Message") +
                    	    "</div>");
		}
		else
		{
			addDynamicHtml("${Message}", "");
		}	
		//send the script
		addDynamicHtml("${Script}", script);
		
		//Set the servlet name
    	setName("PersonForm");
    	//let the super class do its work
    	super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
