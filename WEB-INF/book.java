import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class book extends HttpServlet{


public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException,NullPointerException{

res.setContentType("text/html");
PrintWriter out=res.getWriter();

char dept=(req.getParameter("dept")).charAt(0);
char dest=(req.getParameter("dest")).charAt(0);
int Num=Integer.parseInt(req.getParameter("num"));
Random ran=new Random();
int pnr=ran.nextInt(10000);


HttpSession session = req.getSession(true);
HashMap<Integer,Character> HashDept =(HashMap) session.getAttribute("HashDept");
HashMap<Integer,Character> HashDest =(HashMap) session.getAttribute("HashDest");
HashMap<Integer,Integer> HashNum =(HashMap) session.getAttribute("HashNum");
Queue<Integer> number=(Queue) session.getAttribute("number");
LinkedList<Integer> list=(LinkedList) session.getAttribute("list");
HashMap PNR =(HashMap) session.getAttribute("PNR");
HashMap<Integer,String> Status =(HashMap) session.getAttribute("Status");
//session.setAttribute("pnr",pnr);
avail(req,res,dept,dest);

PNR.put(pnr,pnr);
HashDept.put(pnr,dept);
HashDest.put(pnr,dest);
HashNum.put(pnr,Num);
Status.put(pnr,"Active");


  int des = 0,id=0;
            if(HashDest.size()!=1){
            for(Object o:HashDest.keySet()){
				if(Status.get(o)=="Active"||Status.get(o)=="WaitingForSeat"){
                if(HashDest.get(o)<=HashDept.get(pnr)){
                    des=(int)o;

                     id+=HashNum.get(des)+1;
                }
                else if(HashDept.get(o)<HashDept.get(pnr)){
                      des=(int)o;

                     id+=HashNum.get(des)+1;
                }}
            }   }

            list.add(id,pnr);
            for(int i=0;i<Num;i++,id++){

                if(number.peek()==null){
                    list.add(id+1,0);
                    Status.put(pnr,"WaitingForSeat");


                }
				else{
                int n=number.peek();
                list.add(id+1,n);

                number.remove();}
		}




System.out.println(list);
session.setAttribute("dept",HashDept.get(pnr));
session.setAttribute("dest",HashDest.get(pnr));
session.setAttribute("num",HashNum.get(pnr));
session.setAttribute("sts",Status.get(pnr));
//session.removeAttribute("sts");
//req.getSession().setAttribute("pnr",pnr);
//req.getRequestDispatcher("display.jsp").forward(req, res);
res.sendRedirect("display.jsp?pnr="+pnr);

}
public void avail(HttpServletRequest req,HttpServletResponse res,char From,char To)throws IOException,ServletException{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession session = req.getSession(true);
	HashMap<Integer,Character> HashDept =(HashMap) session.getAttribute("HashDept");
	HashMap<Integer,Character> HashDest =(HashMap) session.getAttribute("HashDest");
	HashMap<Integer,Integer> HashNum =(HashMap) session.getAttribute("HashNum");
	Queue<Integer> number=(Queue) session.getAttribute("number");
	LinkedList<Integer> list=(LinkedList) session.getAttribute("list");

	int n;
	System.out.println(number);
        for(Object o:HashDest.keySet()){
            if(HashDest.get(o)<=From||HashDept.get(o)>=To){
                //seats+=HashNum.get(o);
                n=list.indexOf(o);
                for(int i=1;i<=HashNum.get(o);i++){
                    if((!number.contains(list.get(n+i))) && (list.get(n+i)!=0))
                        number.add(list.get(n+i));
                }
            }
			else{
				n=list.indexOf(o);
                for(int i=1;i<=HashNum.get(o);i++){
                    if((number.contains(list.get(n+i))) && (list.get(n+i)!=0))
                        number.remove(list.get(n+i));
                }
			}
        }
System.out.println(number);
         for(Object o:HashDest.keySet()){
                if(HashDest.get(o)<=To&&HashDept.get(o)>=From)
                {
                    n=list.indexOf(o);
                    for(int i=1;i<=HashNum.get(o);i++){
                     //seats-=list.get(n+1);
                     number.remove(list.get(n+i));
                }
            }
         }
System.out.println(number);
         number.removeIf(a->(a>8));


}

}
