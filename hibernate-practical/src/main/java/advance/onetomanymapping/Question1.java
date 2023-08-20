package advance.onetomanymapping;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question1 {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<Answer1> answers;

    public Question1() {
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<Answer1> answers) {
        this.answers = answers;
    }

    public List<Answer1> getAnswers() {
        return answers;
    }

    public Question1(int questionId, String question, List<Answer1> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }



}
