package ru.clinicPetWeb.servlets;

import ru.clinicPetWeb.store.ClientCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientSearchServlet extends HttpServlet {

    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("found", this.CLIENT_CACHE.valuesFound());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/client/SearchClient.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idClient = request.getParameter("idClient");
        String clientName = request.getParameter("clientName");
        String petName = request.getParameter("petName");
        String petAge = request.getParameter("petAge");

        this.CLIENT_CACHE.find(idClient, clientName, petName, petAge);

        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/client/search"));
    }

}
