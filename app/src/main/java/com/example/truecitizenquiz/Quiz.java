package com.example.truecitizenquiz;

import android.content.Context;

import java.util.ArrayList;

public class Quiz
{
    private Context context;

    private String quizName = "Empty";
    private ArrayList<Question> questions = new ArrayList<Question>();

    public Quiz(){}

    public Quiz(Context context, String quizName, ArrayList<Question> questions)
    {
        this.context = context;
        this.quizName = quizName;
        this.questions = questions;
    }

    public String getQuizName()
    {
        return quizName;
    }

    public void setQuizName(String quizName)
    {
        this.quizName = quizName;
    }

    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public void addQuestion(int answerResId, boolean correctAnswer)
    {
        questions.add(new Question(getContext(), answerResId, correctAnswer));
    }

    public void addQuestion(String answerText, boolean correctAnswer)
    {
        questions.add(new Question(answerText, correctAnswer));
    }

    public void removeQuestion(Question question)
    {
        questions.remove(question);
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public Context getContext()
    {
        return context;
    }
}
