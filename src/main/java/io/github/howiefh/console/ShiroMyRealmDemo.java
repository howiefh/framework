package io.github.howiefh.console;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fh
 * @version 2015年5月5日
 */
public class ShiroMyRealmDemo {
	private static final transient Logger log = LoggerFactory.getLogger(ShiroMyRealmDemo.class);

	public static void main(String[] args) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:realm/shiro-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "123456");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        	log.error("认证失败{}", e.getMessage());
        }
        log.info("是否经过验证: {}" ,subject.isAuthenticated());
        
        //6、退出
        subject.logout();
	}
}
