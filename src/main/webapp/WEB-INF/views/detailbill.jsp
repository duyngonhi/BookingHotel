<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function printElem(divName) {
		var printContents = document.getElementById(divName).innerHTML;
		var originalContents = document.body.innerHTML;
		document.body.innerHTML = printContents;
		window.print();
		document.body.innerHTML = originalContents;
	}
</script>
<div class="col-lg-9 main-chart">
<c:if test="${!empty beanClient}">
<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <h4> Payment Bill: <span class="badge bg-info">Nguyen Van A</span></h4>
   	  	  <hr>
   	  	  <div style="color: black;" id="divprintbill">
				<div style='text-align: center'>
					<div style='font-family: Arial'>
						<h3>Center - Relax - Ha Noi</h3>
					</div>
					<p>Address: 60 - Pham Hung - Bac Tu Liem - Ha Noi * Phone:0373.821.361</p>
					<br>
					<h3>Payment Of Room Bill</h3>
				</div>
				<div class="bill_right">
					<p>day <c:out value="${beanClient.day}"/> month <c:out value="${beanClient.month}"/> year <c:out value="${beanClient.year}"/> </p>
				</div>
				<div style='clear: both'>
					<div style='float: left; padding-left: 20%'>Customer: <c:out value="${beanClient.customer}"/></div>
					<div style='float: right; padding-right: 20%'>Phone Number: <c:out value="${beanClient.phone}"/></div>
					<div style='clear: both;"'>
						<div style='padding-left: 20%'>Addres: <c:out value="${beanClient.address}"/></div>
					</div>
				</div>
				<br>
				<div style='text-align: center'>
					<table border="1" align="center" width="60%" class="tablebill">
						<tr>
							<td>Room</td>
							<td>Room Price</td>
							<td>Service Follow</td>
							<td>Total Room</td>
						</tr>
						<c:if test="${!empty beanClient.detailBean}" var="detailBean">
						<c:forEach var="detail" items="${detailBean}">
						<tr>
							<td><c:out value="${beanClient.room}"/></td>
							<td></td>
							<td>
								<table border="1" width="100%"
									style="border-collapse: collapse">
									<c:if test="${!empty detail.serviceFollow}">
									<c:forEach var="serviceFollow" items="${detail.serviceFollow}">
									<tr>
										<td><c:out value="${serviceFollow.nameService}"/></td>
										<td><c:out value="${serviceFollow.price}"/></td>
									</tr>
									</c:forEach>
									</c:if>
								</table>
							</td>
							<td></td>
						</tr>
						</c:forEach>
						</c:if>
						<tr>
							<td colspan=3></td>
							<td>Total:<c:out value="${beanClient.total}"/></td>
						</tr>
					</table>
					<br>
				</div>
				<div>
					<p class="bill_right">Person Create</p>
				</div>
				<div class="bill_right"><c:out value="${beanClient.createBy}"/></div>
				<br> <br>
			</div>
			<div class="footerbill">
				<div style="float: right;">
					<a class="badge bg-success" href="javascript:printElem('divprintbill')">Print</a>
				</div>
				<div style="float: right; margin-right: 30px">
					<a class="badge bg-success" href="showbooking">Previous</a>
				</div>
			</div>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->
</c:if>
</div>
<!-- /col-lg-9 END SECTION MIDDLE -->

<!-- RIGHT SIDEBAR CONTENT -->
<%@ include file="history.jsp" %>
