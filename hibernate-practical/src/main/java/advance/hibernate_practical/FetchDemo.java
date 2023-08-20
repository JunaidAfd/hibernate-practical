package advance.hibernate_practical;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();
        //transaction needed only when we need to save the data.
        //Student student=(Student) session.get(Student.class,55);
        Student student=(Student) session.load(Student.class,55);//uses proxy objects, throws exception
        System.out.println(student);

        session.close();
        factory.close();
    }
}
