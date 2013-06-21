package com.bruno.persist;

import com.bruno.pojo.Company;
import com.bruno.pojo.User;
import com.google.appengine.api.datastore.*;



/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class UserPersist {
    public static Key putUser(User user, Key company){

        User user1 = getUser(user.getUsername());
        if(user1==null){
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            return datastore.put(makeEntity(user, company));

        }
        else{
            return null;
        }
    }
    public static User getUser(String username){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter userFilter = new Query.FilterPredicate("username",Query.FilterOperator.EQUAL,username);
        Query q = new Query("User").setFilter(userFilter);
        PreparedQuery pq = datastore.prepare(q);


        for (Entity result : pq.asIterable()) {
           return makeUser(result);
        }
        return null;
    }

    private static Entity makeEntity(User user,Key company){
        Entity inuser = new Entity("User",company);
        inuser.setProperty("username", user.getUsername());
        inuser.setProperty("password", user.getPassword());
        inuser.setProperty("userrole", user.getUserrole());
        inuser.setProperty("firstname", user.getFname());
        inuser.setProperty("lastname", user.getLname());
        inuser.setProperty("phone", user.getPhone());
        inuser.setProperty("email", user.getEmail());
        return inuser;
    }
    private static User makeUser(Entity entity){
        String uname = (String) entity.getProperty("username");
        String password = (String) entity.getProperty("password");
        String userrole = (String) entity.getProperty("userrole");
        String fname = (String) entity.getProperty("firstname");
        String lname = (String) entity.getProperty("lastname");
        String phone = (String) entity.getProperty("phone");
        String email = (String) entity.getProperty("email");
        return new User(uname,password,userrole,fname,lname,phone,email);
    }
}
