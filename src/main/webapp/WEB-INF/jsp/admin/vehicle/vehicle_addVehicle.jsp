<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav.admin.jsp" %>

<c:url var="modelsByMake" value="/model"/>


<script>
    $(document).ready(function() {
        $('#vehicleMakeId').change(function() {
            $.getJSON('${modelsByMake}', {
                selectedMake : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">-----Model-----</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].vehicleModelId + '">'
                            + data[i].vehicleModelName + '</option>';
                }

                $('#vehicleModelId').html(html);
            });
        });
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
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/addVehicle" method="post">
                <fieldset>

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
                        <label for="vehicleModelId" class="col-sm-3 control-label">Models</label>
                        <div class="col-sm-9">
                            <form:select  class="form-control" path="vehicleModel.vehicleModelId" id="vehicleModelId" name="vehicleModelId">
                                <%--<option value="0">(Select)</option>--%>

                                <%--<c:forEach var="vehicleModel" items="${vehicleModelList}">--%>
                                    <%--<c:choose>--%>
                                        <%--<c:when test="${vehicleModel == vehicleModelID}">--%>
                                            <%--<option selected value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>--%>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>
                                            <%--<option value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>--%>
                                        <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                <%--</c:forEach>--%>
                                <%--</c:forEach>--%>
                            </form:select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="licensePlate" class="col-sm-3 control-label">License Plate</label>
                        <div class="col-sm-9">
                            <form:input path="vehicle.licensePlate" type="text" class="form-control" id="licensePlate" placeholder="licensePlate"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="vin" class="col-sm-3 control-label">VIN</label>
                        <div class="col-sm-9">
                            <form:input path="vehicle.vin" type="text" class="form-control" id="vin" placeholder="Vehicle Identification Number"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="year" class="col-sm-3 control-label">Year</label>
                        <div class="col-sm-9">
                            <form:input path="vehicle.year" type="text" class="form-control" id="year" placeholder="Model Year"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="color" class="col-sm-3 control-label">Color</label>
                        <div class="col-sm-9">
                            <form:input path="vehicle.color" type="text" class="form-control" id="color" placeholder="Vehicle Color"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">Purchased</label>
                        <div class="col-sm-9">
                            <label class="radio-inline">
                                <form:radiobutton path="vehicle.isPurchase" name="isPurchase" id="isPurchaseTrue" value="true"/>
                                Yes
                            </label>

                            <label class="radio-inline">
                                <form:radiobutton path="vehicle.isPurchase" name="isPurchase" id="isPurchaseFalse" value="false"/>
                                No
                            </label>
                        </div>
                    </div>

                    <div class="form-group"  id="purchaseDiv">
                        <label for="purchasePrice" class="col-sm-3 control-label">Purchase Price</label>
                        <div class="input-group col-sm-9">
                            <span class="input-group-addon">$</span>
                            <form:input path="vehicle.purchasePrice" type="text" class="form-control" id="purchasePrice" placeholder="purchasePrice"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="purchaseDate"  class="col-sm-3 control-label">Purchase Date</label>
                        <div class="col-sm-9">
                            <form:input path="vehicle.purchaseDate" class="form-control" id="purchaseDate" name="purchaseDate" placeholder="format: mm/dd/yyyy"/>
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
            <%--Alerts--%>
            <%--Success Alerts--%>
            <div class="${successAlert == null ? 'hidden': successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Vehicle Successfully Added!</strong>
                </div>
            </div>

            <%--Error Alerts--%>
            <div class="${errorAlert == null ? 'hidden': errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>ERROR!</strong> Vehicle Creation Failed!
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>