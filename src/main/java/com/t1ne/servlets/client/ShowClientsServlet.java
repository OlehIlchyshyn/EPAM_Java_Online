package com.t1ne.servlets.client;

import com.t1ne.dao.MySQLClientDAO;
import com.t1ne.model.users.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/clients")
public class ShowClientsServlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(ShowClientsServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MySQLClientDAO dao = new MySQLClientDAO();
        List<Client> clients;
        logger.error("Got clients info");
        logger.warn("Got clients info");
        logger.info("Got clients info");
        logger.info("Got clients info");
        logger.info("Got clients info");
        logger.info("Got clients info");
        logger.info("Got clients info");
        clients = dao.getAll();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("/WEB-INF/view/client/show.jsp").forward(req, resp);
    }
}
