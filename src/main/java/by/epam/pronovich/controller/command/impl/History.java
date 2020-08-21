package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Customer;
import by.epam.pronovich.model.ProductBooking;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_CUSTOMER;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_PRODUCT_BOOKINGS;

public class History implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession().getAttribute(REQ_PARAM_CUSTOMER);
        List<Booking> bookingList = ServiceProvider.getINSTANCE().getBookingService().getByCustomer(customer);
        List<ProductBooking> productBookings = ServiceProvider.getINSTANCE().getProductBookingService().getByBookings(bookingList);
        req.setAttribute(REQ_PARAM_PRODUCT_BOOKINGS, productBookings);
        req.getRequestDispatcher(JspPathUtil.get("history-booking")).forward(req, resp);
    }
}
