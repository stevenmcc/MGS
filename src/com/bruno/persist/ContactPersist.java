package com.bruno.persist;

import com.bruno.pojo.Contact;
import com.google.appengine.api.datastore.*;

/**
 * Created with IntelliJ IDEA.
 * Contact: bruno
 * Date: 15/06/13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class ContactPersist {
    public static void putContact(Contact contact, String company){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(makeEntity(contact, company));
    }
    public static Contact getContact(String firstname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter contactFilter = new Query.FilterPredicate("firstname",Query.FilterOperator.EQUAL,firstname);
        Query q = new Query("Contact").setFilter(contactFilter).setFilter(contactFilter);
        PreparedQuery pq = datastore.prepare(q);
        
        Contact contact = null;
        for (Entity result : pq.asIterable()) {
            contact = makeContact(result);
        }
        return contact;
    }
    public static Contact getAllCompanyContacts(String companyname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter contactFilter = new Query.FilterPredicate("company",Query.FilterOperator.EQUAL,companyname);
        Query q = new Query("Contact").setFilter(contactFilter);
        PreparedQuery pq = datastore.prepare(q);

        Contact contact = null;
        for (Entity result : pq.asIterable()) {
            contact = makeContact(result);
        }
        return contact;
    }

    private static Entity makeEntity(Contact contact, String company){
        Entity incontact = new Entity("Contact");
        incontact.setProperty("firstname", contact.getFname());
        incontact.setProperty("lastname", contact.getLname());
        incontact.setProperty("phone", contact.getPhone());
        incontact.setProperty("email", contact.getEmail());
        incontact.setProperty("company", company);
        return incontact;
    }
    private static Contact makeContact(Entity entity){
        String fname = (String) entity.getProperty("firstname");
        String lname = (String) entity.getProperty("lastname");
        String phone = (String) entity.getProperty("phone");
        String email = (String) entity.getProperty("email");
        Contact contact = new Contact(fname,lname,phone,email);
        return contact;
    }
}
