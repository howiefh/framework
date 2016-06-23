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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public class NativeSqlPage implements MybatisPage{
    @Override
    public Map execute(int pageSize) {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                UserDao userDao = session.getMapper(UserDao.class);
                long count = userDao.count();
                Page page = new Page(0, pageSize, count);
                long start = new Date().getTime();
                while (page.hasNext()) {
                    List<User> users = userDao.findPage(page);
                    page = (Page) page.next();
                }
                long end = new Date().getTime();
                Map<String, Number> map = new HashMap<String, Number>();
                map.put("pages", page.getTotalPages());
                map.put("time",end - start);
                return map;
            }finally{
                session.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
