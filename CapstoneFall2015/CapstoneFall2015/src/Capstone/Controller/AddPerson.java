package Capstone.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capstone.Database.*;

@WebServlet("/Person/Add")
public class AddPerson extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public AddPerson() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Check to see if the post has all the data you expect
		Boolean valid = true;
		/////Get the incoming person - Store them in a person object...
		Person p = new Person();
		//Don't really care about the person ID. If this is null will will just create a new record.
		try
		{
			p.setPersonID(Integer.parseInt(request.getParameter("PersonID")));
		}
		catch(NumberFormatException e)
		{
			System.out.println("Add Person: Couldn't parse PersonID");
		}
		//Server side validation.. If we are missing any data because of sneaky javascript browser hacks, don't let the user think we are a punk.
		if(request.getParameter("FirstName") == null || request.getParameter("FirstName").isEmpty())
		{	
			valid = false;			
		}
		else
		{
			p.setFirstName(request.getParameter("FirstName"));
		}
		if(request.getParameter("LastName") == null || request.getParameter("LastName").isEmpty())
		{
			valid = false;	
		}
		else
		{
			p.setLastName(request.getParameter("LastName"));
		}
		//Gender is currently not required		
		p.setGender(request.getParameter("Gender"));
		if(request.getParameter("State") == null || request.getParameter("State").isEmpty())
		{
			valid = false;	
		}
		else
		{
			p.setState(request.getParameter("State"));
		}
		if(request.getParameter("Zip") == null || request.getParameter("Zip").isEmpty())
		{
			valid = false;	
		}
		else
		{
			p.setZip(request.getParameter("Zip"));
		}
		if(request.getParameter("EmailAddress") == null || request.getParameter("EmailAddress").isEmpty())
		{
			valid = false;	
		}
		else
		{
			p.setEmailAddress(request.getParameter("EmailAddress"));
		}
		if(request.getParameter("PhoneNumber") == null || request.getParameter("PhoneNumber").isEmpty())
		{
			valid = false;	
		}
		else
		{
			try
			{
				p.setPhoneNumber(Long.parseLong(request.getParameter("PhoneNumber")));
			}
			catch(Exception e)
			{
				System.out.println("Add Person: Couldn't parse Phone Number");
			}	
		}
		if(request.getParameter("Birthday") == null || request.getParameter("Birthday").isEmpty())
		{
			valid = false;	
		}
		else
		{
			p.setBirthdayFromString(request.getParameter("Birthday"));
		}		
		
		//If post is not valid send them back to the form
		if(!valid)
		{
			request.setAttribute("Message", "<strong>Good Try! </strong> We need all the required fields filled in for you to move on.");
			request.getRequestDispatcher("/Person").forward(request,response);
		}
		else //save stuff to the database
		{
			//Check if the person has a ID - add if they do.. Update if they don't
			if(p.getPersonID() == null)
			{
				CapstoneFall2015DB db = new CapstoneFall2015DB();
				db.addPerson(p);
			}
			else
			{
				CapstoneFall2015DB db = new CapstoneFall2015DB();
				db.updatePerson(p);
			}
		}		
	}

}
