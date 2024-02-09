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

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        /*HQL using (Hibernate Query language)*/
        List fromStudent = session.createQuery("from Student").getResultList();
        System.out.println(fromStudent.size());

        int id = 4;
        String name = "Tharusha";
        String address = "Panadura";
        Laptop laptop1 = new Laptop(1,"HP");
        Student student = new Student(id,name,address,laptop1);
        String hql = "INSERT INTO Student (id, name, address,laptop) select ?1,?2,?3,?4 from Student ";
        Query query = session.createQuery(hql);
        query.setParameter(1,id);
        query.setParameter(2,name);
        query.setParameter(3,address);
        query.setParameter(4,laptop1);
        int i = query.executeUpdate();
        System.out.println("Values  "+ i);




        /*SQL using*/
        List resultList = session.createNativeQuery("select  * from Student").getResultList();
        System.out.println(resultList.size());
        transaction.commit();
        session.close();
    }
}