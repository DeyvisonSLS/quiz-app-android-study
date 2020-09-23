package com.example.truecitizenquiz;

import java.util.ArrayList;

public class Quiz
{
    private String quizName = "Empty";
    private ArrayList<Question> questions = new ArrayList<Question>();

    public Quiz(){}

    public Quiz(String quizName, ArrayList<Question> questions)
    {
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
        questions.add(new Question(answerResId, correctAnswer));
    }
    public void addQuestion(String answerText, boolean correctAnswer)
    {
        questions.add(new Question(answerText, correctAnswer));
    }
    public void removeQuestion(Question question)
    {
        questions.remove(question);
    }
}
