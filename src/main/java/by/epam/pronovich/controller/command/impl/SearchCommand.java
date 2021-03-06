package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        List<Product> products = ServiceProvider.getINSTANCE().getProductService().search(text);
        req.setAttribute("products", products);
        req.getRequestDispatcher(JspPathUtil.get("search")).forward(req, resp);
    }
}
