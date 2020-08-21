package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_COUNTER_REVIEW;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_PRODUCT;

public class ProductInfoShower implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = ServiceProvider.getINSTANCE().getProductService().getById(Integer.valueOf(id));
        req.setAttribute(REQ_PARAM_PRODUCT, product);
        req.setAttribute(REQ_PARAM_COUNTER_REVIEW, getCountOfReview(id));
        req.getRequestDispatcher(JspPathUtil.get("product-info")).forward(req, resp);
    }

    private int getCountOfReview(String id) {
        return ServiceProvider.getINSTANCE().getReviewService().getByProductId(Integer.valueOf(id)).size();
    }
}
