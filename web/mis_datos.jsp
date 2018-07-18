
<%@page import="com.mysql.jdbc.Blob"%>
<%@include file="templates/header.jsp" %>
<%@include file="middleware/checkSesion.jsp" %>



    
  <div class="row">
    <div class="col s12 m10 offset-m1">
      <div class="card-panel light-blue lighten-4">
          <h3 class="center white-text">Modificar perfil</h3>

          
          <form method="POST" action="control.do" enctype="multipart/form-data">
              
              
              <mitag:tagImg array="${sessionScope.user.foto}" tam="50"/>
              
              <div class="input-field col s12">
                <input id="rut" type="text" class="validate" name="rut" required  value="${sessionScope.user.rut}">
                <label for="rut">Rut</label>
              </div>
              
              <div class="input-field col s12">
                <input id="nombre" type="text" class="validate" name="nombre" required value="${sessionScope.user.nombre}">
                <label for="nombre">Nombre</label>
              </div>
              
              <div class="input-field col s12">
                <input id="telefono" type="text" class="validate" name="telefono" required value="${sessionScope.user.telefono}">
                <label for="telefono">telefono</label>
              </div>
              
              
              <div class="input-field col s12">
                <input id="email" type="text" class="validate" name="email" required value="${sessionScope.user.email}">
                <label for="email">email</label>
              </div>
              
              <div class="input-field col s12">
                <input id="password" type="password" class="validate" name="password" >
                <label for="password">Nueva contraseña</label>
              </div>
              
              <div class="input-field col s12">
                <input id="password2" type="password" class="validate" name="password2" >
                <label for="password2">Confirmar contraseña</label>
              </div>
              
              <div class="input-field col s12">
                <input id="foto" type="file" class="validate" name="foto" >
                <label for="foto">Foto</label>
              </div>
              

              
              <button class="btn center" name="boton" value="guardaDatos">Actualizar info</button>
              
                
              
              
          </form>
          <p class="red text">${requestScope.msg}</p>
      </div>
    </div>
  </div>
            


<%@include file="templates/footer.jsp" %>