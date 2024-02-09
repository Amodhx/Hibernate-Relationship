package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Laptop;
import lk.ijse.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        session.beginTransaction();
        Student student = session.get(Student.class, 1);
        List<Laptop> laptops = student.getLaptops();
        /*query dekak execute  wela tamy meke values watenne mokdada lazy fetching meka */
        System.out.println(laptops.size());
        session.close();
    }
}