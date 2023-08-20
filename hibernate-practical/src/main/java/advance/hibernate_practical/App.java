package advance.hibernate_practical;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App
{
    public static void main( String[] args ) throws IOException {
    	System.out.println("Hello");
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        //Creating Student Object
        Student a=new Student();
        a.setId(55);
        a.setName("Muhammad Junaid");
        a.setCity("Peshawar");

        //Creating Address Object
        Address ad=new Address();
        ad.setStreet("Street 14");
        ad.setCity("Peshawar");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(3.2);

        //Reading Image
        FileInputStream fis= new FileInputStream("src/main/ik.jpeg");
        byte data[]=new byte[fis.available()];
        fis.read();
        ad.setImage(data);

        System.out.println(a);
        System.out.println(ad);
        Session session=factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        session.save(ad);
        tx.commit();

        session.close();
        System.out.println("Terminated");
    }
}


