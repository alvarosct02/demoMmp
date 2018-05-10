package pe.edu.pucp.demo.features.login;

import java.util.Random;

//    Puedes quitarle el public
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    //    Puedes quitarle el public
    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }


//    CONTRACT METHODS
//    -------------------------

    @Override
    public void loginUser(String username, String password) {

//            Validacion Mas recia
        boolean hasErros = new Random().nextInt(100) < 70 ;

        if (hasErros) {
            view.onLoginError("Ha ocurrido un error, intentalo de nuevo");
        } else {
            view.onLoginSuccess(username);
        }

    }
}
