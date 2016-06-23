package io.github.howiefh.mybatis.dao;

import io.github.howiefh.mybatis.Pageable;
import io.github.howiefh.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public interface UserDao {
    /**
     * 将实体存入数据库
     *
     * @param entity
     *            保存的实体
     * @return 返回实体id
     */
    int save(User entity);

    /**
     * 根据id查找实体
     *
     * @param id
     *            不能为 {@literal null}.
     * @return id对应的实体，如果没有找到返回{@literal null}
     */
    User findOne(Integer id);

    /**
     * 返回找到的所有实体的集合
     *
     * @return 所有实体
     */
    List<User> findAll();

    /**
     * 找到所有可用的实体的个数
     *
     * @return 实体的个数
     */
    long count();

    /**
     * 找到所有符合条件的实体的个数
     *
     * @param entity
     *            该实体的属性即为条件
     * @return 实体的个数
     */
    long countBy(@Param("param") User entity);
    /**
     * 根据分页信息查找实体集合
     *
     * @param pageable
     * @return
     */
    List<User> findPage(@Param("page") Pageable pageable);

    /**
     * 使用分页插件，根据分页信息查找实体集合
     *
     * @param rowBounds
     * @return
     */
    List<User> findPageByHelper(RowBounds rowBounds);

    /**
     * 根据分页信息查找符合条件的实体集合
     *
     * @param pageable
     * @param entity
     *            包含查找条件的实体
     * @return
     */
    List<User> findPageBy(@Param("page") Pageable pageable, @Param("param") User entity);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    User findByName(String username);

}
