import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class view extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{
HashMap HashDept=new HashMap();
PrintWriter out=res.getWriter();

res.setContentType("text/html");
HttpSession session = req.getSession(true);

out.println("<form method = 'get' action = 'Display'>");
out.println("Enter the Pnr Number:<input type='number' name='pnr'>");
out.println("<input type = 'submit' value = 'Book'>");

out.println("Thank You");
}
}
