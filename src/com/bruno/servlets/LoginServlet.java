package com.bruno.servlets;

import com.bruno.persist.UserPersist;
import com.bruno.pojo.User;
import com.bruno.utils.Password;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.PasswordAuthentication;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        User user = UserPersist.getUser(username);
        boolean match=Password.check(password,user.getPassword());
        if(match){
            request.getSession().setAttribute("user",user);
            response.getWriter().write("OK");
            response.getWriter().flush();
            response.getWriter().close();

        }
        else{
            response.sendError(501,"User name or password to not match.");
        }
    }
}
