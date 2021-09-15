import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class first extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{
HashMap<Integer,Character> HashDept=new HashMap();
HashMap<Integer,Character>  HashDest=new HashMap();
HashMap<Integer,Integer>  HashNum=new HashMap();
HashMap<Integer,Integer> PNR=new HashMap();
HashMap<Integer,String> Status=new HashMap();
Queue number=new LinkedList();
LinkedList list=new LinkedList();

System.out.println("ello");
for(int i=1;i<=8;i++){
	number.add(i);
	
}
HttpSession session=req.getSession(true);
session.setAttribute("HashDept", HashDept);
session.setAttribute("HashDest", HashDest);
session.setAttribute("HashNum", HashNum);
session.setAttribute("number",number);
session.setAttribute("list",list);
session.setAttribute("PNR",PNR);
session.setAttribute("Status",Status);

PrintWriter out=res.getWriter();
res.setContentType("text/html");/*
out.println("<html><link rel='stylesheet' type='text/css' href="+ req.getContextPath() + "/css/booking.css>");
out.println("<body>");
out.println("<header>");
out.println("<div class='logo'>Train Tickets</div>");     
out.println("<nav>");
        out.println("<ul class='nav'>");
        out.println("<li><a href='first'>Ticket Booking</a></li>");
		out.println("<li><a href='search.html'>Cancel Tickets</a></li>");
		out.println("<li><a href='chart'>Print Occupancy</a></li>");
        out.println("</ul>");
      out.println("</nav></div>");
    out.println("</header>");
out.println(" <div class='center'>");
out.println("<h1>Ticket Booking</h1>");
out.println("<form class='booking' action='book' method='get'>");
out.println("<div class='text_field'>");
out.println("<label for='dept'>Departure Station:</label><br>");
out.println("<select name='dept' id='dept'>");
out.println(" <option value='A'>A</option>");
out.println(" <option value='B'>B</option>");
out.println(" <option value='C'>C</option>");
out.println(" <option value='D'>D</option>");
out.println(" <option value='E'>E</option>   </select><br><br>");

out.println("<label for='dest'>Destination Station:</label><br>");
out.println("<select name='dest' id='dest'>");
out.println(" <option value='A'>A</option>");
out.println(" <option value='B'>B</option>");
out.println(" <option value='C'>C</option>");
out.println(" <option value='D'>D</option>");
out.println(" <option value='E'>E</option>   </select><br><br>");


out.println("<label for='num'>Number of Passengers:</label><br>");
out.println("<select name='num' id='num'>");
out.println(" <option value=1>1</option>");
out.println(" <option value=2>2</option>");
out.println(" <option value=3>3</option>");
out.println(" <option value=4>4</option>");
out.println(" <option value=5>5</option>");
out.println(" <option value=6>6</option>");
out.println(" <option value=7>7</option>");
out.println(" <option value=8>8</option>   </select><br><br>");

out.println("</div>");
out.println(" <input type='submit'  value='Book'> ");

out.println(" <br><br></form></div></body>");
   
     */
     
RequestDispatcher rd=req.getRequestDispatcher("book");
rd.forward(req,res);    
}
}
