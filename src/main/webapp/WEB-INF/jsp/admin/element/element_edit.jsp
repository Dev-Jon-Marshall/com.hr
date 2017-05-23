<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav.admin.jsp" %>
<script>
    $(document).ready(function()
    {
        //attach an onClick function to the remove buttons
        $('.remove_button').click(function()
        {
            //log name of button and contents of associated text box
            console.log(this.name);
            console.log($('#'+ this.name).val());
            //clear the value of the text box
            $('#'+ this.name).val('');
            //submit the form
            $('#elementType').submit();
        });
    });
</script>
<div class="wrapper">

    <%--SideBar--%>
    <%@include file="element_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            
            <c:set var="idx" value="0" scope="page"></c:set>
            <form:form class="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="post">
            <fieldset>
                <form:hidden path="id"></form:hidden>
                <form:hidden path="version"></form:hidden>
                
                <div class="row">
                    <div class="form-group">
                        <label for="inputElementTypeName" class="col-sm-2 control-label">Element Type</label>
                        <div class="col-sm-10">
                            <form:input path="elementTypeName" type="text" id="inputElementTypeName" class="form-control"></form:input>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

                <c:forEach items="${elementType.elementList}" var="element">
                    <form:hidden path="elementList[${idx}].id"></form:hidden>
                    <form:hidden path="elementList[${idx}].version"></form:hidden>
                    <div class="row">
                        <div class="form-group">
                            <label for="${idx}" class="col-sm-3 control-label">Element</label>
                            <div class="col-sm-7">
                                <div class="input-group">
                                    <form:input path="elementList[${idx}].elementName" id="${idx}" class="form-control"></form:input>
                                        <span class="input-group-btn">
                                            <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>
                                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="idx" value="${idx +1}" scope="page"></c:set>
                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <label for="inputNewElement" class="col-sm-3 control-label">Element</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="inputNewElement" id="inputNewElement" placeholder="Enter New Element"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>
            </fieldset>
            </form:form>
            
        </div>
        <div class="col-sm-4">
            <%--Success Alerts--%>
                <div class="${successAlert == null ? 'hidden': successAlert}" id="successAlert">
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                    </div>
                </div>
                <%--Warning Alerts--%>
                <div class="${warningAlert == null ? 'hidden': warningAlert}" id="warningAlert">
                    <div class="alert alert-dismissible alert-warning">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <h4>Warning!</h4>
                        <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
                    </div>
                </div>
                        <%--Error Alerts--%>
                <div class="${errorAlert == null ? 'hidden': errorAlert}" id="errorAlert">
                    <div class="alert alert-dismissible alert-danger">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                    </div>
                </div>
        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>