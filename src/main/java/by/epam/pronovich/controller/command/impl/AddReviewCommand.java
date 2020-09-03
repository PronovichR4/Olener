package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.pronovich.controller.RequestParameterName.*;

public class AddReviewCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer cutomer = (Customer) req.getSession().getAttribute(REQ_PARAM_CUSTOMER);
        String productId = req.getParameter(REQ_PARAM_ID);
        ServiceProvider.getINSTANCE().getReviewService().add(Review.builder()
                .title(req.getParameter(REQ_PARAM_TITLE))
                .text(req.getParameter(REQ_PARAM_TEXT))
                .customer(cutomer)
                .product(Product.builder().id(Integer.valueOf(productId)).build())
                .build());
        resp.sendRedirect("/review?id=" + productId);
    }
}
