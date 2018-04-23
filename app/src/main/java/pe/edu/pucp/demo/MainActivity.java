package pe.edu.pucp.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mSubmit;
    private TextView mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmit = findViewById(R.id.submit_login);
        mRegister = findViewById(R.id.register);

        mSubmit.setOnClickListener((View v) -> {
            /*
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
             */

        });

        mRegister.setOnClickListener((View v) -> {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        });
    }
}
