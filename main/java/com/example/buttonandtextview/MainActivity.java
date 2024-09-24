package com.example.buttonandtextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button myButton=null;
    private TextView myTextView =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(this);
        myTextView = (TextView) findViewById(R.id.textView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClick (View v){
        //el texto actual del Textview
        String textViewText = myTextView.getText().toString();
        //texto pulsa el boton del strings.xml
        String textPulsa = getString(R.string.text_pulsa);
        //texto hola mundo del stirngs.xml
        String textHola = getString(R.string.text_hola_mundo);
        //comparamos y cambiamos
        if (textViewText.equalsIgnoreCase(textPulsa)){
            myTextView.setText(textHola);
        } else {
            myTextView.setText(textPulsa);
        }
    }
}