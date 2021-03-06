package com.AndrzejMiskow_practise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private CheckBox checkBox;
    private Button btnStart;

    private RadioGroup radioGroup;

    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initilisising UI elements
        editText = (EditText) findViewById(R.id.editText);

        checkBox = (CheckBox) findViewById(R.id.checkbox);

        btnStart = (Button) findViewById(R.id.btnStart);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //will increment the progress bar from 0 to 10 on a new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar.incrementProgressBy(10);
                    //need try catch incase the thread cant do it task
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //starts the thread
        thread.start();

    }


    //checks if the checkbox is ticked or not activited by the button.
    public void start (View view){
        if (checkBox.isChecked()) {
            System.out.println("It is Checked");
        }else{
            System.out.println("it's not Checked");
        }

        //changes the editText field depending on what option is selected
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.rbMale:
                editText.setText("Male");
                break;
            case R.id.rbFemale:
                editText.setText("Female");
                break;
            case R.id.rbOther:
                editText.setText("Other");
                break;
            default:
                break;
        }
    }
}