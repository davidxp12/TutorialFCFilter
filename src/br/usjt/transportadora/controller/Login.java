/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.usjt.transportadora.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rogerio
 */
public class Login extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new RuntimeException("Operação não permitida!!!");
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = (String) request.getParameter("j_username");
        String senha = (String) request.getParameter("j_password");
        
        if (usuario.equals("user01") && senha.equals("123")) {
            request.getSession().setAttribute("login", usuario);

            response.sendRedirect("protected/fc");
        } else {
            response.getWriter().print("Usuário/Senha inválido");
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
