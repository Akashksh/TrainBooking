import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class delete extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException,NullPointerException{
HashMap HashDept=new HashMap();
PrintWriter out=res.getWriter();
res.setContentType("text/html");
int arr=10;
HttpSession session = req.getSession(true);

session.setAttribute("pnr",10);
RequestDispatcher rd=getServletContext().getRequestDispatcher("/demo.jsp");
rd.include(req,res);
}


}
