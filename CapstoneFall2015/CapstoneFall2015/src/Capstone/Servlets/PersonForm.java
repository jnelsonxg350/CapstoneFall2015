package Capstone.Servlets;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capstone.Controller.Utilz;
import Capstone.Database.Person;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@WebServlet("/PersonForm")
public class PersonForm extends CapstoneServlet
{
	private static final long serialVersionUID = 1L;
    
    public PersonForm()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(Utilz.isAuthorized(request, response))
		{
			//Build a script to send to the page
			String script  = "";
			
			/////Set the form fields if you have an incoming ID
			if(request.getParameter("id") != null)
			{
				//Call your api
				String json = Utilz.getJSON("/CapstoneFall2015/Person/" + request.getParameter("id"));
				
				//Deserialize your people list
				Type listType = new TypeToken<Person>(){}.getType();
				//Set the date format
				Gson gson =  new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
				Person person = gson.fromJson(json.toString(), listType);
				if(person.getPersonID() != null)
				{
					addDynamicHtml("${PersonID}", person.getPersonID().toString());
				}
				else
				{
					addDynamicHtml("${PersonID}", "");
				}
				if(person.getFirstName() != null)
				{
					addDynamicHtml("${FirstName}",person.getFirstName());
				}
				else
				{
					addDynamicHtml("${FirstName}","");
				}
				if(person.getLastName() != null)
				{
					addDynamicHtml("${LastName}", person.getLastName());	
				}
				else
				{
					addDynamicHtml("${LastName}","");
				}					
				//if there is a gender select it
				if(person.getGender() != null)
				{
					script += "selectGender('" + person.getGender() + "');";
				}			
				//if there is a state select it
				if(person.getState() != null)
				{
					script += "selectState('" + person.getState() + "');";
				}
				if(person.getZip() != null)
				{
					addDynamicHtml("${Zip}", person.getZip());	
				}
				else
				{
					addDynamicHtml("${Zip}","");
				}	
				if(person.getEmailAddress() != null)
				{
					addDynamicHtml("${EmailAddress}", person.getEmailAddress());
				}
				else
				{
					addDynamicHtml("${EmailAddress}","");
				}	
				if(person.getPhoneNumber() != null)
				{
					addDynamicHtml("${PhoneNumber}", person.getPhoneNumber().toString());
				}
				else
				{
					addDynamicHtml("${PhoneNumber}","");
				}
				if(person.getBirthday() != null)
				{
					addDynamicHtml("${Birthday}", person.getBirthdayString());
				}
				else
				{
					addDynamicHtml("${Birthday}","");
				}			
			}
			else
			{
				addDynamicHtml("${PersonID}", "");
				addDynamicHtml("${FirstName}","");
				addDynamicHtml("${LastName}", "");
				addDynamicHtml("${Zip}", "");
				addDynamicHtml("${EmailAddress}", "");
				addDynamicHtml("${PhoneNumber}", "");
				addDynamicHtml("${Birthday}", "");
			}
			
			//Check for and send the error message
			if(request.getAttribute("Message") != null)
			{
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
		else
		{
			response.sendRedirect(response.encodeRedirectURL("/CapstoneFall2015/LoginForm"));
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
