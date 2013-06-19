package com.bruno.persist;

import com.bruno.pojo.Company;
import com.google.appengine.api.datastore.*;

/**
 * Created with IntelliJ IDEA.
 * Company: bruno
 * Date: 15/06/13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class CompanyPersist {
    public static void putCompany(Company company){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(makeEntity(company));
    }
    public static Company getCompany(String companyname){
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query.Filter companyFilter = new Query.FilterPredicate("companyname",Query.FilterOperator.EQUAL,companyname);
        Query q = new Query("Company").setFilter(companyFilter);
        PreparedQuery pq = datastore.prepare(q);

        Company company = null;
        for (Entity result : pq.asIterable()) {
            company = makeCompany(result);
        }
        return company;
    }

    private static Entity makeEntity(Company company){
        Entity incompany = new Entity("Company");
        incompany.setProperty("companyname", company.getName());
        incompany.setProperty("companyphone", company.getPhone());
        return incompany;
    }
    private static Company makeCompany(Entity entity){
        String cname = (String) entity.getProperty("companyname");
        String cphone= (String) entity.getProperty("companyphone");
        Company company = new Company(cname,cphone);
        return company;
    }
}
