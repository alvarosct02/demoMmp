package pe.edu.pucp.demo.features.sign_up;

public interface SignUpContract {

    interface View {

        void onSignUpError(String message);

        void onSignUpSuccess();

    }

    interface Presenter{

        void signUpUser(String username, String password);

    }

}
