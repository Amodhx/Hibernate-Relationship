package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Laptop;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session  =  FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        // developing

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setModel("ACER");
        Student student = new Student();
        student.setId(1);
        student.setName("AMODH");
        student.setAddress("KALUTHRA");
        student.setLaptop(laptop);

        session.save(laptop);
        session.save(student);

        transaction.commit();
        session.close();
    }
}