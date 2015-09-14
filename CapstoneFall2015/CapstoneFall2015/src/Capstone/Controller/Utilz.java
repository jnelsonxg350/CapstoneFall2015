package Capstone.Controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Utilz 
{
    public static String getHtml(String filename,ServletContext context) throws Exception
    {        
        filename = new File(context.getRealPath("/views/" + filename)).getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        try 
        {            
            String line = br.readLine();

            while (line != null) 
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } 
        finally
        {
            br.close();
        }
        return sb.toString();
    }
    public static String getJSON(String url)
    {
    	StringBuilder json = new StringBuilder();
    	
    	try    	
    	{
    		//Call your api
    		URL callUrl = new URL("http://localhost:8080" + url);
    		HttpURLConnection conn = (HttpURLConnection)callUrl.openConnection();
    		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String inputLine;		
    		while ((inputLine = in.readLine()) != null)
    		{
    			json.append(inputLine);
    		}
    		in.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		
		return json.toString();
    }
    public static boolean isAuthorized(HttpServletRequest request,HttpServletResponse response)
    {
        boolean isAuthorized = false;
        
        //Start session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("user");
        if(username != null)           
        {
            isAuthorized = true;
        }
        
        return isAuthorized;
    }
}


