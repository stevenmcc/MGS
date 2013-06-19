package com.bruno.servlets;

import com.bruno.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 19/06/13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class LogCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("lc check");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user==null){
            response.sendError(501, "Session Expired.");
        }
        else {
            response.getWriter().write(user.getUsername());
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
