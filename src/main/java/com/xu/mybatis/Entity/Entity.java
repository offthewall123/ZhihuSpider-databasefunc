package com.xu.mybatis.Entity;

public class Entity {
    private int id;
    private String Url;
    private String QuestionHeaderTitle;
    private String Description;
    private String Answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getQuestionHeaderTitle() {
        return QuestionHeaderTitle;
    }

    public void setQuestionHeaderTitle(String questionHeaderTitle) {
        QuestionHeaderTitle = questionHeaderTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public Entity(){

    }
    public Entity(int id, String url, String questionHeaderTitle, String description, String answer) {
        this.id = id;
        Url = url;
        QuestionHeaderTitle = questionHeaderTitle;
        Description = description;
        Answer = answer;
    }

    @Override
    public String toString() {
        return "id: "+this.id+"\n"+
                "Url: "+this.Url+"\n"+
                "QuestionHeaderTitle: "+this.QuestionHeaderTitle+"\n"+
                "Description: "+this.Description+"\n"+
                "Answer: "+this.Answer+"\n";
    }
}
