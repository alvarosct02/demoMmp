package pe.edu.pucp.demo.features.sign_up;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import pe.edu.pucp.demo.R;
import pe.edu.pucp.demo.features.main.MainActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {

    public static Intent newInstance(Context context) {
        return new Intent(context, SignUpActivity.class);
    }

    private Button btSignUp;
    private CheckBox cbTerms;
    private TextInputLayout tilUsername, tilPassword, tilPasswordRepeat;

    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        Aqui esta el MVP
        presenter = new SignUpPresenter(this);

//        Solo para ordener un poco el codigo. HUMO
        setupView();
        setupActions();

    }

    private void setupView() {

//    Estandar en nomber de variable. camelCase igual que en la vista. HUMO
        btSignUp = findViewById(R.id.bt_login);
        cbTerms = findViewById(R.id.cb_terms);
        tilUsername = findViewById(R.id.til_username);
        tilPassword = findViewById(R.id.til_password);
        tilPasswordRepeat = findViewById(R.id.til_password_repeat);
    }

    private void setupActions() {
        btSignUp.setOnClickListener((View v) -> {

            String username = tilUsername.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            String passwordRepeat = tilPasswordRepeat.getEditText().getText().toString();

            boolean termsAccepted = cbTerms.isChecked();

//            Validacion Asna si quieres...

            if (!termsAccepted) {
                Toast.makeText(this, "Debe aceptar los terminos y condiciones de uso.", Toast.LENGTH_SHORT).show();
                return;
            }

//            y luego llamas a tu presentador
            presenter.signUpUser(username, password);
        });
    }


//    CONTRACT METHODS
//    -------------------------


    @Override
    public void onSignUpError(String message) {
//        Muestras un mensajito o algo. Modo asno... TOAST.
//        Ya si quieres le pones un dialog
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {

        new AlertDialog.Builder(this)
                .setTitle("Exito")
                .setMessage("El usuario ha sido creado exitosamente")
                .setPositiveButton("OK", (dialog, which) -> {
//        Cerrar la actividad actual
                    finish();
                })
                .create().show();

    }
}
