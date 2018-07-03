

<%@include file="templates/header.jsp" %>
<%@include file="middleware/checkNotSession.jsp" %>

  <div class="row">
    <div class="col s12 m10 offset-m1">
      <div class="card-panel light-blue lighten-4">
          <h3 class="center white-text">Registrarse</h3>
          <form method="POST" action="control.do">
              
              <div class="input-field col s12">
                <input id="rut" type="text" class="validate" name="rut" required>
                <label for="rut">Rut</label>
              </div>
              <div class="input-field col s12">
                <input id="nombre" type="text" class="validate" name="nombre" required>
                <label for="nombre">Nombre</label>
              </div>
              
              <div class="input-field col s12">
                <input id="clave" type="password" class="validate" name="clave" required>
                <label for="clave">Password</label>
              </div>
              <div class="input-field col s12">
                <input id="clave2" type="password" class="validate" name="clave2" required>
                <label for="clave2">Repetir Password</label>
              </div>
              <div class="input-field col s12">
                <input id="telefono" type="text" class="validate" name="telefono" required>
                <label for="telefono">Telefono</label>
              </div>
              <div class="input-field col s12">
                <input id="correo" type="email" class="validate" name="correo" required>
                <label for="correo">Correo</label>
              </div>
              
              <button class="btn center" name="boton" value="registrar">Registrar</button>
              
                
              
              
          </form>
          <p class="red text">${requestScope.msg}</p>
      </div>
    </div>
  </div>
            


<%@include file="templates/footer.jsp" %>