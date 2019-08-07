$(document).ready(function () {
    getUsers();
    getRoles();


});


function getUsers() {


    // $("table").show();
    $.ajax({
        type: 'GET',
        url: "/api/users/",
        success: function (users) {
            $.each(users, function (i, user) {
                $("#filmstable").append(`
                    <tr id="myTR${user.id}">
                        <td id="tabname${user.id}">${user.name}</td>
                        <td id="tabpas">${user.pass}</td>
                        <td class='btn btn-primary'  onclick='deleteuser(${user.id})'> delete</> </td>
                        <td> <a href='#myModal' onclick='drowModal(${user.id})' class='btn btn-primary' data-toggle='modal' data-target='#myModal' >edit</a></td>
                    </tr>`);
                userscount = users.length;
            });
        }
    });

}


function getRoles() {
    $.ajax({
        type: 'GET',
        url: "/api/users/roles/",
        success: function (roles) {
            $.each(roles, function (i, role) {
                $("#roletable").append(`
        
                    <tr id='myTR${role.id}'>
                        <td id="newrole">${role.type}</td>
                         <td id="checkedrole"><input type='checkbox'  name='role.type' class='checkedroles'  value='${role.id}' </td>
                    </tr>`);

            });
            allroles=roles;
            return roles;
        }
    });
}

function drowModal(id) {
    upid = id;
    $.ajax({
        type: 'GET',
        url: "/api/users/roles/",
        success: function (roles) {
            console.log(roles);
            $.each(roles, function (i, role) {
                $("#roleupdtable").append(`
                    <tr id='myTR${role.id}'>
                        <td id="newrole">${role.type}</td>
                         <td id="checkedupdrole"><input type='checkbox' name='role.type' class='checkedupdroles'  value='${role.id}' </td>
                    </tr>`);

            });
        }
    });

    $.ajax({
        url: '/api/users/' + id,
        method: 'GET',
        datatype: 'json',
        success: function (getuser) {
            olduser = getuser;
            console.log(olduser);
            document.getElementById("updname").value = olduser.name;
            document.getElementById("updlogin").value = olduser.login;
            document.getElementById("updpass").value = olduser.pass;
            var checkboxes = document.getElementsByClassName('checkedupdroles');
            // checkboxes[1].checked=true;

            $.each(olduser.roles, function (i, userrole) {
                $.each(allroles, function (y, role) {
                    if (userrole.id == role.id) {
                        checkboxes[y].checked = true;
                    }
                })
            })
        }
    })


}

var User = {
    id: 0,
    login: "",
    name: "",
    pass: "",
    roles: []
};

function prepareadduser() {

    User.name = $('#uname').val();
    User.login = $('#ulogin').val();
    User.pass = $('#upass').val();
    var checkboxes = document.getElementsByClassName('checkedroles');
    var roles = [];
    var roletype = []
    for (var index = 0; index < checkboxes.length; index++) {
        if (checkboxes[index].checked) {
            roletype.push(checkboxes[index].value);
        }
    }
    for (var index = 0; index < roletype.length; index++) {
        if (roletype[index] == 1) {
            roles.push({
                "id": 1,
                "type": "USER",
                "authority": "USER"
            });
        } else if (roletype[index] == 2) {
            roles.push({
                "id": 2,
                "type": "ADMIN",
                "authority": "ADMIN"
            });
        } else if (roletype[index] == 3) {
            roles.push({
                "id": 3,
                "type": "MODERATOR",
                "authority": "MODERATOR"
            });
        }
    }
    User.roles = roles;
    addData(User);


}

function prepareupdateuser(id) {
    User.name = $('#updname').val();
    User.login = $('#updlogin').val();
    User.pass = $('#updpass').val();
    var checkboxes = document.getElementsByClassName('checkedupdroles');
    var roles = [];
    var roletype = []
    for (var index = 0; index < checkboxes.length; index++) {
        if (checkboxes[index].checked) {
            roletype.push(checkboxes[index].value);
        }
    }
    for (var index = 0; index < roletype.length; index++) {
        if (roletype[index] == 1) {
            roles.push({
                "id": 1,
                "type": "USER",
                "authority": "USER"
            });
        } else if (roletype[index] == 2) {
            roles.push({
                "id": 2,
                "type": "ADMIN",
                "authority": "ADMIN"
            });
        } else if (roletype[index] == 3) {
            roles.push({
                "id": 3,
                "type": "MODERATOR",
                "authority": "MODERATOR"
            });
        }
    }
    User.roles = roles;
    updateData(User, id);
    formClear();

}


function addData(user) {// pass your data in method
    $.ajax({
        url: '/api/users/',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(user),
        success: function (user) {
            formaddClear();

            $('[href="#panel1"]').tab('show');
            $("#filmstable").append(`
                    <tr id="myTR${User.id}">
                        <td >${User.name}</td>
                        <td>${User.pass}</td>
                        <td class='btn btn-primary'  onclick='deleteuser(${User.id})'> delete</> </td>
                        <td> <a href='#myModal' onclick='drowModal(${User.id})' class='btn btn-primary' data-toggle='modal' data-target='#myModal' >edit</a></td>
                    </tr>`);
        },
        error:function (user) {
            formaddClear();

            $('[href="#panel1"]').tab('show');
            $("#filmstable").append(`
                    <tr id="myTR${User.id}">
                        <td >${User.name}</td>
                        <td>${User.pass}</td>
                        <td class='btn btn-primary'  onclick='deleteuser(${User.id})'> delete</> </td>
                        <td> <a href='#myModal' onclick='drowModal(${User.id})' class='btn btn-primary' data-toggle='modal' data-target='#myModal' >edit</a></td>
                    </tr>`);
        }

    });
}

function updateData(newuser, id) {// pass your data in method

    $.ajax({
        url: '/api/users/' + id,
        method: 'PUT',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(newuser),
        success: function (response) {
            formaddClear();

            for (var index = 1; index <=userscount; index++) {
                $("#myTR" + index).remove();
            }
            $.each(getUsers(), function (i, user) {
                $("#filmstable").append(`
                    <tr id="myTR${id}">
                        <td >${User.name}</td>
                        <td>${User.pass}</td>
                        <td class='btn btn-primary'  onclick='deleteuser(${id})'> delete</> </td>
                        <td> <a href='#myModal' onclick='drowModal(${id})' class='btn btn-primary' data-toggle='modal' data-target='#myModal' >edit</a></td>
                    </tr>`);
            });
            $('#myModal').modal('hide');
        },
        error: function(ts) {

        formaddClear();

            for (var index = 1; index <=userscount; index++) {
                $("#myTR" + index).remove();
            }
    $.each(getUsers(), function (i, user) {
        $("#filmstable").append(`
                    <tr id="myTR${id}">
                        <td >${User.name}</td>
                        <td>${User.pass}</td>
                        <td class='btn btn-primary'  onclick='deleteuser(${id})'> delete</> </td>
                        <td> <a href='#myModal' onclick='drowModal(${id})' class='btn btn-primary' data-toggle='modal' data-target='#myModal' >edit</a></td>
                    </tr>`);
    });
    $('#myModal').modal('hide');
}

    });
}

function deleteuser(id) {
    $.ajax({
        url: '/api/users/' + id,
        method: 'DELETE',
        success: function (response) {
            $("#myTR" + id).remove();
        }
    })

}
function formClear() {
    $("#updname").val("");
    $("#updlogin").val("");
    $("#updpass").val("");
    $('#roleupdtable').remove();

}function formaddClear() {
    $("#uname").val("");
    $("#ulogin").val("");
    $("#upass").val("");
}


