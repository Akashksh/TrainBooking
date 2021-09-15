<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Print Occupancy</title>
	 
	 
  </head>
  <link type="text/css" rel="stylesheet" href="css/chart.css" />
  <body>
     <%
			HashMap<Integer,Character> HashDept=(HashMap)session.getAttribute("HashDept"); 
			HashMap<Integer,Character> HashDest=(HashMap)session.getAttribute("HashDest");
			LinkedList<Integer> list=(LinkedList) session.getAttribute("list");
				int pnr=0,dep=0,des=0,i=0,j=0,k=0,z=0;
		%>
  <header>
      <div class="logo">Train Tickets</div>
      <nav>
        <ul class="nav">
          <li><a href="Booking.html">Ticket Book</a></li>
          <li><a href="search.html">View/Cancel Tickets</a></li>
          <li><a href="chart">Print Occupany</a></li>
        </ul>
      </nav>
    </header>
		<%=list%>
		<div class="center">

		<table>
		<tr class="thead">
		<th></th>
		<th>A</th>
		<th>B</th>
		<th>C</th>
		<th>D</th>
		<th>E</th>
		</tr>
	
		<%  for(i=1;i<=8;i++) { %>
			<tr class="row">
			<td><%=i%></td>
		<% z=0;
		   k=0;
		for(j=0;j<list.size();j++){
                if(HashDest.containsKey(list.get(j))){
                    pnr=list.get(j);  
                    
                }
                else if(list.get(j)==i){ 
				
                    dep=((int)HashDept.get(pnr)-65);  
                    des=(int)HashDest.get(pnr)-65;   
                    
                    for( k=z;k<dep;k++) {%>
                        <td></td>
                   
                    <% } for( z=k;z<=des;z++){ 	%>
                        <td>*</td>
                    <%}
                   
                }
         }}%>
		 </tr></table>
		</div>

</body>
</html>