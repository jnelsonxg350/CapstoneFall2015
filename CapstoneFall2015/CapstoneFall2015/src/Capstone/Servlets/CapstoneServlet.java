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
			html += e.getMessage() + "</div>";
		}
		
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
