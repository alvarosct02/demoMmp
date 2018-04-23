package pe.edu.pucp.demo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        register = findViewById(R.id.register);

        register.setOnClickListener((View v) -> {
            AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
            alertDialog.setTitle("Éxito!");
            alertDialog.setMessage("Sus datos han sido registrados satisfactoriamente");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Gracias", (dialog, which)  -> {
                dialog.dismiss();
                finish();
            });
            alertDialog.show();
        });
    }
}
