package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Brand;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_BRANDS;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_CATALOG;

public class ProductAdderForm implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Catalog> catalogList = ServiceProvider.getINSTANCE().getCatalogService().getAllSubCategory();
        List<Brand> brands = ServiceProvider.getINSTANCE().getBrandService().getAll();
        req.setAttribute(REQ_PARAM_CATALOG, catalogList);
        req.setAttribute(REQ_PARAM_BRANDS, brands);
        req.getRequestDispatcher(JspPathUtil.get("add-product")).forward(req, resp);
    }
}
