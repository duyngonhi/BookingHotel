<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--header start-->
<header class="header black-bg">
<div class="sidebar-toggle-box">
    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
</div>
<!--logo start-->
<a href="#" class="logo"><b>PROJECT1</b></a>
<!--logo end-->
<div class="nav notify-row" id="top_menu">
    <!--  notification start -->
    <ul class="nav top-menu">
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <i class="fa fa-tasks"></i>
                <span class="badge bg-theme">4</span>
            </a>
        </li>
        <li id="header_inbox_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <i class="fa fa-envelope-o"></i>
                <span class="badge bg-theme">5</span>
            </a>
        </li>
    </ul>
    <!--  notification end -->
</div>
<div class="top-menu">
	<!--  notification start -->
    <ul class="nav pull-right top-menu">
        <li><a class="logout" href="javascript:formSubmit()">Logout</a></li>
        <form id="logoutForm" action="<c:url value="/j_spring_security_logout"/>" method="post" >
			<input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
		</form>
	</ul>
	<ul class="nav pull-right top-menu">
		<c:if test="${empty pageContext.request.userPrincipal.name}">
	        <li><a class="logout" href="login">Login</a></li>
		</c:if>
	</ul>
    <!--  notification end -->
</div>
</header>
<!--header end-->
<script>
	function formSubmit(){
		document.getElementById("logoutForm").submit();
	}
</script>