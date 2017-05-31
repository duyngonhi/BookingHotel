<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 31/03/2017
  Time: 13:02
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
<script type="text/css">
    .container {
        width: 80%;
        margin: 20px auto;
    }

    .p {
        text-align: center;
        font-size: 14px;
        padding-top: 140px;
    }
</script>
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
<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
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
                               action="${pageContext.request.contextPath}/staticticalResult" method="POST">
                        <label class="control-label col-sm-12 requiredField">
                            <h5>${err_empty}</h5>
                        </label>
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
                                        <a class="btn btn-success " style="color: #efeaee" id="btnStatictical"> Statictical </a>
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
            <div class="container">
                <h2>Chart.js Responsive Bar Chart Demo</h2>
                <div>
                    <canvas id="canvas"></canvas>
                </div>
            </div>

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

    $('#btnStatictical').on("click", function (e) {
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
            $("#err_startDate").text("");
            $("#err_endDate").text("");
        }
    });

    function logout() {
        $('#logoutForm').submit();
    };

    $(document).ready(function () {
        $("a[id='btnStatictical']").on('click', function () {
            var startDateVal = $("#startDate").val();
            var endDateVal = $("#endDate").val();
            $.ajax({
                url: "/staticticalResult", type: "GET", dataType: "json",
                data: {startDateVal: startDateVal.toString(), endDateVal: endDateVal.toString()},
                success: function (data) {
                    var labels = [];
                    var listTotalPrice = [];
                    $.each(data, function (key, value) {
                        labels[key] = value.name;
                        listTotalPrice[key] = value.totalPrice;
                    });
                    console.log(labels);
                    console.log(listTotalPrice);

                    var barChartData = {
                        labels: labels,
                        datasets: [{
                            fillColor: "rgba(0,60,100,1)",
                            strokeColor: "black",
                            data: listTotalPrice
                        }]
                    };

                    var ctx = document.getElementById("canvas").getContext("2d");
                    var barChartDemo = new Chart(ctx).Bar(barChartData, {
                        responsive: true,
                        barValueSpacing: 2
                    });
                }
            });
        })
    });

</script>
