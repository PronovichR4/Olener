package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.*;

public class ReviewShower implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter(REQ_PARAM_ID);
        List<Review> reviews = ServiceProvider.getINSTANCE().getReviewService().getByProductId(Integer.valueOf(productId));
        req.setAttribute(REQ_PARAM_REVIEWS, reviews);
        req.setAttribute(REQ_PARAM_PROD_ID, productId);
        req.getRequestDispatcher(JspPathUtil.get("review")).forward(req, resp);
    }
}
