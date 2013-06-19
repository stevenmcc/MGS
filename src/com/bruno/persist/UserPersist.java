package com.bruno.persist;

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
    public static boolean putUser(User user, String company){

        User user1 = getUser(user.getUsername());
        if(user1.getUsername()==null){
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            datastore.put(makeEntity(user, company));
            return true;
        }
        else{
            return false;
        }
    }
    public static User getUser(String username){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter userFilter = new Query.FilterPredicate("username",Query.FilterOperator.EQUAL,username);
        Query q = new Query("User").setFilter(userFilter);
        PreparedQuery pq = datastore.prepare(q);

        User user = new User();
        for (Entity result : pq.asIterable()) {
            user = makeUser(result);
        }
        return user;
    }

    private static Entity makeEntity(User user,String company){
        Entity inuser = new Entity("User");
        inuser.setProperty("username", user.getUsername());
        inuser.setProperty("password", user.getPassword());
        inuser.setProperty("userrole", user.getUserrole());
        inuser.setProperty("company", company);
        return inuser;
    }
    private static User makeUser(Entity entity){
        String uname = (String) entity.getProperty("username");
        String password = (String) entity.getProperty("password");
        String userrole = (String) entity.getProperty("userrole");
        return new User(uname,password,userrole);
    }
}
