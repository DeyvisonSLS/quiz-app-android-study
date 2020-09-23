package com.example.truecitizenquiz;

import android.content.Context;

public class NewQuizAboutBrazil extends Quiz
{

    public NewQuizAboutBrazil(Context context)
    {
        setContext(context);

        setQuizName("Quiz About Brazil");

        //  Instantiating of questions
        addQuestion("The apple is red", true);
        addQuestion("The skies have no air", false);
        addQuestion("Design is better, programming too", true);
        addQuestion(R.string.question_leaf, true);
    }
}
