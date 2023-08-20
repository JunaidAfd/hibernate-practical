package advance.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();

        Question question=new Question();
        question.setQuestionId(1212);
        question.setQuestion("What is Java?");

        Answer answer=new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("A programming language");
        answer.setQuestion(question);
        question.setAnswer(answer);

        Transaction tx=session.beginTransaction();
        session.save(question);
        session.save(answer);

        tx.commit();

        //fetching
        Question question1=(Question) session.get(Question.class,1212);
        System.out.println(question1.getQuestion());
        System.out.println(question1.getAnswer().getAnswer());
        session.close();
        factory.close();
    }
}
