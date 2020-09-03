package by.epam.pronovich.controller;

import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.controller.command.CommandName;
import by.epam.pronovich.controller.command.impl.*;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static by.epam.pronovich.controller.command.CommandName.*;

public class CommandProvider {

    @Getter
    private final static CommandProvider INSTANCE = new CommandProvider();

    private final Map<CommandName, Command> commandBox = new HashMap<>();

    private CommandProvider() {
        commandBox.put(WRONG_REQUEST, new WrongRequest());
        commandBox.put(LOGOUT, new LogoutCommand());
        commandBox.put(USER_CHANGE_INFO_FORM, new ChangeUserInfoCommand());
        commandBox.put(SAVE_USER_CHANGES, new ChangeUserCommand());
        commandBox.put(ADD_PRODUCT_FORM, new AddProductFormCommand());
        commandBox.put(ADD_PRODUCT, new AddProductCommand());
        commandBox.put(CHANGE_PRODUCT_INFO_FORM, new ChangeProductFormCommand());
        commandBox.put(SAVE_PRODUCT_CHANGES, new ChangeProductCommand());
        commandBox.put(AUTHENTICATOR, new AuthenticationCommand());
        commandBox.put(AUTHENTICATION, new AuthenticationFormCommand());
        commandBox.put(REGISTRATOR, new RegistrationCommand());
        commandBox.put(REVIEW_FORM, new AddReviewFormCommand());
        commandBox.put(ADD_REVIEW, new AddReviewCommand());
        commandBox.put(CATALOG, new ShowCatalogCommand());
        commandBox.put(REVIEW, new ShowReviewCommand());
        commandBox.put(PRODUCTINFO, new ShowProductInfoCommand());
        commandBox.put(OLENER, new StartPageCommand());
        commandBox.put(PRODUCT, new ShowProductsCommand());
        commandBox.put(LOKALIZATION, new Lokalization());
        commandBox.put(HISTORY, new ShowHistoryCommand());
        commandBox.put(ADD_TO_BASKET, new AddToBasketCommand());
        commandBox.put(DELETE_FROM_BASKET, new DeleteFromBasketCommand());
        commandBox.put(CHECKOUT, new CheckoutOrderCommand());
        commandBox.put(UPDATE_STATUS, new StatusUpdating());
        commandBox.put(SHOW_ORDERS, new ShowOrdersCommand());
        commandBox.put(SEARCH, new SearchCommand());
        commandBox.put(REGISTRATION, new RegistrationFormCommand());
        commandBox.put(PROFILE, new ProfileCommand());
        commandBox.put(BASKET, new BasketCommand());
        commandBox.put(ADMINPAGE, new AdminPageCommand());
    }

    public Command getCommand(String name) {
        Command command = null;
        try {
            CommandName commandName = valueOf(name.toUpperCase());
            command = commandBox.get(commandName);
        } catch (Exception e) {
            command = commandBox.get(WRONG_REQUEST);
        }
        return command;
    }
}
