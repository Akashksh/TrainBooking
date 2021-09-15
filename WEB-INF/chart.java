import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class chart extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{
PrintWriter out=res.getWriter();

res.setContentType("text/html");
HttpSession session = req.getSession(true);
HashMap<Integer,Character> HashDept =(HashMap) session.getAttribute("HashDept");
HashMap<Integer,Character> HashDest =(HashMap) session.getAttribute("HashDest");
HashMap<Integer,Integer> HashNum =(HashMap) session.getAttribute("HashNum");
Queue<Integer> number=(Queue) session.getAttribute("number");
LinkedList<Integer> list=(LinkedList) session.getAttribute("list");
HashMap PNR =(HashMap) session.getAttribute("PNR");
HashMap<Integer,String> Status =(HashMap) session.getAttribute("Status");
ArrayList occ=new ArrayList();

out.println("<html><link rel='stylesheet' type='text/css' href="+ req.getContextPath() + "/css/chart.css>");
out.println("<body>");

out.println("<header>");
out.println("<div class='logo'>Train Tickets</div>");     
out.println("<nav>");
        out.println("<ul class='nav'>");
        out.println("<li><a href='Booking.html'>Ticket Book</a></li>");
		out.println("<li><a href='search.html'>View/Cancel Tickets</a></li>");
		out.println("<li><a href='chart'>Print Occupancy</a></li>");
        out.println("</ul>");
      out.println("</nav></div>");
    out.println("</header>");
	out.println("<h1>Occupancy Chart</h1>");
out.println(" <div class='center'>");
int pnr=0,des=0,dep=10;
		
        out.println("<table>");
		out.println("<tr class='thead'>");
		out.println("<th></th>");
		out.println("<th>A</th>");
		out.println("<th>B</th>");
		out.println("<th>C</th>");
		out.println("<th>D</th>");
		out.println("<th>E</th>");
		out.println("</tr>");
        for(int i=1;i<=8;i++){
		out.println("<tr class='row'>");
         int k=0,z=0,y=0;
         out.print("<td><B>"+i+"</B></td>");
         for(int j=0;j<list.size();j++){
                if(HashDest.containsKey(list.get(j))){
                    pnr=list.get(j);  
                    
                }
                else if(list.get(j)==i){ 
                    dep=(HashDept.get(pnr)-65);  
                    des=HashDest.get(pnr)-65;   
                                        out.print(j+""+k+""+z+""+dep+""+des);
                    for( k=z;k<dep;k++){
                        out.print("<td></td>");
						occ.add(0);
					}
                    for( z=k;z<=des;z++){
                        out.print("<td><B>*</B></td>");
						occ.add(i);
                    }
						
                   
                }
												
         }
                    
        out.println("<br>");
		
    }
	out.println("</tr></table>");
out.println("</div>");

		out.print(occ);
			

System.out.println(occ);
}
}
