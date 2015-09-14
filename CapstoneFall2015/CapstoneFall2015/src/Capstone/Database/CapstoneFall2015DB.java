package Capstone.Database;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class CapstoneFall2015DB
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    MysqlDataSource dataSource = null; 
  
    public CapstoneFall2015DB()
    {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("CapstoneFall2015");
    }
    public void addPerson(Person p)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into Person (FirstName,LastName,Gender,State,Zip,EmailAddress,PhoneNumber,Birthday) " +
            "values(?,?,?,?,?,?,?,?);");
            
            if(p.getFirstName() != null)
            {
            	pst.setString(1, p.getFirstName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(p.getLastName() != null)
            {
            	pst.setString(2, p.getLastName());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(p.getGender() != null)
            {
            	pst.setString(3, p.getGender());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(p.getState() != null)
            {
            	pst.setString(4, p.getState());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(p.getZip() != null)
            {
            	pst.setString(5, p.getZip());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(p.getEmailAddress() != null)
            {
            	pst.setString(6, p.getEmailAddress());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(p.getPhoneNumber() != null)
            {
            	pst.setLong(7, p.getPhoneNumber());
            }
            else
            {
            	pst.setNull(7, Types.NULL);
            }
            
            if(p.getBirthdayString() != null)
            {
            	pst.setString(8, p.getBirthdayString());
            }
            else
            {
            	pst.setNull(8, Types.NULL);
            }            
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public void updatePerson(Person p)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update person set FirstName = ?,LastName = ?,Gender = ?,State = ?,Zip = ?,EmailAddress = ?,PhoneNumber = ?,Birthday = ? " +
            "where PersonID = ?;");
                        
            if(p.getFirstName() != null)
            {
            	pst.setString(1, p.getFirstName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(p.getLastName() != null)
            {
            	pst.setString(2, p.getLastName());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(p.getGender() != null)
            {
            	pst.setString(3, p.getGender());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(p.getState() != null)
            {
            	pst.setString(4, p.getState());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(p.getZip() != null)
            {
            	pst.setString(5, p.getZip());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(p.getEmailAddress() != null)
            {
            	pst.setString(6, p.getEmailAddress());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(p.getPhoneNumber() != null)
            {
            	pst.setLong(7, p.getPhoneNumber());
            }
            else
            {
            	pst.setNull(7, Types.NULL);
            }
            
            if(p.getBirthdayString() != null)
            {
            	pst.setString(8, p.getBirthdayString());
            }
            else
            {
            	pst.setNull(8, Types.NULL);
            }
            
            if(p.getPersonID() != null)
            {
            	pst.setInt(9, p.getPersonID());
            }
            else
            {
            	pst.setNull(9, Types.NULL);
            }
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public ArrayList<Person> getPeople()
    {
        ArrayList<Person> people = new ArrayList<Person>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from person;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                Person p = new Person();
                
                p.setPersonID(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("firstname"));
                p.setLastName(rs.getString("lastname"));
                p.setState(rs.getString("state"));
                p.setZip(rs.getString("zip"));
                p.setBirthday(rs.getDate("birthday"));
                p.setGender(rs.getString("gender"));
                p.setPhoneNumber(rs.getLong("phonenumber"));
                p.setEmailAddress(rs.getString("emailaddress"));
                
                people.add(p);
                
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return people;
    }
    public Person getPerson(String id)
    {
        Person p = new Person();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from person where PersonID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                p.setPersonID(Integer.parseInt(id));
                p.setFirstName(rs.getString("firstname"));
                p.setLastName(rs.getString("lastname"));
                p.setState(rs.getString("state"));
                p.setZip(rs.getString("zip"));
                p.setBirthday(rs.getDate("birthday"));
                p.setGender(rs.getString("gender"));
                p.setPhoneNumber(rs.getLong("phonenumber"));
                p.setEmailAddress(rs.getString("emailaddress"));
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return p;
    }
    public void deletePerson(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from person where personID = '" + id + "';");  
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
    }
    public Boolean isValidLogin(String username,String password)
    {
        Boolean valid = false;
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select count(*) as count from users where username = '" + username + "' and password = PASSWORD('" + password + "');");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                //If we found a valid login
                if(rs.getInt("count") == 1)
                {
                    valid = true;
                }
            }         
            
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return valid;
    }
}


