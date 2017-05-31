<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="wrapper">
    <h3>List rooms</h3>
    <div class="row">
        <div class="col-md-12">
            <div class="content-panel">
                <hr>
                <c:if test="${!empty err_listRoomIsEmpty}">
                    <h3 style="color: red"><c:out value="${err_listRoomIsEmpty}"/></h3>
                </c:if>
                <c:if test="${!empty err_deleteRoom}">
                    <h3 style="color: red"><c:out value="${err_deleteRoom}"/></h3>
                </c:if>
                <c:if test="${!empty err_editRoom}">
                    <h3 style="color: red"><c:out value="${err_editRoom}"/></h3>
                </c:if>
                <c:if test="${!empty listRoomsBean}">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Room name</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>Permision</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listRoomsBean}" var="room">
                            <tr>
                                <td><a href=""><c:out value="${room.id}"/></a></td>
                                <td><c:out value="${room.name}"/></td>
                                <td><c:out value="${room.price}"/></td>
                                <td><c:out value="${room.size}"/></td>
                                <td><c:out value="${room.description}"/></td>
                                <td>
                                    <button class="btn btn-primary btn-xs"><a href="edit_room?id=${room.id}">Edit</a>
                                    </button>
                                    <button class="btn btn-danger btn-xs"><a href="delete_room?id=${room.id}">Delete</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <div class="btn">
                    <a href="${pageContext.request.contextPath}/new_room">Add New Room</a>
                </div>
            </div>
        </div>
    </div>
</section>
