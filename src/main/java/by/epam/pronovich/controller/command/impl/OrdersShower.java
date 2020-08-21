package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.BookingStatus;
import by.epam.pronovich.model.ProductBooking;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_PRODUCT_BOOKINGS;
import static by.epam.pronovich.controller.RequestParameterName.REQ_PARAM_STATUS;

public class OrdersShower implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Booking> bookingList = ServiceProvider.getINSTANCE().getBookingService().getAll();
        List<ProductBooking> productBookings = ServiceProvider.getINSTANCE().getProductBookingService().getByBookings(bookingList);
        req.setAttribute(REQ_PARAM_PRODUCT_BOOKINGS, productBookings);

        BookingStatus[] values = BookingStatus.values();
        req.setAttribute(REQ_PARAM_STATUS, values);

        req.getRequestDispatcher(JspPathUtil.get("orders")).forward(req, resp);
    }
}
