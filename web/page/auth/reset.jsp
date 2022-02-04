<%-- 
    Document   : reset
    Created on : Jan 27, 2022, 3:49:02 PM
    Author     : chris
--%>

<jsp:include page="/page/link/header.jsp"/>
    <main>
        <div class="mainContent">
            <h2>
                Reset Password
            </h2>
            <div class="gridWrapper">
                <div class="gridSubContent">
                    <form action="public" method="post">
                        <input type="hidden" name="action" value="resetPassword">
                        <div>
                            <p>
                                Email: 
                            </p>
                            <input type="text" name="email">
                        </div>
                        <input type="submit" value="Reset" class="styledButton">
                    </form>
                </div>
            </div>
        </div>
    </main>
<jsp:include page="/page/link/footer.jsp"/>
