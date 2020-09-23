package com.example.truecitizenquiz;

public class Question
{
    private int answerResID;
    private String answerText;
    private boolean correctAnswer;

    public Question(int answerResID, boolean correctAnswer)
    {
        this.answerResID = answerResID;
        this.correctAnswer = correctAnswer;
    }

    public Question(String answerText, boolean correctAnswer)
    {
        this.answerText = answerText;
        this.correctAnswer = correctAnswer;
    }

    public int getAnswerResID()
    {
        return answerResID;
    }

    public String getAnswerText()
    {
        return answerText;
    }

    public void setAnswerResID(int answerResID)
    {
        this.answerResID = answerResID;
    }

    public boolean getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
}
