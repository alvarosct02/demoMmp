package pe.edu.pucp.demo.features.login;

public interface LoginContract {

    interface View {

        void onLoginError(String message);

        void onLoginSuccess(String username);

    }

    interface Presenter{

        void loginUser(String username, String password);

    }

}
