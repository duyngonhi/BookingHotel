<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<div id="login-page">
  	<div class="container">
  	
     <form class="form-login" action="<c:url value='/auth/login_check' />" method="post">
       <h2 class="form-login-heading">sign in now</h2>
       <div class="login-wrap">
           <input type="text" class="form-control" name="username" placeholder="User ID" autofocus>
           <br>
           <input type="password" class="form-control" name ="password" placeholder="Password">
           <label class="checkbox">
               <span class="pull-right">
               	<input name="remember-me" type="checkbox">
               </span>
           </label>
           <button class="btn btn-theme btn-block" type="submit"> SIGN IN</button>
           <hr>
           <div class="registration">Don't have an account yet?<br/>
               <a class="" href="#">Create an account</a>
           </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
   	 </form>	  	
	
	</div>
</div>
