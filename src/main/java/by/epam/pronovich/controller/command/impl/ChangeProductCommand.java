package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.pronovich.controller.RequestParameterName.*;

public class ChangeProductCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = getProductFrom(req);
        ServiceProvider.getINSTANCE().getProductService().update(product);
        resp.sendRedirect("/productInfo?id=" + product.getId());
    }

    private Product getProductFrom(HttpServletRequest req) {
        return Product.builder()
                .id(Integer.valueOf(req.getParameter("productId")))
                .catalog(Catalog.builder()
                        .id(Integer.valueOf(req.getParameter(REQ_PARAM_CATALOG_ID))).build())
                .brand(Brand.builder()
                        .id(Integer.valueOf(req.getParameter(REQ_PARAM_BRAND_ID))).build())
                .model(req.getParameter(REQ_PARAM_MODEL))
                .description(req.getParameter(REQ_PARAM_DESCRIPTION))
                .price(Double.valueOf(req.getParameter(REQ_PARAM_PRICE)))
                .img(req.getParameter(REQ_PARAM_IMAGE))
                .quantity(Integer.valueOf(req.getParameter(REQ_PARAM_QUANTITY)))
                .build();
    }
}
