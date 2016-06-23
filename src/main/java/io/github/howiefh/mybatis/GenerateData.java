package io.github.howiefh.mybatis;

import io.github.howiefh.mybatis.dao.UserDao;
import io.github.howiefh.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public class GenerateData {
    public static void main(String[] args) {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                UserDao userDao = session.getMapper(UserDao.class);
                for (int i = 1000; i < 10000; i++){
                    User user = new User();

                    user.setUsername("user-"+i);
                    user.setEmail("user-"+i+"@user.com");
                    user.setLocked(false);
                    user.setLoginDate(new Date());
                    user.setMobile(i+"-123456789");
                    user.setPassword(i+"-123456");
                    user.setPhoto("photo-"+i);
                    user.setSalt("salt"+i);
                    user.setCreatedAt(new Date());
                    user.setCreatedBy(null);
                    user.setUpdatedAt(new Date());
                    user.setUpdatedBy(null);
                    int result = userDao.save(user);
                    System.out.println(result);
                }
                session.commit();
            }finally{
                session.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
