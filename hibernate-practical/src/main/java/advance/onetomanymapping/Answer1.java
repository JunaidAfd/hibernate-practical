package advance.onetomanymapping;

import javax.persistence.*;

@Entity
public class Answer1 {
    public Answer1() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public Answer1(int answerId, String answer, Question1 question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public Question1 getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }

    public void setQuestion(Question1 question) {
        this.question = question;
    }

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;
    @ManyToOne
    private Question1 question;
}
