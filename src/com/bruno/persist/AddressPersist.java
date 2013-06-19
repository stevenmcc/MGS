package com.bruno.persist;

import com.bruno.pojo.Address;
import com.google.appengine.api.datastore.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Address: bruno
 * Date: 15/06/13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class AddressPersist {
    public static void putAddress(Address address, String company){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(makeEntity(address, company));

        String s = "";
    }
    public static Address getAddress(String firstname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter addressFilter = new Query.FilterPredicate("firstname",Query.FilterOperator.EQUAL,firstname);
        Query q = new Query("Address").setFilter(addressFilter).setFilter(addressFilter);
        PreparedQuery pq = datastore.prepare(q);
        
        Address address = null;
        for (Entity result : pq.asIterable()) {
            address = makeAddress(result);
        }
        return address;
    }
    public static ArrayList<Address> getAllCompanyAddresss(String companyname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter addressFilter = new Query.FilterPredicate("company",Query.FilterOperator.EQUAL,companyname);
        Query q = new Query("Address").setFilter(addressFilter);
        PreparedQuery pq = datastore.prepare(q);
        ArrayList<Address> addresses =  new ArrayList<Address>();
        Address address = null;
        for (Entity result : pq.asIterable()) {
            address = makeAddress(result);
            addresses.add(address);
        }
        return addresses;
    }

    private static Entity makeEntity(Address address, String company){
        Entity inaddress = new Entity("Address");
        inaddress.setProperty("line1", address.getLine1());
        inaddress.setProperty("line2", address.getLine2());
        inaddress.setProperty("city", address.getCity());
        inaddress.setProperty("postcode", address.getPostcode());
        inaddress.setProperty("company", company);
        return inaddress;
    }
    private static Address makeAddress(Entity entity){
        String fname = (String) entity.getProperty("firstname");
        String lname = (String) entity.getProperty("lastname");
        String phone = (String) entity.getProperty("phone");
        String email = (String) entity.getProperty("email");
        Address address = new Address(fname,lname,phone,email);
        return address;
    }
}
