<%-- 
    Document   : forgot
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
            <form method="post" action="Forgot">

                <div class="text-center">
                    <h1>Member SignIn</h1>
                </div>

                <h6 style="color: red">${requestScope.mess}</h6>
                <!-- Email input -->
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="floatingInput" name="email" value="${requestScope.acf.getEmail()}">
                    <label for="floatingInput">Email address</label>
                </div>

                <!-- Phone number -->
                <div class="form-floating mb-4">
                    <input minlength="6" type="text" class="form-control" id="floatingPassword" name="phone" value="${requestScope.acf.getPhone()}">
                    <label for="floatingPassword">Phone number</label>
                </div>



                <div class="form-floating mb-4">

                    Câu hỏi bảo mật: <select name="check_id">
                        <option value="1">Bạn thích món ăn gì?</option>
                        <option value="2">Bạn thích môn thể thao nào?</option>
                        <option value="3">Bạn thích nghe bài nhạc nào?</option>

                    </select>
                    <input type="text" class="form-control" name="answer" value="${requestScope.acf.getAnswer()}" placeholder="Answer" required="">

                </div>

                <div class="form-floating mb-4">
                    <input minlength="6" type="text" class="form-control" name="pass" value="${requestScope.acf.getPassword()}" readonly>
                    <label for="floatingPassword">Password</label>
                </div>

                <!-- 2 column grid layout for inline styling -->
                <div class="row mb-4">


                    <div class="col">
                        <!-- Simple link -->
                        <a href="signIn.jsp">Back to Login</a>
                    </div>

                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4">Get password</button>

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
