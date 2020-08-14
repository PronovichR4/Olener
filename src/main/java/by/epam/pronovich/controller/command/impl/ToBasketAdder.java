package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_BASKET;

public class ToBasketAdder implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        Integer prodId = Integer.valueOf(req.getParameter("productId"));
        HttpSession session = req.getSession();
        List<Product> basket = (ArrayList<Product>) session.getAttribute(REQ_PARAM_BASKET);
        if (basket == null) {
            basket = new ArrayList<>();
        }
        basket.add(ServiceProvider.getINSTANCE().getProductService().getById(prodId));
        session.setAttribute(REQ_PARAM_BASKET, basket);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
