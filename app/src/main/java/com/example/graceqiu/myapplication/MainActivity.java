package com.example.graceqiu.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import android.os.AsyncTask;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    String url;
    EditText editText;
    Button button;
    TextView textView;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new CallbackTask().execute(dictionaryEntries(""));
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.Search);
        editText = (EditText) findViewById(R.id.Input);
        textView = (TextView) findViewById(R.id.definition);
        constraintLayout = (ConstraintLayout) findViewById(R.id.background);
    }

        //button.setOnClickListener(new View.OnClickListener() {
        //    @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                Request request = new Request(this,textView);
                //textView.setText(dictionaryEntries(input));
                url = dictionaryEntries(input);
                request.execute(url);

            }
        //});
    //}

    private String dictionaryEntries(final String input) {
        final String word = input;
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/" + word_id;
    }

}

