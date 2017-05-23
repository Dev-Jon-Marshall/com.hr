function buildTable()
{
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function (data){
        console.log(data)
        $.each(data, function (index, single) {
            //var fullName = single.firstName + " " + single.lastName;
            $('#employee-table').find('tbody')
                .append("<tr>" +
                "<td>" + single.personId + "</td>" +
                "<td>" + single.firstName + " " + single.lastName + "</td>" +
                "<td>" + single.background + "</td>" +
                "<td>" + "<select class='text-white navbar-inverse form-control'><option>(Select Project)</option></select>" + "</td>" +
                "<td>" + "<button class='btn-default form-control ' onclick='editEmployee(" + single.personId + ")'>Edit</button>" + "</td>" +
                "<td>" + "<button class='btn-default form-control' data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='"+single.personId+"'>Delete</button>" + "</td>" +
                "</tr>");
        });
    });
}

function insertEmployee()
{
    //clear fields in modal
    $('#employeeId').val(" ");
    $('#version').val(" ");
    $('#firstName').val(" ");
    $('#lastName').val(" ");
    $('#background').val(" ");
    //open modal
    $('#employeeModal').modal('show');
}

function saveEmployee()
{
    //retrieves data from jsp via id tag
    var id = $('#employeeId').val();
    var version = $('#version').val();
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var background = $('#background').val();

    //creating an object in js (json)
    var employee =
    {
        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        background: background,
        project: []

    }

    console.log(employee)

    //synchronous javascript call
    $.ajax({
        type: "post",
        data: employee,
        url: "/api/employee/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}

function editEmployee(id)
{
    //retrieve the employee with the passed in id
    $.getJSON('/api/employee/' + id, {
        ajax: 'true'
    }, function(employee){
        console.log(employee);
        //populate values (hidden and input)
        $('#employeeId').val(employee.id);
        $('#version').val(employee.version);
        $('#firstName').val(employee.firstName);
        $('#lastName').val(employee.lastName);
        $('#background').val(employee.background);

        //open the modal
        $('#employeeModal').modal('show')
    })
}

function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function (e) {
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');

        $.ajax({
            type: "delete",
            url: "/api/employee/" + id,
            async: true,
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("Error Deleting Employee!");
            }
        })
    });

    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });
}




