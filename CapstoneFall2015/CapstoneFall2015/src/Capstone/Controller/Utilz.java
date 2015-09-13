package Capstone.Controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletContext;


public class Utilz 
{
    public static String getHtml(String filename,ServletContext context) throws IOException
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
}


