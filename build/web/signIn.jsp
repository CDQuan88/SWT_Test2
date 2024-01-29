<%-- 
    Document   : signIn
    Created on : 14-10-2023, 21:11:38
    Author     : Cao Duy Quân
--%>

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
        <div class="container" style="margin-top:200px ">
            <form method="post" action="SignIn">

                <div class="text-center">
                    <h1>Member SignIn</h1>
                </div>
                <h5 style="color: red">${requestScope.er}</h5>
                <!-- Email input -->
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="floatingInput" name="email">
                    <label for="floatingInput">Email address</label>
                </div>

                <!-- Password input -->
                <div class="form-floating mb-4">
                    <input minlength="6" type="password" class="form-control" id="floatingPassword" name="password">
                    <label for="floatingPassword">Password</label>
                </div>
                <!-- 2 column grid layout for inline styling -->
                <div class="row mb-4">
                    <div class="col d-flex justify-content-center">
                        <!-- Checkbox -->
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                            <label class="form-check-label" for="form2Example31"> Remember me </label>
                        </div>
                    </div>

                    <div class="col">
                        <!-- Simple link -->
                        <a href="forgot.jsp">Forgot password?</a>
                    </div>

<!--                    <div class="col">
                         Simple link 
                        <a href="manager/signIn.jsp">Sign In as Adminstrator</a>
                    </div>-->
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

                <!-- Register buttons -->
                <div class="text-center">
                    <p>Not a member? <a href="Register">Register</a></p>
                    <p>or sign up with:</p>
                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-facebook-f"></i>
                    </button>

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-google"></i>
                    </button>

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-twitter"></i>
                    </button>

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-github"></i>
                    </button>
                </div>
            </form>
            Login - register
        </div>
        <%@include file="Component/footer.jsp" %>

    </body>
</html>
