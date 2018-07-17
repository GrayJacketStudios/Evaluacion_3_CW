
<%@include file="templates/header.jsp" %>
<%@include file="middleware/checkSesion.jsp" %>

  <div class="row">
    <div class="col s12 m10 offset-m1">
      <div class="card-panel light-blue lighten-4">
          <h3 class="center white-text">Modificar perfil</h3>
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
                <input id="telefono" type="text" class="validate" name="telefono" required>
                <label for="telefono">telefono</label>
              </div>
              
              
              <div class="input-field col s12">
                <input id="email" type="text" class="validate" name="email" required>
                <label for="email">email</label>
              </div>
              
              <div class="input-field col s12">
                <input id="password" type="password" class="validate" name="password" required>
                <label for="password">Password</label>
              </div>
              
              <div class="input-field col s12">
                <input id="password" type="password" class="validate" name="password" required>
                <label for="password">Password</label>
              </div>
              
              
              <div class="input-field col s12">
                <input id="hora" type="time" class="validate" name="hora" required>
                <label for="hora">Hora</label>
              </div>
              <div class="input-field col s12">
                <input id="pasajeros" type="number" class="validate" name="pasajeros" required>
                <label for="pasajeros">Pasajeros</label>
              </div>

              
              <button class="btn center" name="boton" value="masViajes">Añadir viaje</button>
              
                
              
              
          </form>
          <p class="red text">${requestScope.msg}</p>
      </div>
    </div>
  </div>
            


<%@include file="templates/footer.jsp" %>