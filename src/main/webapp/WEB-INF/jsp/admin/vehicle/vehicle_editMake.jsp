<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav.admin.jsp" %>

<script>
    $(document).ready(function() {

        $("#successAlert").delay(4000).fadeOut(2000);

        $("#errorAlert").delay(5000).fadeOut(2000);

    });
</script>

<style>
    .left_padding{padding-left:26px}
</style>

<div class="wrapper">

    <%--SideBar--%>
    <%@include file="vehicle_sidebar.jsp" %>


    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/addMake" method="post">
                <fieldset>
                    <div class="text-center"><legend>Add Vehicle Make</legend></div>

                    <div class="form-group left_padding ">
                        <div class="input-group col-sm-7">
                            <span class="input-group-addon">New Make</span>
                            <form:input path="newVehicleMake" type="text" class="form-control" id="inputNewVehicleMake"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-default submit_button">Add</button>
                                </span>
                        </div>
                    </div>

                    <%--<div class="form-group">--%>
                        <%--<label for="inputNewVehicleMake" class="col-sm-2 text-right">Vehicle Make</label>--%>
                        <%--<div class="col-sm-5">--%>
                            <%--<form:input path="newVehicleMake" type="text" class="form-control" id="inputNewVehicleMake" placeholder="Vehicle Make"></form:input>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<div class="col-lg-10 col-lg-offset-2">--%>
                            <%--<form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>--%>
                            <%--<form:button type="submit" value="save" class="btn btn-primary">Save</form:button>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <div class="col-sm-10">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Make</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                    <tr>
                                        <td>${vehicleMake.vehicleMakeId}</td>
                                        <td>${vehicleMake.vehicleMakeName}</td>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </fieldset>
            </form:form>


        </div>
        <div class="col-sm-4">
            <%--Success Alerts--%>
            <div class="${successAlert == null ? 'hidden': successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <p><strong>Success</strong>, Vehicle Make Added! </p>
                </div>
            </div>

            <%--Error Alerts--%>
            <div class="${errorAlert == null ? 'hidden': errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>ERROR!</strong> Vehicle Make Creation Failed
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>