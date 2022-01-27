<%-- 
    Document   : login
    Created on : Jan 26, 2022, 5:54:07 PM
    Author     : chris
--%>

<jsp:include page="/page/link/header.jsp"/>
    <main>
        <div class="mainContent">
            <h2>
                Login
            </h2>
            <div class="gridWrapper">
                <div class="gridSubContent">
                    <form action="public" method="post">
                        <input type="hidden" name="action" value="authorize">
                        <div>
                            <p>
                                Username: 
                            </p>
                            <input type="text" name="username" value="${username}">
                        </div>
                        <div style="margin-top: 15px;">
                            <p>
                                Password: 
                            </p>
                            <input type="password" name="password" value="${password}">
                        </div>
                        <input type="submit" value="Login" class="styledButton">
                    </form>
                </div>
                <div class="gridSubContent">
                    <h2>Welcome to MathWiz!</h2>
                    <p>Please enter your username and password to log-in.</p>
                </div>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
