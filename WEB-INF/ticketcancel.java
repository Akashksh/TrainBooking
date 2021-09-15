import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class ticketcancel extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException,NullPointerException{
HashMap HashDept=new HashMap();
PrintWriter out=res.getWriter();
res.setContentType("text/html");

HttpSession session = req.getSession(true);
HashMap<Integer,Character> HashDest =(HashMap) session.getAttribute("HashDest");
HashMap<Integer,Integer> HashNum =(HashMap) session.getAttribute("HashNum");
Queue<Integer> number=(Queue) session.getAttribute("number");
LinkedList<Integer> list=(LinkedList) session.getAttribute("list");
HashMap PNR =(HashMap) session.getAttribute("PNR");
HashMap<Integer,String> Status =(HashMap) session.getAttribute("Status");
String[] str=(req.getParameterValues("tickets"));
int pnr=Integer.parseInt(req.getParameter("pnr"));

int n=list.indexOf(pnr);

for(String s: str){

	int i=Integer.parseInt(s);

	if(!number.contains(list.get(i)))
		number.add(list.get(i));

	int x=list.remove(i);
    list.add(i,x*10);
	//list.add(n+i,0);
}
int count=0;
for(int i=1;i<=HashNum.get(pnr);i++){

	if(list.get(n+i)>8)
		count++;
}

if(count==HashNum.get(pnr))
	Status.put(pnr,"Canceled");
waiting(req,res);

RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
rd.forward(req,res);
}
public void waiting(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException,NullPointerException{
	PrintWriter out=res.getWriter();
res.setContentType("text/html");

HttpSession session = req.getSession(true);
HashMap<Integer,Character> HashDest =(HashMap) session.getAttribute("HashDest");
HashMap<Integer,Character> HashDept =(HashMap) session.getAttribute("HashDept");
HashMap<Integer,Integer> HashNum =(HashMap) session.getAttribute("HashNum");
HashMap<Integer,String> Status =(HashMap) session.getAttribute("Status");
LinkedList<Integer> list=(LinkedList) session.getAttribute("list");
Queue<Integer> number=(Queue) session.getAttribute("number");

 for(Object o:Status.keySet()){

            if(Status.get(o).equals("WaitingForSeat")){

               avail(req,res,HashDept.get(o),HashDest.get(o));

                //Conform(Dept.get(o),Dest.get(o),NumPass.get(o),(int)o);
				int n=list.indexOf(o);
				for(int i=1;i<=HashNum.get(o);i++){
					if(number.size()==0){
							Status.put((int)o,"WaitingForSeat");
					}
					else if(list.get(n+i)==0){
						list.set(n+i,number.remove());
						Status.put((int)o,"Active");
					}
				}
            }
        }


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

         number.removeIf(a->(a>8));
	

}

}
