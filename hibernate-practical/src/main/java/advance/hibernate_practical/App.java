package advance.hibernate_practical;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
    	System.out.println("Hello");
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	System.out.println(factory);

        System.out.println(factory.isClosed());

    }
}


