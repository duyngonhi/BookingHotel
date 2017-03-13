<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <h4> Payment For: <span class="badge bg-info">Nguyen Van A</span></h4>
   	  	  <hr>
   	  	  <form:form action="" method="post">
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
                  <td>P301</td>
                  <td>2000000</td>
                  <td><span class="badge bg-success">500000</span></td>
                  <td><span class="badge bg-warning">1500000</span></td>
                  <td><input type="text" name="payamount"/></td>
				  <td><a class="btn btn-success btn-sm pull-left" href="">Submit</a></td>	
              </tr>
              </tbody>
          </table>
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
              <tr>
                  <td>Room</td>
                  <td>2000000</td>
              </tr>
              <tr>
                  <td>Cocacola</td>
                  <td>20000</td>
              </tr>
              </tbody>
          </table>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->
</div>
<!-- /col-lg-9 END SECTION MIDDLE -->

<!-- RIGHT SIDEBAR CONTENT -->
<%@ include file="history.jsp" %>
