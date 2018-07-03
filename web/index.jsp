

<%@include file="templates/header.jsp" %>



  <div class="row">
    <div class="col s12 m10 offset-m1">
      <div class="card-panel light-blue lighten-4">
          <h3 class="center white-text">Iniciar sesión</h3>
          <form method="POST" action="control.do">
              
              <div class="input-field col s12">
                <input id="rut" type="text" class="validate" name="rut" required>
                <label for="rut">Rut</label>
              </div>
              <div class="input-field col s12">
                <input id="clave" type="password" class="validate" name="clave" required>
                <label for="clave">Password</label>
              </div>
              
              <button class="btn center" name="boton" value="login">Entrar</button>
              
                
              
              
          </form>
          <p class="red text">${requestScope.msg}</p>
      </div>
    </div>
  </div>
            


<%@include file="templates/footer.jsp" %>