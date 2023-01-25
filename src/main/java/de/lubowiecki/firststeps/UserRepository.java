package de.lubowiecki.firststeps;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private Map<String, User> users;

    private static final int strength = 12;

    private static final byte[] salt = "1234567890abcdef".getBytes();

    public UserRepository() {
        users =  new HashMap<>();
        users.put("admin", new User("admin", BCrypt.withDefaults().hash(strength, salt, "geheim".getBytes()), "ADMIN"));
        users.put("peter", new User("peter", BCrypt.withDefaults().hash(strength, salt, "geheim1".getBytes()), "USER"));
        users.put("carol", new User("carol", BCrypt.withDefaults().hash(strength, salt, "geheim2".getBytes()), "USER"));
    }

    public boolean userExists(String name) {
        return users.containsKey(name.toLowerCase());
    }

    public Optional<User> checkCredentials(String name, String password) {
        if(userExists(name)) { // Existiert ein User mit gewünschten Namen?
            User user = users.get(name);
            // Passt das Passwort?
            BCrypt.Result result = BCrypt.verifyer().verify(password.getBytes(), user.getPassword());
            if(result.verified) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
