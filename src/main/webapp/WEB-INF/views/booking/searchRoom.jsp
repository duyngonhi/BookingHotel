<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 31/03/2017
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css"/>
<style>
    .bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
    .bootstrap-iso form {
        font-family: Arial, Helvetica, sans-serif;
        color: black
    }

    .bootstrap-iso form button,
    .bootstrap-iso form button:hover {
        color: white !important;
    }

    .asteriskField {
        color: red;
    }
</style>

<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js">
</script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
    $(document).ready(function () {
        var date_input = $('input[name="startDate"]');
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy/mm/dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        })
    });
    $(document).ready(function () {
        var date_input = $('input[name="endDate"]');
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy/mm/dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        })
    });
</script>
<div class="col-lg-9 ">
    <div class="col-md-12">
        <div class="col-md-3 col-sm-6 col-xs-12"></div>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <p id="err_startDate" style="color: red"></p>
            <p id="err_endDate" style="color: red"></p>
            <p style="color: red"><h5>${err_empty}</h5></p>
        </div>
        <div class="col-md-3 col-sm-6 col-xs-12"></div>
    </div>

    <div class="col-md-12">
        <div class="bootstrap-iso">
            <div class="container-fluid">
                <div class="row">
                    <form:form class="form-horizontal" modelAttribute="conditionBookingBeanForm" id="formSearch"
                               action="${pageContext.request.contextPath}/searchRoomCondition" method="POST">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <br/>
                            <div class="form-group ">
                                <label class="control-label col-sm-4 requiredField" for="startDate">
                                    Start Date
                                    <span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-8">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <form:input class="form-control" path="startDate" id="startDate" name="startDate"
                                                    placeholder="yyyy/mm/dd" type="text"
                                                    value="${conditionBookingBeanForm.startDate}"/>
                                    </div>
                                </div>
                                <label class="control-label col-sm-12 requiredField">
                                    <h5>${err_empty}</h5>
                                </label>
                            </div>

                            <div class="form-group ">
                                <label class="control-label col-sm-4 requiredField">
                                    Room size
                                    <span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-8">
                                    <select class="form-control" path="size" name="size">
                                        <c:forEach begin="1" end="5" var="i">
                                            <option value="${i}" <c:if test="${i eq conditionBookingBeanForm.size}">
                                                selected="selected"</c:if>>${i}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-4"></div>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <br/>
                            <div class="form-group ">
                                <label class="control-label col-sm-4 requiredField" for="endDate">
                                    End Date
                                    <span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-8">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <form:input class="form-control" path="endDate" id="endDate" name="endDate"
                                                    placeholder="yyyy/mm/dd" type="text"
                                                    value="${conditionBookingBeanForm.endDate}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4 requiredField">
                                </label>
                                <div class="col-sm-8">
                                    <div class="col-sm-6 col-xs-6 ">
                                        <a class="btn btn-success " style="color: #efeaee" id="btnSearch"> Search </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt">
        <div class="col-md-12">
            <br>
            <c:if test="${!empty listRoomsBean}">
                <c:forEach items="${listRoomsBean}" var="room">
                    <form:form class="form-horizontal style-form" modelAttribute="roomBeanForm" id="formRoom"
                               action="${pageContext.request.contextPath}/booking" method="POST">
                        <input type="hidden" id="id" name="id" path="id" value="${room.id}"/>
                        <input type="hidden" id="start" name="start" path="start" value="${room.start}"/>
                        <input type="hidden" id="end" name="end" path="end" value="${room.end}"/>
                        <div class="col-md-4 col-sm-4 mb">
                            <div class="white-panel pn">
                                <div style="background-color: #039BE5; padding: 3px; margin-bottom: 15px; color: white">
                                    <h5><c:out value="${room.name}"/></h5>
                                </div>
                                <div class="row">
                                    <div class="col-sm-4 col-xs-4 goleft">
                                        <p><i class="fa fa-heart"></i>${room.price}</p>
                                    </div>
                                    <div class="col-sm-1 col-xs-1">
                                    </div>
                                </div>
                                <div class="centered">
                                    <img src="/assets/img/picture_4.jpg" width="120">
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-3 col-xs-3 goleft"></div>
                                    <div class="col-sm-6 col-xs-6">
                                        <a class="btnSubmit btn btn-theme"> Booking </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>

<div class="col-lg-3 ds">
    <h3>NOTIFICATIONS</h3>
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>)al(
        </div>
        <div class="details">
            <p>
                <muted>2 Minutes Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">James Brown</a> subscribed to your newsletter.<br>
            </p>
        </div>
    </div>

    <div id="calendar" class="mb"></div>
</div>

<script type="text/javascript">

    function checkEmpty(str) {
        if (str == "") {
            return true;
        }
        return false;
    }

    function checkEndDate(endDate) {
        if(checkEmpty(endDate)) {
            $("#err_endDate").text("end date is not empty");
            return true;
        }
        return false;
    }
    function checkStartDate(startDate) {
        if(checkEmpty(startDate)) {
            $("#err_startDate").text("start date is not empty");
            return true;
        }
        return false;
    }

        $('.btnSubmit').on("click", function (e) {
            e.preventDefault();
            var startDateVal = $("#startDate").val();
            var endDateVal = $("#endDate").val();
            var check = true;

            if(checkEndDate(endDateVal)) {
                check = false;
            }
            if(checkStartDate(startDateVal)) {
                check = false;
            }
            if (check) {
                $("#formRoom").submit();
            }
        });

    $('#btnSearch').on("click", function (e) {
        e.preventDefault();
        var startDateVal = $("#startDate").val();
        var endDateVal = $("#endDate").val();
        var check = true;
        if(checkStartDate(startDateVal)) {
            check = false;
        }
        if(checkEndDate(endDateVal)) {
            check = false;
        }
        if (check) {
            $("#formSearch").submit();
        }
    });

    $(document).ready(function() {
        $("a[id='btnSearch']").on('click', function(e){
            e.preventDefault();
            var startDateVal = $("#startDate").val();
            var endDateVal = $("#endDate").val();
            $.ajax({url: "/searchRoomCondition",type: "POST",dataType: "json",
                data: {startDateVal: startDateVal.toString(), endDateVal: endDateVal.toString()},
                success: function(data){
                    console.log(data);
                    var html = '';
                }
            });
        })
    });

    function logout() {
        $('#logoutForm').submit();
    };
</script>
