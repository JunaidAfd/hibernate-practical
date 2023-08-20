package advance.onetomanymapping;

import advance.mapping.Answer;
import advance.mapping.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMappingDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();

        Question1 question=new Question1();
        question.setQuestionId(1212);
        question.setQuestion("What is Java?");

        Answer1 answer=new Answer1();
        answer.setAnswerId(343);
        answer.setAnswer("A programming language");
        answer.setQuestion(question);

        Answer1 answer1=new Answer1();
        answer1.setAnswerId(444);
        answer1.setAnswer("With the help of java we can create apps");
        answer1.setQuestion(question);

        Answer1 answer2=new Answer1();
        answer2.setAnswerId(555);
        answer2.setAnswer("Java is OOP based");
        answer2.setQuestion(question);

        List<Answer1> list=new ArrayList<Answer1>();
        list.add(answer2);
        list.add(answer1);
        list.add(answer);
        question.setAnswers(list);

        Transaction tx=session.beginTransaction();
        session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);



        tx.commit();
        Question1 q=(Question1) session.get(Question1.class,1212);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswers().size());//Lazy Loading

        session.close();
        factory.close();
    }
}
