/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorjspservlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jstuart15
 */
@WebServlet(name = "FlooringServlet", urlPatterns = {"/FlooringServlet"})
public class FlooringServlet extends HttpServlet {

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

        double laborCostPerHour = 86;
        double installRateSfPerHour = 20;
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));
        double costPsf = Double.parseDouble(request.getParameter("costpsf"));

        double matCost = 0;
        double laborCost = 0;
        double totalCost = 0;
        
        matCost = width * height * costPsf;
        laborCost = ((width * height)/installRateSfPerHour) * laborCostPerHour;
        
        totalCost = matCost + laborCost;
        
        request.setAttribute("width", width);
        request.setAttribute("height", height);
        request.setAttribute("costPsf", costPsf);
        request.setAttribute("matCost", matCost);
        request.setAttribute("laborCost", laborCost);
        request.setAttribute("totalCost", totalCost);
        
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
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
