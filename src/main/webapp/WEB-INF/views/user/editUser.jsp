<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Edit User</h2>
<form:form action="${pageContext.request.contextPath}/admin_updateUser"
	modelAttribute="userForm" class="templatemo-login-form" method="post">
	<c:if test="${!empty errUpdateUser}">
					<p>
					<h3 style="color: red">
						<c:out value="${errUpdateUser}" />
					</h3>
					</p>
				</c:if>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Id</label>
					<div class="col-sm-10">
						<input class="form-control" name="id" name="id" type="text"
							path="id" value="${userForm.id}" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Full name</label>
					<div class="col-sm-10">
						<p id="errFullname" style="color: red"></p>
						<input class="form-control" name="fullname" type="text"
							path="fullname" value="${userForm.fullname}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Username</label>
					<div class="col-sm-10">
						<p id="errUsername" style="color: red"></p>
						<input class="form-control" name="username" type="text"
							path="username" value="${userForm.username}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<p id="errPassword" style="color: red"></p>
						<input class="form-control" name="password" type="password"
							path="password" value="${userForm.password}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<p id="errEmail" style="color: red"></p>
						<input class="form-control" name="email" type="text" path="email"
							value="${userForm.email}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Phone</label>
					<div class="col-sm-10">
						<p id="errPhone" style="color: red"></p>
						<input class="form-control" name="phone" type="text" path="phone"
							value="${userForm.phone}">
					</div>
				</div>

				<div class="input-group input-sm">
					<label for="role">Role </label>
					<p>Role current is</p>
					<div class="col-sm-10">
						<input class="form-control" name="id" name="id" type="text"
							path="id" value="${userForm.role}" readonly> choice role
						update if you want
					</div>
					<select name="role" class="form-control" id="role">
						<option value="user" selected="selected">USER</option>
						<option value="admin">ADMIN</option>
					</select>
				</div>
				<div style="text-align: left">
					<button type="submit" class="btn btn-theme" id="btnSubmit">Update</button>
				</div>
</form:form>
