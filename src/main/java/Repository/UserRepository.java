package Repository;

import Controller.User.User;

import java.util.LinkedList;

public class UserRepository {

    private static final UserRepository instance = new UserRepository();

    private UserRepository() {
        userRepository.add(new User("승우"));
        userRepository.add(new User("승훈"));
        userRepository.add(new User("무광"));
    }

    public static UserRepository getInstance() {
        return instance;
    }

    private final LinkedList<User> userRepository = new LinkedList<>();

    public void add(String name) {
        // TODO Auto-generated method stub
        userRepository.add(new User(name));
    }

    public LinkedList<User> getusers() {
        return userRepository;
    }

    public void deleteUser(String name) {
        userRepository.removeIf(user -> user.getName().equals(name));
    }

    public void updateUser(String name, String updatename) {
        for (User user : userRepository) {
            if (user.getName().equals(name))
                user.setName(updatename);
        }
    }
}
