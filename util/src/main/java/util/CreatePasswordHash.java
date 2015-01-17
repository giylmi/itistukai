package util;

import net.itistukai.core.config.DaoConfig;
import net.itistukai.core.dao.IUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created by giylmi on 28.12.14.
 */
public class CreatePasswordHash {

    ApplicationContext context;

    IUserDao userDao;

    public void setUp(){
        context = new AnnotationConfigApplicationContext(DaoConfig.class);
        context.getBean(IUserDao.class);
    }

    public static void main(String[] args) {
//        String salt = UUID.randomUUID().toString();
//        System.out.println(salt);
//        String pswd = "admin";
//        System.out.println(DigestUtils.md5DigestAsHex((pswd + salt).getBytes()));
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
        IUserDao userDao = context.getBean(IUserDao.class);
        userDao
    }
}
