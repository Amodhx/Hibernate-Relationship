package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Laptop;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        /*methanadi eka query ekak execute wela student table eke & laptop table eke values ganna
        * puluwan meka Eager fetiching   */
        Student student = session.get(Student.class, 1);
        List<Laptop> laptops = student.getLaptops();
        System.out.println(laptops.size());
        System.out.println(student.getName());

    }
}