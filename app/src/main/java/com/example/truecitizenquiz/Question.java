package com.example.truecitizenquiz;

import android.content.Context;

public class Question
{
    private Context context;

    private int answerResID;
    private String answerText;
    private boolean correctAnswer;

    public Question()
    {
    }

    public Question(Context context)
    {
        this.context = context;
    }

    public Question(Context context, int answerResID, boolean correctAnswer)
    {
        this.context = context;
        this.answerResID = answerResID;
        this.correctAnswer = correctAnswer;
    }

    public Question(String answerText, boolean correctAnswer)
    {
        this.answerText = answerText;
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerText(Context context)
    {
        return getAnswerString() != null ? getAnswerString() : getContext().getResources().getString(getAnswerResID());
    }

    private int getAnswerResID()
    {
        return answerResID;
    }

    private String getAnswerString()
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

    public Context getContext()
    {
        return context;
    }
}
