<%-- 
    Document   : index
    Created on : 25 Nov, 2022, 12:24:11 PM
    Author     : Lenovo
--%>
<%@page import="java.util.List" %>
<%@page import="com.quad.modal.Quad"%>
<%@page import="com.quad.dao.Quad_dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css">
    <title>Employe Details</title>
</head>

<body>
    <p class="text-center fs-1 fw-bold text-primary">Employee Details</p>



    <p class="text-center fs-3 fw-bold">
        ${param.message}
    </p>


    <div class="row m-3">
        <div class="col">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">ADD EMPLOYEE</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="Quad_controller" method="post">
                                <input type="hidden" name="action" value="insert">
                                <div class="row p-2">
                                    <div class="col">
                                        <h5>EMPLOYEE ID:</h5>
                                    </div>

                                    <div class="col">
                                        <select name="" id="">
                                            <option value="" selected disabled>Select the ID</option>
                                            <option value="" name="eid">1</option>
                                            <option value="" name="eid">2</option>
                                            <option value="" name="eid">3</option>
                                            <option value="" name="eid">4</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row p-2">
                                    <div class="col">
                                        <h5>EMPLOYEE Name:</h5>
                                    </div>

                                    <div class="col">
                                        <input type="text" class="" name="ename">
                                    </div>
                                </div>

                                <div class="row p-2">
                                    <div class="col">
                                        <h5>Date of Joining:</h5>
                                    </div>

                                    <div class="col">
                                        <input type="date" class="" name="doj">
                                    </div>
                                </div>

                                <div class="row p-2">
                                    <div class="col">
                                        <h5>Year of Experience:</h5>
                                    </div>

                                    <div class="col">
                                        <input type="number" class="" name="yoe">
                                    </div>
                                </div>

                                <div class="row p-2">
                                    <div class="col">
                                        <h5>Designation:</h5>
                                    </div>

                                    <div class="col">
                                        <input type="text" class="" name="designation">
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancle</button>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </div>       


                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container py-3">
        <div class="row">
            <table id="example" class="table table-striped" style="width:100%">
                <thead>
                    <tr>
                        <th>Eid</th>
                        <th>EName</th>
                        <th>DOJ</th>
                        <th>YOE</th>
                        <th>Designation</th>
                    </tr>
                </thead>


                <%
                Quad_dao quad_dao = new Quad_dao();
                List<Quad> records = quad_dao.retrive();
                for(Quad record : records){
                
                %>
                <tbody>
                    <tr>
                        <td><%=record.getEid()%></td>
                        <td><%=record.getEname()%></td>
                        <td><%=record.getDoj()%></td>
                        <td><%=record.getYoe()%></td>
                        <td><%=record.getDesignation()%></td>
                    </tr>
                </tbody>
                <% }
                %>    
            </table>

        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
    <script src="javascript.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>

</body>

</html>
