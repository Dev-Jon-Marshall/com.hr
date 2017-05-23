<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="/static/js/contact.js" var="contact" />

<script src="${contact}"></script>
<script>
    //    This JScript code executes on page load
    $(document).ready(function() {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">

    <h2 class="text-center">Contact List</h2>
    <hr>
    <button onclick="insertContact()" class="btn btn-primary">Add New Contact</button>

    <table id="contact-table" class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>


    <div class="modal" id="contactModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close text-white" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title text-white">Contact Details</h3>
                </div>
                <div class="modal-body">

                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="contactId"/>
                            <hidden id="contactVersion"/>
                            <hidden id="personId"/>
                            <hidden id="personVersion"/>
                            <hidden id="addressId"/>
                            <hidden id="addressVersion"/>
                            <%--NAME--%>
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

                            <%--STREET--%>
                            <div class="form-group">
                                <label for="street" class="col-lg-3 control-label">Address</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="street" placeholder="Address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="streetExt" class="col-lg-3 control-label">Address</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="streetExt" placeholder="Address">
                                </div>
                            </div>

                            CITY STATE ZIP
                            <div class="form-group">
                                <label for="city" class="col-lg-3 control-label">City</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="city" placeholder="City">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="state" class="col-lg-3 control-label">State</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="state" placeholder="State">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="zip" class="col-lg-3 control-label">Zip Code</label>
                                <div class="col-lg-9">
                                    <input type="text" class="form-control" id="zip" placeholder="Zip Code">
                                </div>
                            </div>

                        </fieldset>
                    </form>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveContact()">Save changes</button>
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