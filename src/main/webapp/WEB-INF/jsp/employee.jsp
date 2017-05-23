<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="/static/js/employee.js" var="employee" />
<script src="${employee}"></script>

<script>
//    This JScript code executes on page load
    $(document).ready(function() {
        buildTable();
        deleteModal();
    })
</script>
<div class="container">

    <h2 class="text-center">Employee List</h2>
    <hr>
    <button onclick="insertEmployee()" class="btn btn-primary">Add New Employee</button>

    <table id="employee-table" class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Background</th>
            <th>Projects</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>




    <div class="modal" id="employeeModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close text-white" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title text-white">Employee Details</h3>
                </div>
                <div class="modal-body">

                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="employeeId"/>
                            <hidden id="version"/>
                            <div class="form-group">
                                <label for="firstName" class="col-lg-3 control-label">First Name</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="firstName" placeholder="First Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="lastName" class="col-lg-3 control-label">Last Name</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="lastName" placeholder="Last Name">
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="background" class="col-lg-3 control-label">Background</label>
                                <div class="col-lg-9">
                                    <textarea class="form-control" rows="3" id="background"></textarea>
                                </div>
                            </div>

                        </fieldset>
                    </form>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
                </div>
            </div>
        </div>
    </div>




    <div class="modal" id="confirmDeleteModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close text-white" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title text-white">Confirm Delete</h3>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete? Once deleted it can not be undone!</p>



                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete">Delete</button>
                </div>
            </div>
        </div>
    </div>


</div>





<%@ include file="includes/footer.jsp" %>