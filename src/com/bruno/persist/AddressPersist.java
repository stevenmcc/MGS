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
    public static Key putAddress(Address address, Key company){
        Address add = getAddress(address.getLine1());
        if(add==null){
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            return datastore.put(makeEntity(address, company));
        }
        else{
            return null;
        }

    }
    public static Address getAddress(String addressname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter addressFilter = new Query.FilterPredicate("addressname",Query.FilterOperator.EQUAL,addressname);
        Query q = new Query("Address").setFilter(addressFilter);
        PreparedQuery pq = datastore.prepare(q);

        for (Entity result : pq.asIterable()) {
            return makeAddress(result);
        }
        return null;
                
    }
    public static ArrayList<Address> getAllCompanyAddresss(Key companyname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Address").setAncestor(companyname).addSort("city", Query.SortDirection.DESCENDING);;
        PreparedQuery pq = datastore.prepare(q);
        ArrayList<Address> addresses =  new ArrayList<Address>();
        Address address = null;
        for (Entity result : pq.asIterable()) {
            address = makeAddress(result);
            addresses.add(address);
        }
        return addresses;
    }

    private static Entity makeEntity(Address address, Key company){
        Entity inaddress = new Entity("Address", company);
        inaddress.setProperty("addressname", address.getName());
        inaddress.setProperty("line1", address.getLine1());
        inaddress.setProperty("line2", address.getLine2());
        inaddress.setProperty("city", address.getCity());
        inaddress.setProperty("postcode", address.getPostcode());
        return inaddress;
    }
    private static Address makeAddress(Entity entity){
        String fname = (String) entity.getProperty("line1");
        String lname = (String) entity.getProperty("line2");
        String phone = (String) entity.getProperty("city");
        String email = (String) entity.getProperty("postcode");
        String addressname = (String) entity.getProperty("addressname");
        Address address = new Address(fname,lname,phone,email,addressname);
        return address;
    }
}
