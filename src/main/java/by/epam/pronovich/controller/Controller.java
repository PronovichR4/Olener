package by.epam.pronovich.controller;


import by.epam.pronovich.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/basket", "/adminpage", "/olener", "/search", "/registration", "/product",
        "/productInfo", "/catalog", "/authentication", "/profile", "/review"})
public class Controller extends HttpServlet {

    private static final CommandProvider commandProvider = CommandProvider.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }

    private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = getCommandName(req);
        Command command = commandProvider.getCommand(commandName);
        command.execute(req, resp);
    }

    private String getCommandName(HttpServletRequest request) {
        String commandName = null;
        String command = request.getParameter("command");
        if (command != null) {
            commandName = command;
        } else {
            commandName = request.getRequestURI().substring(1);
        }
        return commandName;
    }
}
