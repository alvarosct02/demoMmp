package pe.edu.pucp.demo.features.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pe.edu.pucp.demo.R;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_USERNAME = "EXTRA_USERNAME";

    public static Intent newInstance(Context context, String username) {
        return new Intent(context, MainActivity.class)
                .putExtra(EXTRA_USERNAME, username);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
    }

    void setupView(){
        String username = getIntent().getStringExtra(EXTRA_USERNAME);

        TextView tvHello = findViewById(R.id.tv_hello);
        tvHello.setText(username);
    }
}
