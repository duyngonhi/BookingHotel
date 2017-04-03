<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-lg-3 ds">
    <h3>NOTIFICATIONS</h3>
    <div id="activitybook"></div>
    <div style="text-align: center;">
	    <i class="fa fa-angle-down"></i><a id="idshowMore" href="#">Show More</a>
    </div>
</div>
<script type="text/javascript">
	$(window).on('load', function name() {
         $.get('activity?page=1',function(responseJson) {
          if(responseJson!=null){
              $.each(responseJson, function(key,value) {
           	   $('#activitybook').append("<div class=\"desc\"><div class=\"thumb\"><img class=\"img-circle\" src=\"assets/img/user.jpg\""+
                  		" width=\"35px\" height=\"35px\"></div><div class=\"details\"><p><a href=\"#\">"+value['nameUser']+"</a>"+
                  		"<a style=\"margin-left: 30px\" href=\"#\">Email:"+value['email']+"</a><br><muted>"+value['action']+"</muted></p></div></div>");
              });
              }
          });
	});
	
	$('#idshowMore').on('click', function(){
// 		$('#activitybook').empty();
		gethistory(2);
	});
	
	function gethistory(page) {
		$.get('activity?page='+page,function(responseJson) {
          if(responseJson!=null){
              $.each(responseJson, function(key,value) {
           	   $('#activitybook').append("<div class=\"desc\"><div class=\"thumb\"><img class=\"img-circle\" src=\"assets/img/user.jpg\""+
	           		" width=\"35px\" height=\"35px\"></div><div class=\"details\"><p><a href=\"#\">"+value['nameUser']+"</a>"+
	           		"<a style=\"margin-left: 30px\" href=\"#\">Email:"+value['email']+"</a><br><muted>"+value['action']+"</muted></p></div></div>");
              });
           }
        });
	}
</script>
