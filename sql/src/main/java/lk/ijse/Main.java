package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        /*HQL using (Hibernate Query language)*/
        List fromStudent = session.createQuery("from Student").getResultList();
        System.out.println(fromStudent.size());

        /*SQL using*/
        List resultList = session.createNativeQuery("select  * from Student").getResultList();
        System.out.println(resultList.size());
        transaction.commit();
        session.close();
    }
}