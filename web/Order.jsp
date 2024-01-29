<%-- 
    Document   : Order
    Created on : 28-10-2023, 15:08:27
    Author     : Cao Duy Quân
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="helper" class="util.helper"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Component/header.jsp" %>
    </head>
    <body>
        <%@include file="Component/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <c:if test="${requestScope.listOr!=null||requestScope.listOr.size()>0}">
                    <table class="table" style="margin-top: 100px">
                        <thead class="table">
                            <tr class="table">
                                <th scope="col">#</th>

                                <th scope="col">OrderDate</th>
                                <th scope="col">Ammount</th>
                                <th scope="col">Total</th>
                                <th scope="col">Address</th>
                                <th scope="col">Phone number</th>
                                <th scope="col">Name</th>
                               
                                <th scope="col" colspan="2"></th>
                            </tr>
                        </thead>

                        <tbody class="table">

                            <c:forEach items="${requestScope.listOr}" var="o" varStatus="loop">
                                <tr class="table-primary">
                                    <th scope="row">${loop.index + 1}</th>
                                    <th scope="row">${o.getOrderDate()}</th>
                                    <th scope="row">${o.getTotal()/10}</th>
                                    <th scope="row">${o.getPrice()/10}</th>
                                    <th scope="row">${sessionScope.Account.getAddress()}</th>
                                    <th scope="row">${sessionScope.Account.getPhone()}</th>

                                    <c:forEach items="${sessionScope.p}" var="i">
                                        <c:if test="${o.getProduct_id()==i.getProductId()}">
                                            <th scope="row">
                                                <c:out value="${i.getProductName()}"/>
                                            </th>
                                        </c:if>
                                    </c:forEach>
                                    
                                            
                                </tr>
                            </c:forEach>

                        </tbody>

                    </table>
                    
                </c:if>
                <div class="row">
                    <div class="col">
                        <c:if test="${requestScope.listOr==null||requestScope.listOr.size()==0}">

                            <div class="col bg-light" style="margin-top: 100px; background-color: white">
                                <h4 style="margin-left: 45%">Order Empty</h4>
                            </div>
                            <div class="text-center">
                                <a href="ProductList"><i class="fa-solid fa-o-plus fa-2xl" style="font-size: 100px; margin-top: 100px"></i></a>
                            </div>

                        </c:if>
                    </div>
                </div>


            </div>
        </div>
        <div>
            
        </div>
 
        <%@include file="Component/footer.jsp" %>
        <script>
            $('#btnSave').click(function () {
                $('#btnBuyAll').prop('type', 'submit');
                $('#btnBuyAll').click();
            })

        </script>
    </body>
</html>

