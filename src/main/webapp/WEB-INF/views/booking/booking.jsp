<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
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
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<script>
    $(document).ready(function () {
        var date_input = $('input[name="birthDay"]');
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy/mm/dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        })
    });
</script>
<div class="col-lg-9">
    <form:form class="form-horizontal style-form" modelAttribute="bookingBeanForm" id="formBooking"
               action="${pageContext.request.contextPath}/bookingAction" method="post">
        <div>
            <aside class="col-lg-4 mt">
                <div class="form-horizontal style-form" modelAttribute="clientBeanForm">
                    <section class="panel">
                        <div class="panel-body">
                            <h4><i style="color: #843534">Client infomation</i></h4>
                            <hr>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                                    Fullname<span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-9">
                                    <input class="form-control" name="fullName" type="text" path="fullName"
                                           placeholder=" full name..." id="fullName">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                                    Card number<span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-9">
                                    <input class="form-control" name="cardNumber" type="text" path="cardNumber"
                                           placeholder=" card number..." id="cardNumber">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label class="col-sm-3 control-label">
                                    Birthday<span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input class="form-control" path="birthDay" id="birthDay" name="birthDay"
                                               placeholder="yyyy/mm/dd" type="text"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                                    Address<span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-9">
                                    <input class="form-control" name="address" type="text" path="address"
                                           placeholder=" address..." id="address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                                    Phone<span class="asteriskField">*</span>
                                </label>
                                <div class="col-sm-9">
                                    <input class="form-control" name="phone" type="text" path="phone"
                                           placeholder=" phone..." id="phone">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </aside>

            <aside class="col-lg-8 mt">
                <div class="form-horizontal style-form" modelAttribute="roomBeanForm">
                    <section class="panel">
                        <div class="panel-body">
                            <h4><i class="fa fa-tasks" style="color: green"> Booking room infomation</i></h4>
                            <hr>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Hotel</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.getHotel().getName()}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Star level</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.getHotel().getStarLevel()}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Room name</label>
                                <div class="col-sm-9">
                                    <label class="control-label">  ${roomBeanForm.id} - ${roomBeanForm.name}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Price per night</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.price}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Description</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.description}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Time booking</label>
                                <div class="col-sm-9">
                                    <label class="control-label">
                                            ${roomBeanForm.start} - ${roomBeanForm.end}
                                    </label>
                                </div>
                                <input type="hidden" name="start" path="start" value="${roomBeanForm.start}"/>
                                <input type="hidden" name="end" path="end" value="${roomBeanForm.end}"/>
                                <input type="hidden" path="id" name="id" value="${roomBeanForm.id}"/>
                                <input type="hidden" path="price" name="price" value="${roomBeanForm.price}"/>
                            </div>
                        </div>
                    </section>
                </div>
            </aside>
        </div>

        <div>
            <aside class="col-lg-12">
                <div class="form-horizontal style-form">
                    <section class="panel">
                        <div class="panel-body">
                            <div class="panel-heading">
                                <div class="pull-left"><h4><i class="fa fa-tasks" style="color: #c75609">
                                    Service List</i></h4>
                                </div>
                                <br>
                            </div>
                            <div class="custom-check goleft mt" class="col-sm-6">
                                <table id="todo" class="table table-hover custom-check">
                                    <tbody>
                                    <tr>
                                        <td class="col-sm-2"></td>
                                        <td class="col-sm-2" style="text-align: center; color: #c75609">Service name
                                        </td>
                                        <td class="col-sm-2" style="text-align: center; color: #c75609">Price</td>
                                        <td class="col-sm-5" style="text-align: center; color: #c75609">Description</td>
                                    </tr>
                                    <c:forEach items="${listItemsBeanForm}" var="item">
                                        <tr>
                                            <td class="col-sm-2">
                                                <form:checkbox path="items" name="items" value="${item.id}"
                                                />
                                            </td>
                                            <td class="col-sm-2" style="text-align: center">${item.name}</td>
                                            <td class="col-sm-2" style="text-align: center">${item.price}</td>
                                            <td class="col-sm-5">${item.description}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </aside>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <form:checkbox path="isCheckin" name="isCheckin" value="1" label=" Check in"/>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <div style="text-align: center">
                        <a id="btnBooking" class="btn btn-success" style="color: #efeaee">Booking</a>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-12">
                </div>
            </div>
        </div>

    </form:form>
</div>

<div class="col-lg-3 ds">
    <h3>NOTIFICATIONS</h3>
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
        </div>
        <div class="details">
            <p>
                <muted>2 Minutes Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">James Brown</a> subscribed to your newsletter.<br>
            </p>
        </div>
    </div>

    <h3>FEED</h3>
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
</div>
<script type="text/javascript">
    $('#btnBooking').on("click", function (e) {
        e.preventDefault();
        $("#formBooking").submit();
    });
</script>
