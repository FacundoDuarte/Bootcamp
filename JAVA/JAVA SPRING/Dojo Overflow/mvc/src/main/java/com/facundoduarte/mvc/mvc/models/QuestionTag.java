package com.facundoduarte.mvc.mvc.models;

import java.util.ArrayList;

public class QuestionTag {
    private Question question;
    private Tag tag;

    public QuestionTag() {
        this.question = new Question();
        this.tag = new Tag();
        this.question.setTags(new ArrayList<>());
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
