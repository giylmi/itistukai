package net.itistukai.core.test;

import net.itistukai.core.config.DaoConfig;
import net.itistukai.core.dao.UserDao;
import net.itistukai.core.domain.core.User;
import net.itistukai.core.domain.core.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created by blvp on 18.02.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UnitTestContext.class, DaoConfig.class})
public class AdminCreateUtil {

    @Autowired
    UserDao userDao;

    @Test
    public void createAdmin() throws Exception {
        User user = new User();
        user.setLogin("giylmi");
        String salt = UUID.randomUUID().toString();
        String pswd = "admin";
        String pwd = DigestUtils.md5DigestAsHex((pswd + salt).getBytes());
        user.setPassword(pwd);
        user.setSalt(salt);
        user.setRole(UserRole.ADMIN);
        user.setEmail("blabla@gmail.com");
        userDao.save(user);
    }
}
