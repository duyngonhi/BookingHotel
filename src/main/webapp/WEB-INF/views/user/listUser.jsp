<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>List User</h3>
<div class="row">
	<div class="col-md-12">
		<div class="content-panel">
			<hr>
			<p>
				<c:if test="${!empty listUsersIsEmpty}">
					<h3 style="color: red">
						<c:out value="${listUsersIsEmpty}" />
					</h3>
				</c:if>
				<c:if test="${!empty errDeleteUser}">
					<h3 style="color: red">
						<c:out value="${errDeleteUser}" />
					</h3>
				</c:if>
				<c:if test="${!empty errEditUser}">
					<h3 style="color: red">
						<c:out value="${errEditUser}" />
					</h3>
				</c:if>
				<c:if test="${!empty listUser}">
					<table class="table">
						<thead>
							<tr>
								<th>STT</th>
								<th>Full name</th>
								<th>UserName</th>
								<th>Password</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Role</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listUser}" var="user">
								<tr>
									<td><a href=""><c:out value="${user.id}" /></a></td>
									<td><c:out value="${user.fullname}" /></td>
									<td><c:out value="${user.username}" /></td>
									<td><c:out value="${user.password}" /></td>
									<td><c:out value="${user.email}" /></td>
									<td><c:out value="${user.phone}" /></td>
									<td><c:out value="${user.role}" /></td>
									<td>
										<button class="btn btn-theme">
											<a href="admin_editUser?id=${user.id}">Edit</a>
										</button>
										<button class="btn btn-theme">
											<a href="admin_deleteUser?id=${user.id}">Delete</a>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			<div class="btn">
				<a href="${pageContext.request.contextPath}/admin_newUser">Create
					User</a>
			</div>
		</div>
	</div>
</div>
