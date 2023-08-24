package advance.states;

import advance.hibernate_practical.Certificate;
import advance.hibernate_practical.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StatesDemo {
    public static void main(String[] args) {
        //Transient,persistent, Detached, Removed
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student=new Student();
        student.setId(515);
        student.setName("Afridi");
        student.setCity("Islamabad");
        student.setCert(new Certificate("Java","2 month"));
        //Transient State until now

        Session session=factory.openSession();
        Transaction txt= session.beginTransaction();
        session.save(student); //persistant state, with session and database
        student.setName("Junaid Afridi");

        txt.commit();
        session.close();

        student.setId(555); //detached state

        factory.close();
    }
}
