package com.spacejanitor.comparativegame;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button trueBtn, falseBtn;
    private TextView equation;

    private boolean answer;

    private RandomBoolQuestion randB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueBtn = (Button)findViewById(R.id.true_btn);
        trueBtn.setOnClickListener(this);
        falseBtn = (Button)findViewById(R.id.false_btn);
        falseBtn.setOnClickListener(this);


        equation = (TextView)findViewById(R.id.question);

        randB = new RandomBoolQuestion();

        compileQuestion();
    }

    private void compileQuestion(){
        equation.setText("");
        answer = randB.compileRandomQuestion();

        equation.setText(randB.getPrintResults());
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.true_btn){

            if (answer == true){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
            compileQuestion();
        }

        if (v.getId() == R.id.false_btn){
            if (answer == false){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
            compileQuestion();
        }

    }
}
