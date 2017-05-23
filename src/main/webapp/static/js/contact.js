function buildTable()
{
    $.getJSON('/api/contact/', {
        ajax: 'true'
    }, function (data){
        console.log(data)
        $.each(data, function (index, single) {
            var addressExtension = single.address.streetExt;

                    if(addressExtension == null)
                    {
                        $('#contact-table').find('tbody')
                            .append("<tr>" +
                            "<td>" + single.person.personId + "</td>" +
                            "<td>" + single.person.firstName + " " + single.person.lastName + "</td>" +
                            "<td>" + single.address.street + "  -  " + single.address.city + ",  " + single.address.state + "  " + single.address.zip + "</td>" +
                            "<td>" + "<button class='btn-default form-control ' onclick='editContact(" + single.contactId + ")'>Edit</button>" + "</td>" +
                            "<td>" + "<button class='btn-default form-control' data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='"+single.contactId+"'>Delete</button>" + "</td>" +
                            "</tr>");
                    }

                    else
                    {
                        $('#contact-table').find('tbody')
                            .append("<tr>" +
                            "<td>" + single.person.personId + "</td>" +
                            "<td>" + single.person.firstName + " " + single.person.lastName + "</td>" +
                            "<td>" + single.address.street + " " + single.address.streetExt + " -  " + single.address.city + ",  " + single.address.state + "  " + single.address.zip + "</td>" +
                            "<td>" + "<button class='btn-default form-control ' onclick='editContact(" + single.contactId + ")'>Edit</button>" + "</td>" +
                            "<td>" + "<button class='btn-default form-control' data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='"+single.contactId+"'>Delete</button>" + "</td>" +
                            "</tr>");
                    }
                        //Would be cool to have select choose contact method and change displayed contact information**
                        //"<td>" + "<select class='text-white navbar-inverse form-control'><option>(Select Project)</option></select>" + "</td>" +

        });
    });
}


function insertContact()
{
    //clear fields in modal
    $('#contactId').val(" ");
    $('#contactVersion').val(" ");
    $('#personId').val(" ");
    $('#personVersion').val(" ");
    $('#firstName').val(" ");
    $('#lastName').val(" ");
    $('#addressId').val(" ");
    $('#addressVersion').val(" ");
    $('#street').val(" ");
    $('#streetExt').val(" ");
    $('#city').val(" ");
    $('#state').val(" ");
    $('#zip').val(" ");

    //open modal
    $('#contactModal').modal('show');
}


function saveContact()
{
    //retrieves data from jsp via id tag
    var contactId = $('#contactId').val();
    var contactVersion = $('#contactVersion').val();
    var personId = $('#personId').val();
    var personVersion = $('#personVersion').val();
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var addressId = $('#addressId').val();
    var addressVersion = $('#addressVersion').val();
    var street = $('#street').val();

    if($('#streetExt').val()==null)
    {
        var streetExt = $('#streetExt').val(" ");
    }
    else
    {
        var streetExt = $('#streetExt').val();
    }

    var city = $('#city').val();
    var state = $('#state').val();
    var zip = $('#zip').val();

    //creating an object in js (json)
    var contact =
    {
        contactId: contactId,
        version: contactVersion,
        person:

                {
                    personId: personId,
                    version: personVersion,
                    firstName: firstName,
                    lastName: lastName,
                },

        address:

                {
                    addressId: addressId,
                    version: addressVersion,
                    street: street,
                    streetExt: streetExt,
                    city: city,
                    state: state,
                    zip: zip,
                }

    }



    console.log(contact)

    //synchronous javascript call
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(contact),
        url: "/api/contact/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}


function editContact(contactId)
{
    //retrieve the contact with the passed in id
    $.getJSON('/api/contact/' + contactId, {
        ajax: 'true'
    }, function(contact){
        console.log(contact);
        //populate values (hidden and input)

        $('#contactId').val(contact.contactId);
        $('#contactVersion').val(contact.version);
        $('#personId').val(contact.person.personId);
        $('#personVersion').val(contact.person.version);
        $('#firstName').val(contact.person.firstName);
        $('#lastName').val(contact.person.lastName);
        $('#addressId').val(contact.address.addressId);
        $('#addressVersion').val(contact.address.version);
        $('#street').val(contact.address.street);
        $('#streetExt').val(contact.address.streetExt);
        $('#city').val(contact.address.city);
        $('#state').val(contact.address.state);
        $('#zip').val(contact.address.zip);


        $('#contactModal').modal('show')
    })
}


function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function (e) {
        var $modalDiv = $(e.delegateTarget);
        var contactId = $(this).data('recordId');


        $.ajax({
            type: "delete",
            url: "/api/contact/" + contactId,
            async: true,
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("Error Deleting Contact!");
            }
        })
    });

    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });
}
