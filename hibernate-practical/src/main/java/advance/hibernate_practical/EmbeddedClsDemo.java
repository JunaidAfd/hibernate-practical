package advance.hibernate_practical;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedClsDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();
        Student b=new Student();
        b.setId(2);
        b.setName("Bee");
        b.setCity("Peshawar");
        Certificate certificate=new Certificate();
        certificate.setCourse("SpringBoot");
        certificate.setDuration("6 months");
        b.setCert(certificate);

        Transaction tx=session.beginTransaction();
        session.save(b);

        tx.commit();
        session.close();
        factory.close();
    }
}
