<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<header>
<script type="text/javascript">
$(document).ready(function () {
    var date_input = $('input[name="date"]'); //our date input has the name "date"
    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
    date_input.datepicker({
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
    })
});
function submitSearch() {
    document.getElementById("formSearch").submit();
}
</script>
</header>
<body>
<div class="col-lg-9 main-chart">
        <div class="bootstrap-iso">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <form id="formSearch" action="searchbill" class="form-horizontal" method="post">
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
                    </form>
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
							<th>Name Room</th>
							<th>Date In</th>
							<th>Date Out</th>
							<th>Price Room</th>
							<th>Payment Status</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="book" items="${lsBook}">
						<tr>
							<td><c:out value="${book.nameRoom}"></c:out></td>
							<td><c:out value="${book.checkIn}"></c:out></td>
							<td><c:out value="${book.checkOut}"></c:out></td>
							<td><c:out value="${book.priceRoom}"></c:out></td>
							<c:if test="${book.status == false}">
								<td><span class="badge bg-important">No</span></td>
							</c:if>
							<c:if test="${book.status == true}">
								<td><button class="btn btn-success btn-xs"><i class=" fa fa-check"></i></button></td>
							</c:if>
							<td><a class="badge bg-success" href="#">DETAIL</a></td>
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

<div class="col-lg-3 ds">
    <!--COMPLETED ACTIONS DONUTS CHART-->
    <h3>NOTIFICATIONS</h3>
    <!-- 1 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-divya.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">DIVYA MANIAN</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
    <!-- 2 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-sherman.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">DJ SHERMAN</a><br>
                <muted>I am Busy</muted>
            </p>
        </div>
    </div>
    <!-- 3 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-danro.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">DAN ROGERS</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
    <!-- 4 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-zac.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">Zac Sniders</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
    <!-- 5 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-sam.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">Marcel Newman</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>

    <!-- CALENDAR-->
    <div id="calendar" class="mb">
    </div>

</div>
</body>
</html>
