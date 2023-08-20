package advance.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMappingDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Employee em1=new Employee();
        Employee em2=new Employee();

        em1.setEid(34);
        em1.setName("A");

        em2.setEid(35);
        em2.setName("B");

        Project p1=new Project();
        Project p2=new Project();

        p1.setPid(45);
        p1.setPname("Library MS");

        p2.setPid(46);
        p2.setPname("Block Chain");

        List<Employee> employees=new ArrayList<Employee>();
        List<Project> projects=new ArrayList<Project>();

        employees.add(em1);
        employees.add(em2);

        projects.add(p1);
        projects.add(p2);

        em1.setProjects(projects);
        p2.setEmployees(employees);

        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(em1);
        session.save(em2);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();
        factory.close();
    }
}
