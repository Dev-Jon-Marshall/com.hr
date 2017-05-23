<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav.admin.jsp" %>

<div class="wrapper">

    <%--SideBar--%>
    <%@include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>
                </thead>
                <tbody>
                <%--${vehicleModelList}${vehicleMakeList}--%>
                <c:forEach var="make" items="${vehicleMakeList}">
                    <c:forEach var="model" items="${make.vehicleModelList}">
                        <c:forEach var="vehicle" items="${model.vehicleList}">
                            <tr>
                                <td>${vehicle.id}</td>
                                <td>${make.vehicleMakeName}</td>
                                <td>${model.vehicleModelName}</td>
                                <td>${vehicle.year}</td>
                                <td>${vehicle.licensePlate}</td>
                                <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                                <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>

                </tbody>
            </table>


        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>