<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 31/03/2017
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row-mt"  style="height: 850px">
    <div class="col-md-12">
        <div class="content-panel">
            <div class="bootstrap-iso">
                <div class="container-fluid">
                    <div class="row"><h3 style="color: #843534">Room detail</h3><hr></div>
                    <div class="row">
                        <div class="col-md-8 col-sm-8 col-xs-12">
                            <div class="form-group">
                                <label class="col-sm-4 col-sm-4 control-label">Hotel</label>
                                <div class="col-sm-8">
                                    <label class="control-label"> ${roomBeanForm.getHotel().getName()}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-sm-4 control-label">Star</label>
                                <div class="col-sm-8">
                                    <label class="control-label"> ${roomBeanForm.getHotel().getStarLevel()}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-sm-4 control-label">Room name</label>
                                <div class="col-sm-8">
                                    <label class="control-label"> ${roomBeanForm.name}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-sm-4 control-label">Price</label>
                                <div class="col-sm-8">
                                    <label class="control-label"> ${roomBeanForm.price}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-sm-4 control-label">Size</label>
                                <div class="col-sm-8">
                                    <label class="control-label"> ${roomBeanForm.size}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-sm-4 control-label">Description</label>
                                <div class="col-sm-8">
                                    <label class="control-label"> ${roomBeanForm.description}</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <div class="centered">
                                <img src="/assets/img/image_gallery.jpg" width="400" height="400">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>