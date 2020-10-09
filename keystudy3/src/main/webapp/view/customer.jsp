<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="//cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        #formSearch {
            display: inline;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }

        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }
    </style>
    <script>
        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function () {
                if (this.checked) {
                    checkbox.each(function () {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function () {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function () {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-8">
                        <div class="row">
                            <div class="col-xs-5"><h2>Manage <b>Customer</b></h2>
                            </div>
                            <div class="col-xs-7"><!-- Search form -->
                                <form class="form-inline d-flex justify-content-center md-form form-sm active-cyan active-cyan-2 mt-2">
                                    <input type="hidden" name="action" value="search">
                                    <div class="row">
                                        <input class="form-control form-control-sm ml-3 w-75" type="text"
                                               placeholder="Search" name="valueSearch"
                                               aria-label="Search" style="width: 80%">
                                        <button type="submit" class="btn btn-primary" style="margin-left: 3px">Search
                                        </button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-4">
                        <a href="#addEmployeeModal" id="openAdd" class="btn btn-success" data-toggle="modal"><i
                                class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
                        <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"
                           onclick="forceStop()"><i
                                class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                    </div>
                </div>
            </div>
            <input type="hidden" id="messages" value="${messages}">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        <span class="custom-checkbox">
									<input type="checkbox" id="selectAll">
									<label for="selectAll"></label>
								</span>
                    </th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Birth Day</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="customer" items="${customerList}">
                    <c:set var = "salary" scope = "session" value = "${8*2}"/>
                    <c:out value = "${salary}"/>
                    <tr>
                        <c:if test="${salary>5}">
                            <form>
                            <td><input type="text"></td>
                            <td> <td><input type="text"></td></td>
                            <td>
                                <button type="submit">Save</button>
                                    <%--                            /* gui du lieu qua model */--%>
                                <a href="#" class="delete" data-toggle="modal" data-target="#deleteEmployeeModal"
                                   onclick="setID('${customer.customerId}')"><i class="material-icons" data-toggle="tooltip"
                                                                                title="Delete">&#xE872;</i></a>
                            </td>
                            </form>
                        </c:if>
                        <td>${customer.customerName}</td>
                        <td>${customer.customerBirthDay}</td>
                        <td>
                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"
                               onclick="setIdEdit('${customer.customerId}',
                                       '${customer.customerName}','${customer.customerBirthDay}',
                                       '${customer.customerGender}','${customer.customerIdCard}',
                                       '${customer.customerPhone}',
                                       '${customer.customerEmail}','${customer.customerAddress}')">
                                <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                <%--                            /* gui du lieu qua model */--%>
                            <a href="#" class="delete" data-toggle="modal" data-target="#deleteEmployeeModal"
                               onclick="setID('${customer.customerId}')"><i class="material-icons" data-toggle="tooltip"
                                                                            title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                <p style="color: red">${message}</p>
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item ">
                        <a href="#">Previous</a>
                    </li>
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <li class="page-item">
                            <a id="${i}" href="/customer?action=pagination&page_index=${i}" class="page-link">${i}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Add Modal HTML -->

<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/customer?action=create">
                <div class="modal-header">
                    <h4 class="modal-title">Add Customer</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Id</label>
                        <input type="text" class="form-control" required name="id">

                    </div>
                    <div class="form-group">
                        <label>Type Customer </label>
                        <select name="typeCustomerId" id="typeCustomer">
                            <c:forEach var="typeOfCustomer" items="${typeOfCustomerList}">
                                <option value="${typeOfCustomer.idCustomerType}">${typeOfCustomer.nameTypeCustomer}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" id="nameCus" required name="name">
                        <p id="msnameCus">messageName</p>
                    </div>
                    <div class="form-group">
                        <label>Birth Day</label>
                        <input type="date" class="form-control" required name="birhDay">
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <select name="gender" id="genderCustomer">
                            <option value="0">Female</option>
                            <option value="1">male</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control"  id="phoneCus"required name="phone">
                        <p id="msphoneCus">messagePhone</p>
                    </div>
                    <div class="form-group">
                        <label>Id Card</label>
                        <input type="text" class="form-control" id="idCardCus" required name="idCard">
                        <p id="msidCarCus">messageIdCard</p>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" id="emailCus"required name="email">
                        <p id="msemailCus">messageAddress</p>
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" id="addressCus" name="address">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Edit Modal HTML -->


<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/customer?action=edit">
                <input type="hidden" id="idCustomerEdit" name="idEdit">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Type Customer </label>
                        <select name="typeCustomerId" id="typeCustomerEdit">
                            <c:forEach var="typeOfCustomer" items="${typeOfCustomerList}">
                                <option value="${typeOfCustomer.idCustomerType}">${typeOfCustomer.nameTypeCustomer}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required name="nameEdit" id="nameEdit">
                        <p>${errormsg}</p>
                    </div>
                    <div class="form-group">
                        <label>Birth Day</label>
                        <input type="text" class="form-control" required name="birhDayEdit" id="birhDayEdit">
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <select name="gender" id="genderCustomerEdit">
                            <option value="0">Female</option>
                            <option value="1">male</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Id Card</label>
                        <input type="text" class="form-control" required name="idCard" id="idCard">
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required name="phone" id="phone">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required name="email" id="email">
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" required name="address" id="address">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/customer?action=delete">
                <input type="hidden" id="idCustomer" name="id">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete" onclick="forceStop()">
                </div>
            </form>
        </div>
    </div>
</div>


<%--popUp thanh cong--%>

<a href="#" class="delete" data-toggle="modal" data-target="#successEmployeeModal" id="success"></a>

<div id="successEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/customer?action=delete">
                <input type="hidden" name="id">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Success Congration</p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Thank You">
                </div>
            </form>
        </div>
    </div>
</div>




<script>

    function setID(id) {
        document.getElementById("idCustomer").value = id;
    }

    function setIdEdit(id, name, birthDay, gender, idCard, phone, email, address) {
        document.getElementById("idCustomerEdit").value = id;
        document.getElementById("nameEdit").value = name;
        document.getElementById("birhDayEdit").value = birthDay;
        document.getElementById("genderCustomerEdit").value = gender;
        document.getElementById("idCard").value = idCard;
        document.getElementById("phone").value = phone;
        document.getElementById("email").value = email;
        document.getElementById("address").value = address;
    }
/* delete muptile */
    function forceStop() {
        let checkBoxes = document.getElementsByName("checkboxCustomer");
        let selected = new Array();
        for (let i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].checked) {
                selected.push(checkBoxes[i].value);
            }
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/customer?action=delete",
            type: "post",
            dataType: 'json',
            data: {toDelete: selected},
            success: function (data) {
                console.log("SUCCESS");
            },
        });
    }

</script>
<script>
    let mess= document.getElementById("messages").value;
    let array= mess.split(",");
  if (array[8]=="Not Success"){
      alert(array[0]);
      document.getElementById("nameCus").value=array[0];
      document.getElementById("msnameCus").innerText=array[1];
      document.getElementById("phoneCus").value=array[2];
      document.getElementById("msphoneCus").innerText=array[3];
      document.getElementById("idCardCus").value=array[4];
      document.getElementById("msidCarCus").innerText=array[5];
      document.getElementById("emailCus").value=array[6];
      document.getElementById("msemailCus").innerText=array[7];
      document.getElementById("openAdd").click();
  }else if (array[8]=="Insert Success"){
      document.getElementById("success").click();
  }
</script>


</body>
</html>