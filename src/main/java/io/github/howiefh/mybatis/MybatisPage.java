package io.github.howiefh.mybatis;

import java.util.Map;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public interface MybatisPage {
    Map execute(int pageSize);
}
