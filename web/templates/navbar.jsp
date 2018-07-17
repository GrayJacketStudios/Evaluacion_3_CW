
  <nav>
    <div class="nav-wrapper">
        <c:if test="${empty sessionScope.user}">
            <a href="#" class="brand-logo">Viajes Inacap</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
        
            <li><a href="index.jsp">Iniciar sesión</a></li>
            <li><a href="registro.jsp">Registrarse</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <a href="#" class="brand-logo">Viajes Inacap - Bienvenido ${sessionScope.user.nombre}</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="inicio.jsp">Inicio</a></li>
            <li><a href="masViajes.jsp">Agregar viaje</a></li>
            <li><a href="masViajes.jsp">Mis datos</a></li>
            <li><a href="cerrarSesion.jsp">Cerrar sesión</a></li>
        </c:if>
            
      </ul>
    </div>
  </nav>
        