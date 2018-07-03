/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controladores;

import cl.beans.ServicioBeanLocal;
import cl.entidades.Chofer;
import directorio.Hash;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebita
 */
@WebServlet(name = "controlServlet", urlPatterns = {"/control.do"})
public class controlServlet extends HttpServlet {

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
