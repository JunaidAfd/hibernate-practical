package advance.mapping;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }

    public Question(int questionId, String question, Answer answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }


}
