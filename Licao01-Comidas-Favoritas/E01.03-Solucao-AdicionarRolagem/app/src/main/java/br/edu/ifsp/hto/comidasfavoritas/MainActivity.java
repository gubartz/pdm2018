package br.edu.ifsp.hto.comidasfavoritas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mComidasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mComidasTextView = findViewById(R.id.tv_comidas);

        String[] comidas = Comidas.getComidas();

        for(String comida : comidas){
            mComidasTextView.append(comida + "\n\n\n");
        }

    }
}
