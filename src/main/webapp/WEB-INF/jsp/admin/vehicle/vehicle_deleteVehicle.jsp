<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav.admin.jsp" %>

<script>
    $(document).ready(function() {

        $("#successAlert").delay(4000).fadeOut(2000);
        $("#warningAlert").delay(5000).fadeOut(2000);
        $("#errorAlert").delay(5000).fadeOut(2000);

    });
</script>


<div class="wrapper">

    <%--SideBar--%>
    <%@include file="vehicle_sidebar.jsp" %>

        <div id="main-wrapper" class="col-sm-10">
            <div class="col-sm-8">



                <form:form class="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/deleteVehicle/${vehicle.id}" method="post">
                    <fieldset>


                        <form:hidden path="version"></form:hidden>

                        <legend class="col-sm-12 text-center"><h2>Delete Vehicle</h2></legend>

                        <div class="form-group">
                            <label class="col-sm-12 text-center">
                                Confirm Deletion of the Vehicle Listed Below by Typing "DELETE" in the confirmation box
                            </label>
                        </div>


                        <div class="form-group">
                            <label for="vehicleId" class="col-lg-3 control-label">Vehicle ID</label>
                            <div class="col-lg-2">
                                <form:input path="id" type="text" class="form-control" id="vehicleId"  readonly="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="licensePlate" class="col-sm-3 control-label">License Plate</label>
                            <div class="col-sm-9">
                                <form:input path="licensePlate" type="text" class="form-control" id="licensePlate" readonly="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="vin" class="col-sm-3 control-label">VIN</label>
                            <div class="col-sm-9">
                                <form:input path="vin" type="text" class="form-control" id="vin" readonly="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="year" class="col-sm-3 control-label">Year</label>
                            <div class="col-sm-9">
                                <form:input path="year" type="text" class="form-control" id="year" readonly="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="color" class="col-sm-3 control-label">Color</label>
                            <div class="col-sm-9">
                                <form:input path="color" type="text" class="form-control" id="color" readonly="true"/>
                            </div>
                        </div>

                        <form:hidden path="isPurchase"></form:hidden>
                        <form:hidden path="purchasePrice"></form:hidden>
                        <form:hidden path="purchaseDate"></form:hidden>

                        <br>

                        <div class="form-group left_padding ">
                            <div class="input-group col-sm-7 col-sm-offset-4">
                                <span class="input-group-addon">Confirm Delete</span>
                                <input type="text" class="form-control" name="deleteVehicleConfirm" id="deleteVehicleConfirm">
                                <span class="input-group-btn">
                                    <button class="btn btn-default submit_button">Delete</button>
                                </span>
                            </div>
                        </div>

                    </fieldset>
                </form:form>
            </div>
                <div class="col-sm-4">
                    <%--Alerts--%>
                    <%--Success Alerts--%>
                    <div class="${successAlert == null ? 'hidden': successAlert}" id="successAlert">
                        <div class="alert alert-dismissible alert-success">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Vehicle Deleted Successfully!</strong>
                        </div>
                    </div>

                    <%--Error Alerts--%>
                    <div class="${errorAlert == null ? 'hidden': errorAlert}" id="errorAlert">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>ERROR</strong> Vehicle was not deleted!
                        </div>
                    </div>
                </div>
        </div>
</div>
<%@ include file="../../includes/footer.jsp" %>