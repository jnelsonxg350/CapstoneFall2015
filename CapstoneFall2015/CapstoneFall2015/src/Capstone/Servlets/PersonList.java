package Capstone.Servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Capstone.Controller.Utilz;
import Capstone.Database.Person;

@WebServlet("/PersonList")
public class PersonList extends CapstoneServlet 
{
	private static final long serialVersionUID = 1L;
      
    public PersonList()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(Utilz.isAuthorized(request, response))
		{
			//Call your api
			String json = Utilz.getJSON("/CapstoneFall2015/Person/All");
			
			///////Deserialize your people list
			//Get the list type for deserializing
			Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
			//Set the date format
			Gson gson =  new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
			//Finally actuall deserialize the damn thing.
			ArrayList<Person> people = gson.fromJson(json.toString(), listType);
					
	    	//Go through your people and build your table
			StringBuilder table = new StringBuilder("<tr><th></th><th></th><th>ID</th><th>First Name</th><th>Last Name</th></tr>");
			Iterator<Person> i = people.iterator();
			while(i.hasNext())
			{
				Person p = i.next();
				table.append("<tr><td><button type='button' class='btn btn-xs btn-primary btnUpdatePerson' data-id='" + p. getPersonID() +"'\">Edit</button></td><td><button type='button'class='btn btn-xs btn-danger btnDeletePerson' data-id='" + p. getPersonID() +"'\">Delete</button></td><td>" + p. getPersonID() + "</td><td>" + p.getFirstName() + "</td><td>" + p.getLastName() + "</td></tr>");
			}
	    	
	    	
	    	//Set the servlet name
	    	setName("PersonList");
	    	//Send the table to the view
	    	addDynamicHtml("${people}", table.toString());
	    	//let the super class do its work
	    	super.doGet(request, response);
		}
		else
		{
			response.sendRedirect(response.encodeRedirectURL("/CapstoneFall2015/LoginForm"));
		}
	}

}
