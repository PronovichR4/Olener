package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.RequestParameterName;
import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_BASKET;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_PROD_ID;

public class FromBasketDeleter implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        String productId = req.getParameter(REQ_PARAM_PROD_ID);
        HttpSession session = req.getSession();
        List<Product> basket = (ArrayList<Product>) session.getAttribute(REQ_PARAM_BASKET);
        basket.stream().filter(it -> it.getId().equals(Integer.valueOf(productId)))
                .findFirst().map(i -> {
            basket.remove(i);
            return i;
        });
        req.getSession().setAttribute(REQ_PARAM_BASKET, basket);
        servletContext.getRequestDispatcher(JspPathUtil.get("basket")).forward(req, resp);
    }
}
