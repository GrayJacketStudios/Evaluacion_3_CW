
  <nav>
    <div class="nav-wrapper">
        <c:if test="${empty sessionScope.user}">
            <a href="#" class="brand-logo">Viajes Inacap</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
        
            <li><a href="index.jsp">Iniciar sesi�n</a></li>
            <li><a href="registro.jsp">Registrarse</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <a href="#" class="brand-logo">Viajes Inacap - Bienvenido ${sessionScope.user.nombre}</a>
            
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <c:if test="${not empty sessionScope.user.foto}">
                <img src="https://st2.depositphotos.com/1104517/11967/v/950/depositphotos_119675554-stock-illustration-male-avatar-profile-picture-vector.jpg" height="50px" width="50px">
            </c:if>
            <li><a href="inicio.jsp">Inicio</a></li>
            <li><a href="masViajes.jsp">Agregar viaje</a></li>
            <li><a href="mis_datos.jsp">Mis datos</a></li>
            <li><a href="cerrarSesion.jsp">Cerrar sesi�n</a></li>
        </c:if>
            
      </ul>
    </div>
  </nav>
        