package com.bruno.servlets;

import com.bruno.persist.AddressPersist;
import com.bruno.persist.CompanyPersist;
import com.bruno.persist.UserPersist;
import com.bruno.pojo.Address;
import com.bruno.pojo.Company;
import com.bruno.pojo.User;
import com.bruno.utils.Password;
import com.google.appengine.api.datastore.Key;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 **/

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Company Details
        String cname = request.getParameter("cname");
        String cphone = request.getParameter("cphone");
        Company company = new Company(cname,cphone);

        //User credentials
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        String pass = Password.getSaltedHash(pword);
        //Contact Credentials
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String mphone = request.getParameter("mphone");
        String email = request.getParameter("email");
        User user = new User(uname,pass,"standard",fname,lname,mphone,email);

        //Address credentials
        String line1 = request.getParameter("line1");
        String line2 = request.getParameter("line2");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        String addname = request.getParameter("addressname");
        Address address = new Address(line1,line2,city,postcode,addname);

        Company c1 = CompanyPersist.getCompany(company.getName());
        User u1 = UserPersist.getUser(user.getUsername());
        Address a1 = AddressPersist.getAddress(address.getName());

        String message = "";

        if(c1!=null){
            message+="Company name is already registered.\n";
        }
        if(u1!=null){
            message+="Username is already registered.\n";
        }
        if(a1!=null){
            message+="Address name is already registered.\n";
        }

        if(!message.equals("")){
            response.sendError(501,message);
            response.getWriter().flush();
            response.getWriter().close();
        }
        else{
            Key key = CompanyPersist.putCompany(company);
            UserPersist.putUser(user,key);
            AddressPersist.putAddress(address,key);

            response.getWriter().write("OK");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
