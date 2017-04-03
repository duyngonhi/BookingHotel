<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="margin-bottom-10">Profile</h2>
<c:if test="${!empty errShowProfile}">
	<h3 style="color: red">
		<c:out value="${errShowProfile}" />
	</h3>
</c:if>
<c:if test="${!empty userBean}">
	<div style="""left">
		<div>
			FullName:
			<c:out value="${userBean.fullname}" />
		</div>
		<div>
			UserName:
			<c:out value="${userBean.username}" />
		</div>
		<div>
			PassWord:
			<c:out value="${userBean.password}" />
		</div>
		<div>
			Email:
			<c:out value="${userBean.email}" />
		</div>
		<div>
			Phone:
			<c:out value="${userBean.phone}" />
		</div>
		<div>
			Role:
			<c:out value="${userBean.role}" />
		</div>
		<button class="btn btn-theme">
			<a href="editProfile?id=${userBean.id}">Edit</a>
		</button>
</c:if>
</div>
