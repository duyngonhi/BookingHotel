<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-lg-9 main-chart">
<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
           	<div style="text-align: center;">
				<h4>Center - Relax - Ha Noi</h4>
			</div>
        </div>
    </div>
</div>
<c:if test="${!empty paymentBean}">
<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <h4> Payment For: <span class="badge bg-info"><c:out value="${paymentBean.nameClient}"/></span></h4>
   	  	  <hr>
   	  	  <form:form id="formsubmitpay" action="payment" method="post">
          <table class="table table-striped table-advance table-hover">
              <tbody>
              <tr>
                  <td><strong>Room</strong></td>
                  <td><strong>Total</strong></td>
                  <td><strong>Refunded</strong></td>
                  <td><strong>Remain</strong></td>
                  <td><strong>Input Number</strong></td>
                  <td></td>
              </tr>
              <tr>
                  <td><c:out value="${paymentBean.room}"/></td>
                  <td><c:out value="${paymentBean.total}"/></td>
                  <td><span class="badge bg-success"><c:out value="${paymentBean.refunded}"/></span></td>
                  <td><span class="badge bg-warning"><c:out value="${paymentBean.remain}"/></span></td>
                  <td><input id="inputpay" type="text" name="payrefuned"/><span id="errmsg"></span></td>
				  <td><a id="btnPayment" class="btn btn-success btn-sm pull-left">Submit</a></td>	
              </tr>
              <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td><div style="text-align: right;">
						<a class="badge bg-success" href="showbooking">Previous</a></div>
				  </td>
              </tr>
              </tbody>
          </table>
          <input hidden="true" type="text" name="bookingId" value="${paymentBean.bookingId}"/>
          </form:form>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->

<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <h4> Detail </h4>
          <table class="table table-striped table-advance table-hover">
              <tbody>
              <tr>
                  <td><strong>Service</strong></td>
                  <td><strong>Price</strong></td>
              </tr>
              <c:if test="${!empty paymentBean.paymentDetails}">
              <c:forEach var="detail" items="${paymentBean.paymentDetails}">
					<tr>
	                  <td><c:out value="${detail.nameService}"/></td>
	                  <td><c:out value="${detail.price}"/></td>
	              	</tr>
              </c:forEach>
              </c:if>
              </tbody>
          </table>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->

<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <h4> History Payment </h4>
          <table class="table table-striped table-advance table-hover">
              <tbody>
              <tr>
                  <td><strong>Payment Date</strong></td>
                  <td><strong>Payment Amount</strong></td>
                  <td><strong>Text Note</strong></td>
                  <td><strong>Payment By</strong></td>
              </tr>
              <c:if test="${!empty paymentBean.historyPayment}">
              <c:forEach var="historyPayment" items="${paymentBean.historyPayment}">
					<tr>
	                  <td><c:out value="${historyPayment.datePayment}"/></td>
	                  <td><c:out value="${historyPayment.paymentAmount}"/></td>
	                  <td><c:out value="${historyPayment.note}"/></td>
	                  <td><c:out value="${historyPayment.nameUser}"/></td>
	                  <td><a class="badge bg-success" href="detailbill?id=${paymentBean.bookingId}&bill=${historyPayment.id}">DETAIL</a></td>
	              	</tr>
              </c:forEach>
              </c:if>
              </tbody>
          </table>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->
</c:if>
</div>
<!-- /col-lg-9 END SECTION MIDDLE -->
<script>
	$(document).ready(function () {
	  $("#inputpay").keypress(function (e) {
		if((48 <= e.which && e.which <= 57) || e.which == 8 || e.which == 0 || e.which == 45){
			return true
		}else {
			$("#errmsg").html("Digits Only").show().fadeOut("slow");
	        return false;
		}
	   });
	});
	
	$("#btnPayment").on("click",function(){
		$("#formsubmitpay").submit();
	});
</script>

<!-- RIGHT SIDEBAR CONTENT -->
<%@ include file="../history/history.jsp" %>
