package pe.edu.pucp.demo.features.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.pucp.demo.R;
import pe.edu.pucp.demo.features.main.MainActivity;
import pe.edu.pucp.demo.features.sign_up.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private Button btLogin;
    private TextView tvRegister;
    private TextInputLayout tilUsername, tilPassword;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        Aqui esta el MVP
        presenter = new LoginPresenter(this);

//        Solo para ordener un poco el codigo. HUMO
        setupView();
        setupActions();

    }

    private void setupView() {

//    Estandar en nomber de variable. camelCase igual que en la vista. HUMO
        btLogin = findViewById(R.id.bt_login);
        tvRegister = findViewById(R.id.tv_register);
        tilUsername = findViewById(R.id.til_username);
        tilPassword = findViewById(R.id.til_password);
    }

    private void setupActions() {
        btLogin.setOnClickListener((View v) -> {

            String username = tilUsername.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();

//            Validacion Asna si quieres...


//            y luego llamas a tu presentador
            presenter.loginUser(username, password);
        });

        tvRegister.setOnClickListener((View v) -> {
//            Aqui hay un debate infinito... pero dejalo asi nomas. llamas a tu otra pantalla directo
            startActivity(SignUpActivity.newInstance(this));
        });
    }


//    CONTRACT METHODS
//    -------------------------

    /**
     *
     *
     */

    @Override
    public void onLoginError(String message) {
//        Muestras un mensajito o algo. Modo asno... TOAST.
//        Ya si quieres le pones un dialog
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(String username) {
//        Mostrar la MainActivity
        startActivity(MainActivity.newInstance(this, username));

//        Cerrar la actividad actual
//        finish();

    }
}
