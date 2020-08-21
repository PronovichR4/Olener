package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.service.ServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.pronovich.controller.RequestParameterName.*;

public class Authenticator implements Command {

    private final Logger logger = LoggerFactory.getLogger(Authenticator.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(REQ_PARAM_LOGIN);
        String password = req.getParameter(REQ_PARAM_PASSWORD);
        Customer customer = ServiceProvider.getINSTANCE().getCustomerService().autorize(login, password);
        if (customer == null) {
            logger.info("No matches for login and password");
            resp.sendRedirect("/authentication");
        } else {
            logger.info(customer.getLogin() + " succesfull login");
            req.getSession().setAttribute(REQ_PARAM_CUSTOMER, customer);
            resp.sendRedirect("/olener");
        }
    }
}
