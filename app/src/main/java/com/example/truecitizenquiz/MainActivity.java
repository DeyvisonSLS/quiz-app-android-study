package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String TAG = "TRUE_CITIZEN_APP";

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton previousButton;
    private TextView questionTextView;

    private NewQuizAboutBrazil newQuiz = new NewQuizAboutBrazil(this);
    ListIterator<Question> i = newQuiz.getQuestions().listIterator();
    private Question currentQuestion = i.next();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Resetting the cursor position of iterator
        i.previous();

//        ArrayList<Question> newQuestions = new ArrayList<Question>();
//        newQuestions.add(new Question(R.string.question_declaration, true));

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.previous_button);

        questionTextView.setText(currentQuestion.getAnswerText(this));
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
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
            case R.id.next_button:
                nextAnswer();
                break;
            case R.id.previous_button:
                previousAnswer();
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

    private void previousAnswer()
    {
        if(i.hasPrevious())
        {
            int previousIndex = i.previousIndex();
            Question tempQuestion = i.previous();

            if(tempQuestion.equals(currentQuestion) && i.hasPrevious())
            {
                currentQuestion = i.previous();
                previousIndex = i.previousIndex();
            }
            else
            {
                currentQuestion = tempQuestion;
            }

            Log.d(TAG, "Actual answer number (" + previousIndex + "):" + currentQuestion.getAnswerText(this));

            questionTextView.setText(currentQuestion.getAnswerText(this));
        }
        else
        {
            Log.d(TAG, "Previous answer: there isn't any questions backwards.");
//            i.next();
        }

//        if(!i.hasPrevious())
//        {
//            i.next();
//        }
    }

    private void nextAnswer()
    {
        if(i.hasNext())
        {
            int nextIndex = i.nextIndex();

            Question tempQuestion = i.next();

            if(tempQuestion.equals(currentQuestion) && i.hasNext())
            {
                currentQuestion = i.next();
                nextIndex = i.nextIndex();
            }
            else
            {
                currentQuestion = tempQuestion;
            }

            Log.d(TAG, "Actual answer number (" + nextIndex + "):" + currentQuestion.getAnswerText(this));

            questionTextView.setText(currentQuestion.getAnswerText(this));
        }
        else
        {
            Log.d(TAG, "Next answer: there isn't any questions");
//            i.previous();
        }

//        if(!i.hasNext())
//        {
//            i.previous();
//        }
    }
}