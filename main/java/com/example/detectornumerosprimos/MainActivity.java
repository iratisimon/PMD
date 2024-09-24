package com.example.detectornumerosprimos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button myButton = null;
    private TextView myTextView = null;
    private EditText myEditText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(this::onClick);
        myTextView = (TextView) findViewById(R.id.textView);
        myEditText = (EditText) findViewById(R.id.editTextText);

        // Inicializa el texto del TextView
        myTextView.setText(R.string.text_introducir);
        myButton.setText(R.string.text_comprobar);
    }
    public void onClick (View v){
        String buttonText = myButton.getText().toString();
        if (buttonText.equals(getString(R.string.text_comprobar))) {
            String input = myEditText.getText().toString();
            try {
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    // Verifica si el número es mayor a 4 dígitos
                    if (input.length() > 4) {
                        myTextView.setText(R.string.text_numero_largo);
                    } else {
                        // Llama al método isPrimeNumber de la clase Operations
                        if (Operations.isPrimeNumber(number)) {
                            myTextView.setText(R.string.text_numero_primo);
                        } else {
                            myTextView.setText(R.string.text_numero_no_primo);
                        }
                    }
                } else {
                    myTextView.setText(R.string.text_numero_vacio);
                }
                myButton.setText(R.string.text_reiniciar);
            }catch (NumberFormatException e) {
                // Captura la excepción y muestra el mensaje
                myTextView.setText(R.string.text_numero_no_primo);
                myButton.setText(R.string.text_reiniciar);
            }
        } else {
            myTextView.setText(R.string.text_introducir); // Muestra el texto inicial
            myEditText.setText(""); // Limpia el EditText
            myButton.setText(R.string.text_comprobar);
        }
    }
}