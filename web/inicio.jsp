

<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.beans.ServicioBeanLocal"%>
<%@include file="templates/header.jsp" %>

<%!private ServicioBeanLocal servicio; %>
<%
  InitialContext ctx=new InitialContext();
  servicio=(ServicioBeanLocal)ctx.lookup("java:global/Viajes/ServicioBean!cl.beans.ServicioBeanLocal");
%>
<c:set var="viajes" scope="page" value="<%=servicio.getViajes()%>"/>



  <div class="row">
    <div class="col s12 m10 offset-m1">
      <div class="card-panel light-blue lighten-4">
          <h3 class="center white-text">Viajes</h3>
          <table>
              <tr>
                  <th>ID</th><th>Chofer</th><th>Destino</th><th>Fecha</th><th>Hora</th><th>N° de pasajeros</th>
              </tr>
              <c:forEach items="${pageScope.viajes}" var="v" >
                                    <tr>
                                        <td>${v.idViaje}</td>
                                        <td>${v.rutChofer.nombre}</td>
                                        <td>${v.destino}</td>
                                        <td><fmt:formatDate value="${v.fecha}" pattern="dd/MM/yyyy" /></td>
                                        <td><fmt:formatDate value="${v.hora}" pattern="HH:mm" /></td>
                                        <td>${v.cantidadPasajeros}</td>
                                        
                                    </tr>
              </c:forEach>
          </table>
          
      </div>
    </div>
  </div>

<%@include file="templates/footer.jsp" %>