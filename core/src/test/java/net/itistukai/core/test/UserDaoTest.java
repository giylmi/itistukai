package net.itistukai.core.test;

import net.itistukai.core.config.DaoConfig;
import net.itistukai.core.dao.UserDao;
import net.itistukai.core.domain.core.PersonalInformation;
import net.itistukai.core.domain.core.User;
import net.itistukai.core.domain.core.UserRole;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by giylmi on 28.12.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UnitTestContext.class, DaoConfig.class})
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    @Ignore
    public void allUsers(){
//        List<User> users = userDao.all();
//        assertNotNull(users);
//        assertTrue(!users.isEmpty());
    }

    @Test
    @Ignore
    public void allAdmins(){
//        UserDao.UserQueryParameters params = UserDao.UserQueryParameters.builder().withRole(Arrays.asList(UserRole.ADMIN)).build();
//        List<User> users = userDao.all(params);
//        assertNotNull(users);
//        assertTrue(!users.isEmpty());
//        for (User user: users)
//            assertTrue(user.getLogin().equals("admin"));
    }

    @Test
    @Transactional
    @Ignore
    public void registerUser(){
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        user.setSalt("test");
        user.setEmail("test@mail.ru");
        PersonalInformation pi = new PersonalInformation();
        pi.setFirstName("testFirst");
        pi.setLastName("testLast");
        user.setPi(pi);
        user.setRole(UserRole.USER);
        userDao.save(user);
        assertNotNull(user.getId());
    }

}
