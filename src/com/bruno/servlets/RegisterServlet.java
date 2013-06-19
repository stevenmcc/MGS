package com.bruno.servlets;

import com.bruno.persist.AddressPersist;
import com.bruno.persist.CompanyPersist;
import com.bruno.persist.ContactPersist;
import com.bruno.persist.UserPersist;
import com.bruno.pojo.Address;
import com.bruno.pojo.Company;
import com.bruno.pojo.Contact;
import com.bruno.pojo.User;
import com.bruno.utils.Password;

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
        boolean success = false;
        //Company Details
        String cname = request.getParameter("cname");
        String cphone = request.getParameter("cphone");
        Company company = new Company(cname,cphone);
        CompanyPersist.putCompany(company);

        //User credentials
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        String pass = null;
        try {
            pass = Password.getSaltedHash(pword);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        User user = new User(uname,pass,"standard");
        success=UserPersist.putUser(user,company.getName());

        //Contact Credentials
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String mphone = request.getParameter("mphone");
        String email = request.getParameter("email");
        Contact contact = new Contact(fname,lname,mphone,email);
        ContactPersist.putContact(contact,company.getName());

        //Address credentials
        String line1 = request.getParameter("line1");
        String line2 = request.getParameter("line2");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        Address address = new Address(line1,line2,city,postcode);
        AddressPersist.putAddress(address, company.getName());

        //On error
        if(success){
            response.getWriter().write("OK");
            response.getWriter().flush();
            response.getWriter().close();

        }
        else{
            response.sendError(501,"User name already exists.");
            response.getWriter().flush();
            response.getWriter().close();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
