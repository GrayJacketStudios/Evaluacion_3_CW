
<%@include file="templates/header.jsp" %>
<%@include file="middleware/checkSesion.jsp" %>

  <div class="row">
    <div class="col s12 m10 offset-m1">
      <div class="card-panel light-blue lighten-4">
          <h3 class="center white-text">Añadir un viaje</h3>
          <form method="POST" action="control.do">
              
              <div class="input-field col s12">
                <input id="destino" type="text" class="validate" name="destino" required>
                <label for="destino">Destino</label>
              </div>
              
              <div class="input-field col s12">
                <input id="fecha" type="date" class="validate" name="fecha" required>
                <label for="fecha">Fecha</label>
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