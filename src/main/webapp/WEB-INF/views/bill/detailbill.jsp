<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
							<td>Refunded</td>
							<td>Remain</td>
						</tr>
						<c:if test="${!empty beanClient.detailBean}">
						<tr>
							<td><c:out value="${beanClient.detailBean.room}"/></td>
							<td><c:out value="${beanClient.detailBean.priceRoom}"/></td>
							<td>
								<table border="1" width="100%" style="border-collapse: collapse">
									<c:if test="${!empty beanClient.detailBean.serviceFollow}">
									<c:forEach var="serviceFollow" items="${beanClient.detailBean.serviceFollow}">
									<tr>
										<td><c:out value="${serviceFollow.nameService}"/></td>
										<td><c:out value="${serviceFollow.price}"/></td>
									</tr>
									</c:forEach>
									</c:if>
								</table>
							</td>
							<td>Total:<c:out value="${beanClient.detailBean.totalRoom}"/></td>
							<td><c:out value="${beanClient.detailBean.refunded}"/></td>
							<td><c:out value="${beanClient.detailBean.remain}"/></td>
						</tr>
						</c:if>
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
					<a class="badge bg-success" id="id_print">Print</a>
				</div>
				<div style="float: right; margin-right: 30px">
					<a class="badge bg-success" href="payment?id=${beanClient.bookingId}">Previous</a>
				</div>
			</div>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->
</c:if>
</div>
<!-- /col-lg-9 END SECTION MIDDLE -->
<script type="text/javascript">
	$("#id_print").click(function(){
		var divContents = $("#divprintbill").html();
        var printWindow = window.open('', '', 'height=400,width=800');
        printWindow.document.write('<html><head><style>.bill_right {text-align: right; padding-right: 20%;}</style>');
        printWindow.document.write('</head><body >');
        printWindow.document.write(divContents);
        printWindow.document.write('</body></html>');
        printWindow.document.close();
        printWindow.print();
	});
</script>
<!-- RIGHT SIDEBAR CONTENT -->
<%@ include file="../history/history.jsp" %>
