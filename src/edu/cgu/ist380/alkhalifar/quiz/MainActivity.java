package edu.cgu.ist380.alkhalifar.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int currentQuestion;
	private int score;
	private String [] questions;
	private String [] answers;
	private Button answerButton;
	private Button questionButton;
	private TextView questionView;
	private TextView answerView;
	private EditText answerText;
	private TextView scoreView;

	public void init() {
		questions = new String[]{"What is the capital of Egypt?", "What class are you in right now?", "What year is this?", "What is the color of the sea?"};
		answers = new String[]{"Cairo","IST380","2013","Blue"};
		currentQuestion = -1;
		score=0;
		answerButton = (Button)findViewById(R.id.AnswerButton);
		questionButton = (Button)findViewById(R.id.QuestionButton);
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView) findViewById(R.id.AnswerTextView);
		scoreView = (TextView) findViewById(R.id.ScoreTextView);
		answerText = (EditText) findViewById(R.id.AnswerText);
		answerButton.setOnClickListener(new OnClickListener(){
			@Override
		public void onClick(View v) { checkAnswer();
		}});
		questionButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				showQuestion();
			}
			});
	}
		/*
		* This method
		* 1: increment currentQuestion index
		* 2: check if it is equal to the size of the array and rest if necessary
		* 3: display the question at currentQuestion index in question view
		* 4: Empty answer view
		*/
		public void showQuestion() {
		currentQuestion++;
		if(currentQuestion == questions.length)
		{
			currentQuestion =0; 
			questionButton.setText("Show Next Question");
			score=0;
			scoreView.setText("Your Score is "+score);
		}
		
		if (currentQuestion == questions.length-1)
		{
			questionButton.setText("Restart Quiz");
		}
			
		questionView.setText("Question "+(currentQuestion+1)+" of "+questions.length+": "+questions[currentQuestion]); answerView.setText("");
		answerText.setText("");
		}
		/*
		* This method return true if the answer equals to correct
		answer
		* (Ignoring case)
		*/
		public boolean isCorrect(String answer) {
		return (answer.equalsIgnoreCase(answers[currentQuestion])); }
		/* this method :
		* 1: Read the text ( answer) from the answerTextEdit * 2: call the isCorrect method
		* 3: display the appropriate message.
		*/
		public void checkAnswer() {
		String answer = answerText.getText().toString();
		if(isCorrect(answer))
			{
			answerView.setText("You're right!");	
			score++;
			scoreView.setText("Your Score is "+score);
			}
		else
			{
			answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]);
			}
		}
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
