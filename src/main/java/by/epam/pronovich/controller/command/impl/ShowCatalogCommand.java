package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Catalog;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_CATALOG;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_ID;

public class ShowCatalogCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Catalog> catalog = null;
        String id = req.getParameter(REQ_PARAM_ID);
        if (id == null) {
            catalog = getMainCategory(req);
        } else {
            catalog = getCategoryByParentId(req, id);
        }
        if (catalog.isEmpty()) {
            resp.sendRedirect("/product?categoryId=" + id);
        } else {
            req.getRequestDispatcher(JspPathUtil.get("catalog")).forward(req, resp);
        }
    }

    private List<Catalog> getCategoryByParentId(HttpServletRequest req, String id) {
        List<by.epam.pronovich.model.Catalog> catalog;
        catalog = ServiceProvider.getINSTANCE().getCatalogService().getCategorysByParentId(Integer.valueOf(id));
        req.setAttribute(REQ_PARAM_CATALOG, catalog);
        return catalog;
    }

    private List<Catalog> getMainCategory(HttpServletRequest req) {
        List<by.epam.pronovich.model.Catalog> catalog;
        catalog = ServiceProvider.getINSTANCE().getCatalogService().getAllMainCategory();
        req.setAttribute(REQ_PARAM_CATALOG, catalog);
        return catalog;
    }
}
