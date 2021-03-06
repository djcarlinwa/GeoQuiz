package com.knowwherenow.geoquiz;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends ActionBarActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private static final String TAG = "QuizActiity";

    private TrueFalse[] mQuestionBank = new TrueFalse[]  {
            new TrueFalse( R.string.question_africa, true),
            new TrueFalse( R.string.question_americas, true),
            new TrueFalse( R.string.question_asia,true),
            new TrueFalse( R.string.question_mideast,true),
            new TrueFalse( R.string.question_oceans, true)
    };


    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);

    }

    private void checkAnswer(boolean userPressedTrue)
    {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue){

            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;

        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }



    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");

        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton  = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton  = (Button) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }
        });

       mFalseButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               checkAnswer(false);


           }
       });

        mNextButton.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View v){
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            updateQuestion();

        }

        });


        updateQuestion();
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
