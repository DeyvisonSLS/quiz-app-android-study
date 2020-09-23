package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String TAG = "TRUE_CITIZEN_APP";

    private Button trueButton;
    private Button falseButton;
    private TextView questionTextView;

    private NewQuizAboutBrazil newQuiz = new NewQuizAboutBrazil();
    private Question currentQuestion = newQuiz.getQuestions().get(0);
    Iterator<Question> i = newQuiz.getQuestions().iterator();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<Question> newQuestions = new ArrayList<Question>();
//        newQuestions.add(new Question(R.string.question_declaration, true));

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text);

        questionTextView.setText(currentQuestion.getAnswerText());
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.true_button:
                isMyAnswer(true);
                break;
            case R.id.false_button:
                isMyAnswer(false);
                break;
            default:
                break;
        }
    }

    private void isMyAnswer(boolean answer)
    {
        String message;
        if(currentQuestion.getCorrectAnswer() == answer)
        {
            message = "Right answer!";
            nextAnswer();
        }
        else
        {
            message = "Wrong answer, try again.";
        }
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void nextAnswer()
    {
        if(i.hasNext())
        {
//            i.next();
//            Log.d(TAG, i.next().toString());
            currentQuestion = i.next();

            Log.d(TAG, "currentQuestion: " + currentQuestion.getAnswerText());
            
            questionTextView.setText(currentQuestion.getAnswerText());
        }
        else
        {
            Log.d(TAG, "nextAnswer: there isn't any questions");
        }
    }
}