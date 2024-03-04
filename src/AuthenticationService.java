import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users = new ArrayList<>();

    public AuthenticationService() {
        users.add(new User("test", "test"));
    };

    @Override
    public User signUp(String username, String password) {

        boolean answer = users.stream().anyMatch(o -> o.getUsername().equals(username));

        if (answer) {
            return null;
        }
        User new_user = new User(username, password);
        users.add(new_user);
        return new_user;
    }

    @Override
    public User logIn(String username, String password) {
        User user = users.stream().filter(o -> o.getUsername().equals(username) && o.getPassword().equals(password)).findFirst().orElse(null);
        System.out.println(user);

        return user;
    }

    // TODO Now: Add a constructor to initialize the users list with the default user

    // TODO Now: Implement the signUp method to add a new user to the list if the username is not taken and return the user; returns null otherwise

    // TODO Now: Implement the logIn method to return the user if the username and password match, and null otherwise
}
