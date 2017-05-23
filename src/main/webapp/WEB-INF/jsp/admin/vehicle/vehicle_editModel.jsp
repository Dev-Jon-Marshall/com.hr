<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav.admin.jsp" %>

<c:url var="modelsByMake" value="/model"/>
<script>
    $(document).ready(function() {

        $("#vehicleMakeId").change(function () {
            //alert($("#vehicleMakeId :selected").attr('value'))
            $.getJSON('${modelsByMake}', {
                selectedMake : $(this).val(),
                ajax : 'true'
            }, function(data) {
                console.log(data)
                $('#vehicleModel-table tbody').empty();
                $('#vehicleModelInput').show();
                $.each(data, function (index, single) {
                    $('#vehicleModel-table').find('tbody')
                            .append("<tr>" +
                            "<td>" + single.vehicleModelName + "</td>" +
                            "</tr>");
                });
            });
        });
        $("#successAlert").delay(4000).fadeOut(2000);
        $("#warningAlert").delay(5000).fadeOut(2000);
        $("#errorAlert").delay(5000).fadeOut(2000);
    });


</script>

<style>
    .left_padding{padding-left:10px}
</style>

<div class="wrapper">

    <%--SideBar--%>
    <%@include file="vehicle_sidebar.jsp" %>


    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleMake" action="/admin/vehicle/addModel" method="post">


                <form:hidden path="version"></form:hidden>
                    <div class="text-center"><legend>Add Vehicle Model</legend></div>

                        <div class="form-group">
                            <label for="vehicleMakeId" class="col-sm-1 control-label">Make</label>
                            <div class="col-sm-3">
                                <form:select id="vehicleMakeId" path="vehicleMakeId" class="form-control">
                                    <option value="0">(Select Make)</option>
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
                                </form:select>
                            </div>
                        </div>


                        <table id="vehicleModel-table" class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Models</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                        <div class="form-group left_padding collapse" id="vehicleModelInput">
                            <div class="input-group col-sm-7">
                                <span class="input-group-addon">New Model</span>
                                    <input type="text" class="form-control" name="inputNewVehicleModel" id="inputNewVehicleModel">
                                <span class="input-group-btn">
                                    <button class="btn btn-default submit_button">Add</button>
                                </span>
                            </div>
                        </div>

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