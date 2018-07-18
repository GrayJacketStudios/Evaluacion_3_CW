/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controladores;

import cl.beans.ServicioBeanLocal;
import cl.entidades.Chofer;
import static cl.entidades.Chofer_.foto;
import cl.entidades.Viaje;
import com.mysql.jdbc.Blob;
import directorio.Hash;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.metamodel.SingularAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Sebita
 */
@WebServlet(name = "controlServlet", urlPatterns = {"/control.do"})
@MultipartConfig(location = "/tmp",
                  fileSizeThreshold = 1024*1024,
                  maxFileSize = 1024*1024*5,
                  maxRequestSize = 1024*1024*5*5
                )
public class controlServlet extends HttpServlet {

    
    private SimpleDateFormat formatFecha = new SimpleDateFormat("yyy-MM-dd");
    private SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm");
    @EJB
    private ServicioBeanLocal servicioBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String boton = request.getParameter("boton");
       switch(boton){
           case "login":
               login(request, response);
               break;
           case "registrar":
               registrar(request, response);
               break;
           case "masViajes":
               añadeViaje(request, response);
               break;
           case "guardaDatos":
               guardaDatos(request, response);
               break;
       }
    }
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String rut = request.getParameter("rut");
         String clave = request.getParameter("clave");
         String errores = "";
         
        if(rut.isEmpty()){
            errores = "Debes ingresar el rut.<br>";
        }
        if(clave.isEmpty()){
            errores += "Debes ingresar una contraseña.<br>";
        }
        if(errores.equals("")){
            Chofer user = servicioBean.iniciarSesion(rut,clave);
            if(user != null){
                
                request.getSession().setAttribute("user", user);
                
                
                response.sendRedirect("inicio.jsp");
                return;
            }
            else{
                errores += "Usuario o contraseña incorrectos.<br>";
            }
        }
        System.out.println("Errores: "+errores);
        request.setAttribute("msg", errores);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        
    }
    
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
       String rut = request.getParameter("rut");
       String clave = request.getParameter("clave");
       String clave2 = request.getParameter("clave2");
       String correo = request.getParameter("correo");
       String errores = "";
       if(nombre.isEmpty()){
            errores = "Debes ingresar el nombre.<br>";
        }
       if(telefono.isEmpty()){
            errores += "Debes ingresar el telefono.<br>";
        }
       if(rut.isEmpty()){
            errores += "Debes ingresar el rut.<br>";
        }
       if(clave.isEmpty()){
            errores += "Debes ingresar la clave.<br>";
        }
       if(clave2.isEmpty()){
            errores += "Debes ingresar la confirmacion de la clave.<br>";
        }
       if(correo.isEmpty()){
            errores += "Debes ingresar el correo.<br>";
        }
       if(!clave.equals(clave2)){
           errores += "Las claves deben deben coincidir.";
       }
       
       
       if(errores.equals("")){
           if(servicioBean.buscarChofer(rut)== null){//podemos continuar, usuario no existe.
               Chofer user = new Chofer();
               user.setRut(rut);
               user.setNombre(nombre);
               user.setTelefono(telefono);
               user.setEmail(correo);
               user.setClave(Hash.md5(clave));
               
               servicioBean.guardar(user);
               request.setAttribute("msg", "Chofer añadido correctamente.");
               System.out.println("Chofer añadido correctamente.");
               
           }
           else{
               errores += "El Chofer ya esta registrado.";
               request.setAttribute("msg", errores);
           }
       }
       else{
           request.setAttribute("msg", errores);
           System.out.println("Errores: "+errores);
       }
       request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    
    
    
    protected void añadeViaje(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String destino = request.getParameter("destino");
       String fecha= request.getParameter("fecha");
       String hora = request.getParameter("hora");
       String pasajeros = request.getParameter("pasajeros");
       String errores = "";
       if(destino.isEmpty()){
            errores = "Debes ingresar el destino.<br>";
        }
       if(fecha.isEmpty()){
            errores += "Debes ingresar la fecha.<br>";
        }
       if(hora.isEmpty()){
            errores += "Debes ingresar la hora.<br>";
        }
       if(pasajeros.isEmpty()){
            errores += "Debes ingresar la cantidad de pasajeros.<br>";
        }
       
       
       
       if(errores.equals("")){
           try {
               Viaje viaje = new Viaje();
               viaje.setDestino(destino);
               viaje.setFecha(formatFecha.parse(fecha));
               viaje.setHora(formatHora.parse(hora));
               viaje.setCantidadPasajeros(Integer.parseInt(pasajeros));
               viaje.setRutChofer((Chofer) request.getSession().getAttribute("user"));
               
               servicioBean.guardar(viaje);
               request.setAttribute("msg", "Viaje añadido correctamente.");
               System.out.println("Viaje añadido correctamente.");
           } catch (ParseException ex) {
               Logger.getLogger(controlServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
               
       }
       else{
           request.setAttribute("msg", errores);
           System.out.println("Errores: "+errores);
       }
       request.getRequestDispatcher("masViajes.jsp").forward(request,response);
    }
    
    protected void guardaDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String rut = request.getParameter("rut");
       String nombre= request.getParameter("nombre");
       String telefono = request.getParameter("telefono");
       String email = request.getParameter("email");
       String pass1 = request.getParameter("password");
       String pass2 = request.getParameter("password2");
       
       
 InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("foto");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
       
       
       
       
    
               Chofer user = servicioBean.buscarChofer(rut);

               user.setRut(rut);
               user.setNombre(nombre);
               user.setTelefono(telefono);
               user.setEmail(email);
               if(!pass1.equals("")){
                   user.setClave(Hash.md5(pass1));
               }


               
               
               servicioBean.update(user);

               request.setAttribute("msg", "Usuario actualizado correctamente.");
                request.getRequestDispatcher("mis_datos.jsp").forward(request,response);

               
    }

    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
