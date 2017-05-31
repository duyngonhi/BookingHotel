<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Edit Profile</h2>
<form:form action="${pageContext.request.contextPath}/updateProfile"
	modelAttribute="profileForm" class="templatemo-login-form" method="post">
	<c:if test="${!empty errUpdateProfile}">
		<p>
		<h3 style="color: red">
			<c:out value="${errUpdateProfile}" />
		</h3>
		</p>
	</c:if>
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Id</label>
		<div class="col-sm-10">
			<input class="form-control" name="id" name="id" type="text" path="id"
				value="${profileForm.id}" readonly>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Full name</label>
		<div class="col-sm-10">
			<p id="errFullname" style="color: red"></p>
			<input class="form-control" name="fullname" type="text"
				path="fullname" value="${profileForm.fullname}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Username</label>
		<div class="col-sm-10">
			<p id="errUsername" style="color: red"></p>
			<input class="form-control" name="username" type="text"
				path="username" value="${profileForm.username}">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<p id="errPassword" style="color: red"></p>
			<input class="form-control" name="password" type="password"
				path="password" value="${profileForm.password}">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<p id="errEmail" style="color: red"></p>
			<input class="form-control" name="email" type="text" path="email"
				value="${profileForm.email}">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Phone</label>
		<div class="col-sm-10">
			<p id="errPhone" style="color: red"></p>
			<input class="form-control" name="phone" type="text" path="phone"
				value="${profileForm.phone}">
		</div>
	</div>

	<div style="text-align: left">
		<button type="submit" class="btn btn-theme" id="btnSubmit">Update</button>
	</div>

</form:form>
