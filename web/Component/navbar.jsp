

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="height: 100px">
    <div class="container-fluid">
        <a class="navbar-brand" href="ProductList">ShopQ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="ProductList">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form method="get" action="ProductList" class="d-flex" style="margin-right: 50px">
                <input name="search" class="form-control me-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
                <c:choose>
                    <c:when test="${sessionScope.Account!=null}">
                        <div class="ml-4 d-flex mt-3 mr-3">
                            <i class="fa-solid fa-user-tie fa-2xl m-2"></i>
                            <a href="updateAc"><h5>${Account.getAccountName()}</h5></a>
                            
                            <c:if test="${sessionScope.Account.getRoleId()!=2}">
                                <c:if test="${sessionScope.Cart!=null&&sessionScope.Cart.size()>0}">
                                <a href="cart.jsp"><i class="fa-solid fa-cart-arrow-down fa-2xl m-2"></i></a>
                                </c:if>
                                <c:if test="${sessionScope.Cart==null||sessionScope.Cart.size()==0}">
                                <a href="cart.jsp"><i class="fa-solid fa-cart-shopping fa-2xl m-2" style="color: black"></i></a>
                                
                            </c:if>
                            <%--Order --%>
                                <a href="MyOrder">
                                    <img src="https://www.pngitem.com/pimgs/m/185-1852219_delivery-send-canceled-order-icon-hd-png-download.png" alt="order" style="width: 40px; height: 30px; margin-bottom: 10px" />
                                </a>
                            </c:if>
                        </div>
                           
                        <a href="LogOut" style="margin-left: 5px;"><button name="logout" style="width: 100px; height: 50px" class="btn btn-primary" type="button">Log Out</button></a>
                    </c:when>
                    <c:otherwise>
                        <a href="signIn.jsp" style="margin-left: 5px;"><button style="width: 100px; height: 50px" class="btn btn-primary" type="button">Sign In</button></a>
                    </c:otherwise>    
                </c:choose>


            </form>
        </div>
    </div>
</nav>