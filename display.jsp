<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Booking</title>
    <link type="text/css" rel="stylesheet" href="css/view.css" />
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
	window.onload=function(){
		swal("Successful!", "Ticket Booked", "success");
	}
</script>
  </head>
  <body>
  <header>
      <div class="logo">Train Tickets</div>
      <nav>
        <ul class="nav">
          <li><a href="Booking.html">Ticket Book</a></li>
          <li><a href="search.html">View/Cancel Tickets</a></li>
          <li><a href="PrintChart.jsp">Print Occupany</a></li>
        </ul>
      </nav>
    </header>
    <div class="center">
<%-- int pnr=(Integer) session.getAttribute("pnr"); --%>
<% int pnr=Integer.parseInt(request.getParameter("pnr")); %>
   <%
		
				LinkedList<Integer> list=(LinkedList) session.getAttribute("list");
				int n=list.indexOf(pnr);
				String dept=session.getAttribute("dept").toString();
				String dest=session.getAttribute("dest").toString();
				int num=Integer.parseInt(session.getAttribute("num").toString());
				String sts=session.getAttribute("sts").toString();
		%>
		
		
<form action="ticketcancel" method="get">
			<table>
			<tr class="thead">
			<th>PNR</th>
			<th>Departure</th>
			<th>Destination</th>
			<th>Num of Pass</th>
			<th>Status</th>
		</tr>
		<tr>
		<%=pnr%>
		<td><input type="text" value='<%=pnr%>' name='pnr'></td>
		<td><%=dept%></td>
		<td><%=dest%></td>
		<td><%=num%></td>
		<% if(sts.equals("Active")){%>
			<td><p class="active">Active</p></td>
		<%}else if(sts.equals("Canceled")) {%>
			<td><p class="canceled">Canceled</p></td>
		<%}else{%>
			<td><p class="waiting">waitingList</p></td>
		<%}%>
		</table>
		<br><br><table class="select">
		<tr class='thead'>
			<th>Seats Number</th>
			<th>Status</th>
		</tr>
			
		  <%for(int i=1;i<=(int)num;i++){%>
			<tr class="row">
	
			 <%if(list.get(n+i)==0){%>
				<td>WL</td><td class="wait">WaitingList</td>
             <%}else if(list.get(n+i)<=8){%>
			 <td><%=list.get(n+i)%></td><td class="conf">Conformed</td>
			 <%}else{%>
				<td><%=(list.get(n+i)/10)%></td><td class="cancel">Canceled</td>
			 <%}%>
			</tr>
		  <%}%>
		  
		</table>
		</form>
    </div>

</body>
</html>