<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


  
  
  <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
    width: 60%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>

<jsp:include page="Header.jsp"></jsp:include>

<body>

<h3>Enter Details</h3>

<div class="container">
  <form action="./StorageOwnerServlet">
  
  <label style="color: red; font-style:italic; text-align: center; ">
                	<% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></label>      
           
  
    <label for="fname">Storage</label> <br/>
    <input type="text" id="fname" name="storage" placeholder="enter momery in gb for storage.."><br/>

    <label for="lname">Payment</label><br/>
    <input type="text" id="lname" name="payment" placeholder="enter price.."><br/>

    <!--<label for="country">Country</label>
    <select id="country" name="country">
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select>

    -->
    <label for="subject">Duration</label><br/>
    
    <input type="text" id="name" name="duration" placeholder="enter duration.."><br/>
    
    <!--<textarea id="subject" name="duration" placeholder="Write something.." style="height:200px"></textarea>

    -->
    
    
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <!--
    
    
    
    <form action="./">
    <table>
    
    <tr><td>Storage</td><td><input type="text" name="storage"  placeholder="enter memory(GB) storage" required/></td></tr>
    
     <tr><td>Price</td><td><input type="text" name="price" placeholder="enter price"  required/></td></tr>
    
     <tr><td>Duration</td><td><input type="text" name="duration" placeholder="enter duration" required/></td></tr>
    
     
     <input type="submit" value="Submit" />
    
    </table>
    
    </form>
    
    
    
  -->
  
  
