package edu.citytech.cst.s23253396.cst4713project.security.services;

import com.citytech.basicsecurity.SimpleEncryption;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jbbwebsolutions.helper.FileUtility;
import edu.citytech.cst.s23253396.cst4713project.security.models.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserService {

    private final String SECURITY_DIRECTORY = "/Users/raynermdz/Downloads/users/";
    private static int loginAttempts = 0;

    public boolean isAuthenticated(String userId, String password) {
        User user = this.getUserInfo(userId);

        if (user.isDisabled()) {
            return false;
        }

        String encryptedPassword = user.getEncryptedPassword();
        boolean status = SimpleEncryption.verifyPassword(password, encryptedPassword);
        if (!status) {
            ++loginAttempts;
            user.setLoginAttempts(loginAttempts);

            if (loginAttempts >= 3) {
                user.setDisabled(true);
            }

            this.updateFile(user);
        }
        return status;
    }

    public User getUserInfo(String userId) {
        String fileName = this.SECURITY_DIRECTORY + userId + ".json";
        return FileUtility.readAFile(fileName, jsonToUser);
    }

    private final Function<String, User> jsonToUser = json -> new Gson().fromJson(json, User.class);

    public void updateFile(User user) {
        String fileName = this.SECURITY_DIRECTORY + user.getUserId() + ".json";
        GsonBuilder builder = new GsonBuilder();
        Gson prettyGson = builder.setPrettyPrinting().create();
        String jsonContent = prettyGson.toJson(user);
        FileUtility.writeContent(fileName, jsonContent);
    }

    public String getSecurityDirectory() {
        return SECURITY_DIRECTORY;
    }
}
