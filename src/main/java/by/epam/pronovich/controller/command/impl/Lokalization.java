package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_LANGUAGE;

public class Lokalization implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String language = req.getParameter(REQ_PARAM_LANGUAGE);
        req.getSession().setAttribute(REQ_PARAM_LANGUAGE, language);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
