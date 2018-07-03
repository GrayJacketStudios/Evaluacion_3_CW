
  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">Viajes Inacap</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <c:if test="${empty sessionScope.user}">
            <li><a href="index.jsp">Iniciar sesión</a></li>
            <li><a href="registro.jsp">Registrarse</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <li><a href="viajes.jsp">Inicio</a></li>
            <li><a href="masViajes.jsp">Agregar viaje</a></li>
            <li><a href="cerrarSesion.jsp">Cerrar sesión</a></li>
        </c:if>
            
      </ul>
    </div>
  </nav>
        