<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-lg-9 main-chart">
<div class="bootstrap-iso">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <form:form id="formSearch" action="searchbill" class="form-horizontal" method="post">
                        <div class="form-group " style="text-align: center;">
                            <div class="col-sm-8">
                                <div style="margin-top: 5px; ">
                                    <input type="text" class="form-control" id="contact_name" name="search">
                                </div>
                            </div>
                            <label class="control-label col-sm-4 requiredField" for="date">
                                <a id="search" class="btn btn-success btn-sm pull-left" href="javascript:submitSearch()">Search Task</a>
                            </label>
                        </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<c:if test="${!empty listbooks}">
<c:forEach var="lsBook" items="${listbooks}">
<div class="row mt">
		<div class="col-md-12">
			<div class="content-panel">
				<h4><i class="fa fa-angle-right"></i> <span class="badge bg-info"><c:out value="${lsBook.get(0).nameClient}"></c:out></span></h4>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th>Room</th>
							<th>Date In</th>
							<th>Date Out</th>
							<th>Total Price</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="book" items="${lsBook}">
						<tr>
							<td><c:out value="${book.nameRoom}"></c:out></td>
							<td><c:out value="${book.checkIn}"></c:out></td>
							<td><c:out value="${book.checkOut}"></c:out></td>
							<td><c:out value="${book.priceRoom}"></c:out></td>
							<c:if test="${book.status == 'NO'}">
								<td><span class="badge bg-important">No</span></td>
							</c:if>
							<c:if test="${book.status == 'OK'}">
								<td><span class="badge bg-success"><i class=" fa fa-check"></i></span></td>	
							</c:if>
							<c:if test="${book.status == 'NOT'}">
								<td><span class="badge bg-warning">No</span></td>
							</c:if>	
							<td>
								<a class="badge bg-success" href="payment?id=${book.bookingId}">PAY</a>
							<%--<a class="badge bg-success" href="detailbill?id=${book.bookingId}">DETAIL</a> --%>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- /col-md-12 -->
</div><!-- row -->
</c:forEach>
</c:if>

</div>
<!-- /col-lg-9 END SECTION MIDDLE -->

<!-- RIGHT SIDEBAR CONTENT -->
<%@ include file="../history/history.jsp" %>

<script type="text/javascript">
	function submitSearch() {
		document.getElementById("formSearch").submit();
	}
</script>
