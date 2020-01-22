package com.app.wastemanagementforkids.game;

public class MCQItem {

    String question,answer;
    String[] options;

    public MCQItem() {
    }

    public MCQItem(String question, String[] options, String answer) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
