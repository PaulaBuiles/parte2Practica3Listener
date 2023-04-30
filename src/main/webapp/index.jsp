
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Paula
  Date: 8/03/2023
  Time: 11:28 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
  <title>Registration Form</title>
  <style>
    /* Style the form container */
    .form-container {
      border: 1px solid #ccc;
      padding: 20px;
      width: 400px;
      margin: auto;
    }

    /* Style the form labels */
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    /* Style the form inputs */
    input[type=text], input[type=email], input[type=password] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    /* Style the form button */
    button[type=submit] {
      background-color: #4CAF50;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      float: right;
    }

    /* Clear floats after the form */
    .clearfix::after {
      content: "";
      clear: both;
      display: table;
    }
  </style>
</head>
  <body>

  <%--<ul class="alert alert-danger">
    <%
      for(String error:errores.values()){
    %>
    <li> <%=error%></li>
    <%}%>
  </ul>--%>


<div class="form-container">
  <h1>Registration Form</h1>
  <form  method="post" action="${pageContext.request.contextPath}/register-client" method="POST" class="needs-validation" >
    <%
      Map<String,String> errores = (Map<String, String>) request.getSession().getAttribute("errores");
    %>
    <div >
      <div >
        <label for="firstName" >Nombres</label>
        <input name="name" type="text" id="firstName" placeholder="name">
        <%
          if(errores != null && errores.containsKey("name")) {
            errores.get("name");
        %>
        <div class="alert alert-danger" >Nombre valido requerido</div>
        <%}%>
      </div>
      <div class="col-12">
        <label for="username" class="form-label">Usuario</label>
          <input name="username" type="text" class="form-control" id="username" placeholder="Usuario">
        </div>
        <%
          if(errores != null && errores.containsKey("username")) {
        %>
        <div class="alert alert-danger">Nombre de usuario valido requerido</div>
        <%}%>
      </div>
      <div class="col-12">
        <label  class="form-label">Contraseña</label>
        <input name="password" type="password" class="form-control"  placeholder="password">
        <%
          if(errores != null && errores.containsKey("password")) {
        %>
        <div class="alert alert-danger">Contraseña válida requerida</div>
        <%}%>
      </div>
    <div class="col-12">
      <label  class="form-label">Confirmar contraseña</label>
      <input name="confirm_password" type="password" class="form-control" id="email" placeholder="confirm password">
      <%
        if(errores != null && errores.containsKey("confirm_password")) {
      %>
      <div class="alert alert-danger">Debe ser igual a la contraseña</div>
      <%}%>
    </div>
    <div class="col-12">
      <label  class="form-label">Email</label>
      <input name="email" type="email" class="form-control" id="email" placeholder="email">
      <%
        if(errores != null && errores.containsKey("email")) {
      %>
      <div class="alert alert-danger">Debe ingresar un email valido</div>
      <%}%>
    </div>
      <div class="col-12">
        <label for="address" class="form-label">Dirección</label>
        <input name="address" type="text" class="form-control" id="address" placeholder="ej: km 10. via tebaida-armenia" >
        <%
          if(errores != null && errores.containsKey("address")) {
        %>
        <div class="alert alert-danger">Dirección válida requerida</div>
        <%}%>
      </div>

    <div class="clearfix">
      <button type="submit">Register</button>
    </div>
  </form>
  <h2>Clients list</h2>
  <p>Lista completa de todos los usuarios registrados </p>
  <form action="${pageContext.request.contextPath}/register-client" method="get">
    <div class="clearfix">
      <button value="list" type="submit">Ver lista</button>
    </div>
  </form>
  <form action="${pageContext.request.contextPath}/editar.jsp">
    <h2>Editar Base de Datos</h2>
    <div class="clearfix">
    <button value="list" type="submit">Ir a editar</button></div>
    <%--<input type="submit" value="Ir a editar">--%>
  </form>
</div>

</body>
</html>

