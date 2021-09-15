import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class Display extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException,NullPointerException{
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
//int pnr=Integer.parseInt(req.getParameter("pnr")  );

int pnr=(Integer) session.getAttribute("pnr");

session.setAttribute("dept",HashDept.get(pnr));
session.setAttribute("dest",HashDest.get(pnr));
session.setAttribute("num",HashNum.get(pnr));
session.setAttribute("sts",Status.get(pnr));

RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
rd.forward(req,res);



}
}
