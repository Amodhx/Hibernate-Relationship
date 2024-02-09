package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Laptop;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Value;
import org.hibernate.query.Query;
import org.hibernate.query.QueryParameter;
import org.hibernate.sql.ast.tree.insert.Values;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        /*HQL using (Hibernate Query language)*/
        int id = 1;
        String name = "Tharusha";
        String address = "Panadura";

        /*HQL insert query*/
        Query query = session.createQuery("INSERT INTO Student (id, name, address) select ?1,?2,?3 from Student ");
        query.setParameter(1,id);
        query.setParameter(2,name);
        query.setParameter(3,address);
        int i = query.executeUpdate();
        System.out.println("Values  "+ i);

        /*get values to object list*/
        List<Objects> resultList1 = session.createQuery("select id,name from Student ").getResultList();
        System.out.println(resultList1.size());

        /*get values with condition*/
        Query query1 = session.createQuery("select id,name from Student  where id=?1");
        query1.setParameter(1,1);
        List<Objects> resultList2 = query1.getResultList();
        System.out.println(resultList2.size());


        /*SQL using*/
        List resultList = session.createNativeQuery("select  * from Student").getResultList();
        System.out.println(resultList.size());
        transaction.commit();
        session.close();
    }
}