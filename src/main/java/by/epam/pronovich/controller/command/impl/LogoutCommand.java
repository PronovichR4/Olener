package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/olener");
    }
}
