

<c:if test="${empty sessionScope.user}">
    <% response.sendRedirect("index.jsp"); %>
</c:if>
