package Capstone.Controller;

import Capstone.Database.CapstoneFall2015DB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;
     
    public Login()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Check for logout
        String logout = request.getParameter("logout");
        if(logout != null)
        {
            HttpSession session = request.getSession(true);
            session.invalidate();    
            response.sendRedirect(response.encodeRedirectURL("/CapstoneFall2015/Default"));            
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        CapstoneFall2015DB db = new CapstoneFall2015DB();    
        Boolean validLogin = db.isValidLogin(username, password);
        
        if(validLogin)
        {
            //Start session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(30*60);
            
            response.sendRedirect(response.encodeRedirectURL("/CapstoneFall2015/Default"));
        }
        else
        {
            response.sendRedirect(response.encodeRedirectURL("/CapstoneFall2015/LoginForm?message=Invalid Login!"));
        }  
	}

}
