

<c:if test="${not empty sessionScope.user}">
    <% response.sendRedirect("inicio.jsp"); %>
</c:if>
