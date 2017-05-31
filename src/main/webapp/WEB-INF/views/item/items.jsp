<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>

<div class="row-mt" style="height: 750px">
    <div class="col-md-12">
        <div class="content-panel">
            <div class="bootstrap-iso">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12"><h3 style="color: #843534">List items</h3></div>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:form id="formSearch" action="searchbill" class="form-horizontal" method="post">
                                <div class="form-group " style="text-align: center;">
                                    <div class="col-sm-8">
                                        <div style="margin-top: 10px; ">
                                            <input type="text" class="form-control" id="itemName" name="itemName">
                                        </div>
                                    </div>
                                    <label class="control-label col-sm-4 requiredField">
                                        <input id="btnSearch" class="btn btn-success btn-sm pull-left" type="submit" value="Search">
                                    </label>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <c:if test="${!empty listItemsBeanEmpty}">
                <h3 style="color: red"><c:out value="${listItemsBeanEmpty}"/></h3>
            </c:if>
            <c:if test="${!empty listItemsBean}">
                <table class="table">
                    <thead>
                    <tr>
                        <th class="col-sm-1" style="color: #843534; text-align: center">STT</th>
                        <th class="col-sm-2" style="color: #843534; text-align: center">Room name</th>
                        <th class="col-sm-2" style="color: #843534; text-align: center">Price</th>
                        <th class="col-sm-5" style="color: #843534; text-align: center">Description</th>
                        <th class="col-sm-2" style="color: #843534; text-align: center">Permision</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listItemsBean}" var="item" varStatus="idx">
                        <tr>
                            <td class="col-sm-1" style="text-align: center"><a href=""><c:out value="${offset + idx.index +1 }"/></a>
                            </td>
                            <td class="col-sm-2"><c:out value="${item.name}"/></td>
                            <td class="col-sm-2" style="text-align: center"><c:out value="${item.price}"/></td>
                            <td class="col-sm-5"><c:out value="${item.description}"/></td>
                            <td style="text-align: center" class="col-sm-2">
                                <a class="btn btn-primary btn-xs" href="/edit_item?id=${item.id}">Edit</a>
                                <a class="btn btn-danger btn-xs" href="/delete_item?id=${item.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="col-md-12 row-mt">
                    <div class="col-sm-3">
                        <tag:paginate max="15" offset="${offset}" count="${count}"
                                      uri="/items" next="&raquo;" previous="&laquo;" />
                    </div>
                    <div class="col-sm-6" style="text-align: center"></div>
                    <div class="col-sm-3" style="text-align: center; padding-top: 20px">
                        <a href="${pageContext.request.contextPath}/new_item" class="btn btn-success btn-sm">
                            Add NewItem</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("input[id='btnSearch']").on('click', function () {
            var itemName = $("#itemName").val();
            $.ajax({
                url: "/search_item", type: "GET", dataType: "json",
                data: {itemName: itemName.toString()},
                success: function (data) {
                    var html = '';
                    $.each(data, function (key, value) {
                        html +=
                        '<tr>'
                            +'<td class="col-sm-1" style="text-align: center">'+value.id+'</td>'
                            +'<td class="col-sm-2">'+value.name+'</td>'
                            +'<td class="col-sm-2" style="text-align: center">'+value.price+'</td>'
                            +'<td class="col-sm-5">'+value.description+'</td>'
                            +'<td style="text-align: center">'
                            +'<a class="btn btn-primary btn-xs" href="/edit_item?id='+value.id+'">Edit</a>'
                            +'<a class="btn btn-danger btn-xs" href="/delete_item?id='+value.id+'">Delete</a>'
                            +'</td>'
                        +'</tr>'
                    });
                    $('tbody:first').html(html);
                }
            });
        })
    });

</script>
