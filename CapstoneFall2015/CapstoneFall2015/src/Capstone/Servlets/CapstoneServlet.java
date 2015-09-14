package Capstone.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capstone.Controller.Utilz;

public class CapstoneServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private String name;
    private Map<String,String> dynamicHtml;
    
    public CapstoneServlet() 
    {
        super();
        name = "";
        dynamicHtml = new HashMap<String,String>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String html = "";
		
		try
		{
			//Get the html for the page
			html = Utilz.getHtml(getName() + ".html",getServletContext());		
			//Set the dynamic html
			Iterator<Entry<String, String>> i = dynamicHtml.entrySet().iterator();
			while(i.hasNext())
			{
				Map.Entry<String, String> value = i.next();
				html = html.replace(value.getKey() , value.getValue());
			}
		}
		catch(Exception e)
		{
			html = "<div class='alert alert-danger' role='alert'><strong>There was a problem finding your HTML file!</strong><br/>";
			html += e.getMessage() + "<br/>" + e.getStackTrace() + "</div>";
		}
		
		//get the login bar and menu - these will be different if the user is logged in.
		String loginBar = "<ul class='nav navbar-nav navbar-right'>";
		String menu = "";
		if(Utilz.isAuthorized(request, response))
		{
			loginBar += "<li><a href='/CapstoneFall2015/Login?logout=true'>Logout</a></li>";
			 menu = "<li class='dropdown'>" +
			        "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Users <span class='caret'></span></a>" +
			        "<ul class='dropdown-menu'>" +
			          "<li><a href='/CapstoneFall2015/PersonForm'>Add Person</a></li>" +    
			          "<li><a href='/CapstoneFall2015/PersonList'>View People</a></li>" +
			        "</ul>" +
			      "</li>" +
			      "<li><a href='#contact'>Single Link</a></li>";
		}
		else
		{
			loginBar += "<li><a href='/CapstoneFall2015/LoginForm'>Login</a></li>";
		}
		loginBar += "</ul>";
		request.setAttribute("loginbar", loginBar);
		request.setAttribute("menu", menu);
		
		//Set the body of the page
		request.setAttribute("content", html);
		//Page the content to the master page
		request.getRequestDispatcher("/views/masterpage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
	protected String getName()
	{
		return this.name;
	}
	protected void setName(String name)
	{
		this.name = name;
	}
	protected void addDynamicHtml(String key,String value)
	{
		dynamicHtml.put(key, value);
	}

}
