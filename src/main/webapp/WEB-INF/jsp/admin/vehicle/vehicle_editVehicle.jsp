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

<style>

</style>


<div class="wrapper">

    <%--SideBar--%>
    <%@include file="vehicle_sidebar.jsp" %>


    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

                <form:form class="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
                    <fieldset>
                        <form:hidden path="id" name="id"></form:hidden>
                        <form:hidden path="version"></form:hidden>
                        <legend class="col-sm-12 text-center"><h2>Vehicle Information</h2></legend>

                        <div class="form-group">
                            <label for="vehicleMakeId" class="col-sm-3 control-label">Make</label>
                            <div class="col-sm-9">
                                <select class="form-control" path="vehicleMake.vehicleMakeId" id="vehicleMakeId" name="vehicleMakeId">
                                    <option value="0">(Select)</option>
                                    <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                        <c:choose>
                                            <c:when test="${vehicleMake == vehicleMakeID}">
                                                <option selected value="${vehicleMake.vehicleMakeId}">${vehicleMake.vehicleMakeName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${vehicleMake.vehicleMakeId}">${vehicleMake.vehicleMakeName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="select" class="col-sm-3 control-label">Models</label>
                            <div class="col-sm-9">
                                <select  class="form-control" path="vehicleModel.vehicleModelId" id="select" name="vehicleModelId">
                                    <option value="0">(Select)</option>

                                    <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                        <c:choose>
                                            <c:when test="${vehicleModel == vehicleModelID}">
                                                <option selected value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="licensePlate" class="col-sm-3 control-label">License Plate</label>
                            <div class="col-sm-9">
                                <form:input path="licensePlate" type="text" class="form-control" id="licensePlate" placeholder="licensePlate"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="vin" class="col-sm-3 control-label">VIN</label>
                            <div class="col-sm-9">
                                <form:input path="vin" type="text" class="form-control" id="vin" placeholder="Vehicle Identification Number"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="year" class="col-sm-3 control-label">Year</label>
                            <div class="col-sm-9">
                                <form:input path="year" type="text" class="form-control" id="year" placeholder="Model Year"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="color" class="col-sm-3 control-label">Color</label>
                            <div class="col-sm-9">
                                <form:input path="color" type="text" class="form-control" id="color" placeholder="Vehicle Color"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Purchased</label>
                            <div class="col-sm-9">
                                <label class="radio-inline">
                                    <form:radiobutton path="isPurchase" name="isPurchase" id="isPurchaseTrue" value="true"/>
                                    Yes
                                </label>

                                <label class="radio-inline">
                                    <form:radiobutton path="isPurchase" name="isPurchase" id="isPurchaseFalse" value="false"/>
                                    No
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="purchasePrice" class="col-sm-3 control-label">Purchase Price</label>
                            <div class="input-group col-sm-9">
                                <span class="input-group-addon">$</span>
                                <form:input path="purchasePrice" type="text" class="form-control" id="purchasePrice" placeholder="purchasePrice"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="purchaseDate" class="col-sm-3 control-label">Purchase Date</label>
                            <div class="col-sm-9">
                                <form:input path="purchaseDate" type="text" class="form-control" id="purchaseDate" name="purchaseDate" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-3">
                                <button type="submit" class="btn btn-default">Update</button>
                            </div>
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