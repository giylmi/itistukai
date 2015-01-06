package util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created by giylmi on 28.12.14.
 */
public class CreatePasswordHash {

    public static void main(String[] args) {
        String salt = UUID.randomUUID().toString();
        System.out.println(salt);
        String pswd = "user";
        System.out.println(DigestUtils.md5DigestAsHex((pswd + salt).getBytes()));
    }
}
