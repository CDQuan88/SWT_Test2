<%-- 
    Document   : addProduct
    Created on : 14-10-2023, 21:11:38
    Author     : Cao Duy Quân
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="AddProduct" method="post">
                <div class="mb-3">
                    <label for="" class="form-label">ProductName</label>
                    <input name="Pname" class="form-control" id="" aria-describedby="" required>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Price</label>
                    <input type="number" min="0" class="form-control" name="Pprice" required>
                </div>

                <select name="Pca" class="form-select" aria-label="Default select example">
                    <c:forEach items="${cl}" var="cl">
                        <option value="${cl.getCategory_id()}">
                            ${cl.name}
                        </option>
                    </c:forEach>  
                </select>

                <div class="mb-3">
                    <label for="" class="form-label">ImageLink</label>
                    <input name="Pimg" class="form-control" id="" required>
                </div>
                
                <div class="mb-3">
                    <label for="" class="form-label">Quantity</label>
                    <input name="quantity" class="form-control" type="number" required>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
        <%@include file="Component/footer.jsp" %>
    </body>
</html>
