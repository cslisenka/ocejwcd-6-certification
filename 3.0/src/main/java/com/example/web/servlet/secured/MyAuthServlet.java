package com.example.web.servlet.secured;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ServletSecurity
@WebServlet("/auth")
public class MyAuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("HttpServletRequest.authenticate(#) example");
        out.println("Before auth. User: " + req.getRemoteUser());
        // Механизм секьюрности контейнера начинает использоваться только после вызова authenticate, до этого ничего не проверяется
        // Если нажать "Cancel" на окошке для логина, то показывается страница ошибки (контент этой страницы не отображается)
        // Если мы залогинились с помощью контейнерной авторизации ранее, то на эту страницу мы заходим без проблем
        // В случае неуспешной аутентикации код продолжает выполняться, только пользователю отображается страница ошибки
        if (req.authenticate(resp)) {
            out.println("Successfully authenticated");
        } else {
            out.println("Authentication failed");
        }

        // Код всё равн
        System.out.println("After authenticate");

        out.println("After auth. User: " + req.getRemoteUser());
    }
}