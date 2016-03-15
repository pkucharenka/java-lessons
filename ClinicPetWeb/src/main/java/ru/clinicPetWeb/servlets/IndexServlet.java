package ru.clinicPetWeb.servlets;

import ru.clinicPetWeb.models.Client;
import ru.clinicPetWeb.models.Pet;
import ru.clinicPetWeb.store.ClientCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {

    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("clients", this.CLIENT_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        String clientName = req.getParameter("nameClient");
        String petType = req.getParameter("petType");
        String petName = req.getParameter("petName");
        String petSex = req.getParameter("petSex");
        String petAge = req.getParameter("petAge");
        this.CLIENT_CACHE.add(new Client(CLIENT_CACHE.generateId(), clientName,
                              new Pet(petType, petName, petSex, petAge))
        );
//        PrintWriter out = resp.getWriter();
//        out.print(
//                "<tr>" +
//                        "<td>" + clientName + "</td>" +
//                        "<td>" + petType + "</td>" +
//                        "<td>" + petName + "</td>" +
//                        "<td>" + petSex  + "</td>" +
//                        "<td>" + petAge  + "</td>" +
//                "</tr>"
//        );
    }
}