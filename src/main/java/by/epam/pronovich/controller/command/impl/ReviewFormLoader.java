package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_ID;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_PROD_ID;

public class ReviewFormLoader implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(REQ_PARAM_PROD_ID, req.getParameter(REQ_PARAM_ID));
        req.getRequestDispatcher(JspPathUtil.get("add-review")).forward(req, resp);
    }
}
