package pe.edu.pucp.demo.features.sign_up;

import java.util.Random;

//    Puedes quitarle el public
public class SignUpPresenter implements SignUpContract.Presenter {

    private SignUpContract.View view;

    //    Puedes quitarle el public
    public SignUpPresenter(SignUpContract.View view){
        this.view = view;
    }

//    CONTRACT METHODS
//    -------------------------

    @Override
    public void signUpUser(String username, String password) {

//            Validacion Mas recia
        boolean hasErros = new Random().nextInt(100) < 70 ;

        if (hasErros) {
            view.onSignUpError("Ha ocurrido un error, intentalo de nuevo");
        } else {
            view.onSignUpSuccess();
        }

    }


}
