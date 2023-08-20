package advance.hibernate_practical;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
    	System.out.println("Hello");
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Student a=new Student();
        a.setId(55);
        a.setName("Muhammad Junaid");
        a.setCity("Peshawar");

        System.out.println(a);
        Session session=factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();

        session.close();
    }
}


