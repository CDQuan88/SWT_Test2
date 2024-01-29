<%-- 
    Document   : DetailProduct
    Created on : 26-10-2023, 22:56:43
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
                <div class="col-lg-6 text-center" style="margin-top: 20px; text-align: center">                       
                    <img class="mt-2" style="border: solid #f5f2f2; border-radius: 20px" src="${requestScope.p.getImg()}" width="500" height="500" alt="alt">
                    <p style="font-size: 20px">${requestScope.p.getProductName()}</p>
                    <p style="font-size: 20px">Giá: ${requestScope.p.getListPrice()}</p>
                </div>

                <div class="col-lg-6 text-center" style="margin-top: 10%;">                       
                    <p style="font-size: 20px">Hiện có: ${requestScope.p.getQuantity()}</p>
                    <p style="font-size: 20px">Mô tả: Sản phẩm chất lượng cao, cam đoan mang cho người dùng cảm giác thoải mái.</p>
                <form method="post" action="ProductList">
                    <button name="addToCart" type="submit" class="btn btn-primary">Thêm vào giỏ hàng</button>
                    <input hidden name="pid" value="${p.productId}">
                </form>
                </div>

                
            </div>
        </div>

    </body>
</html>

