package com.example.graceqiu.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText = (EditText) findViewById(R.id.Input);
    Button button = (Button) findViewById(R.id.Search);
    TextView textView = (TextView) findViewById(R.id.welcomeword);
    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.background);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                editText.setText("TYPE");
                textView.setText(input);
            }
        });
    }
}
