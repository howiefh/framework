package io.github.howiefh.mybatis.entity;

import java.util.Date;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public class User {
    private static final long serialVersionUID = 415987600518114093L;

    /**
     * 用户名 - sys_user.username
     */
    private String username;

    /**
     * 密码 - sys_user.password
     */
    private String password;

    /**
     * 盐 - sys_user.salt
     */
    private String salt;

    /**
     * 邮箱 - sys_user.email
     */
    private String email;

    /**
     * 手机号码 - sys_user.mobile
     */
    private String mobile;

    /**
     * 用户头像 - sys_user.photo
     */
    private String photo;

    /**
     * 最后登陆IP - sys_user.login_ip
     */
    private String loginIp;

    /**
     * 最后登陆时间 - sys_user.login_date
     */
    private Date loginDate;

    /**
     * 是否锁定 - sys_user.locked
     */
    private Boolean locked;

    /**
     * 创建者
     */
    private User createdBy;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新者
     */
    private User updatedBy;
    /**
     * 更新时间
     */
    private Date updatedAt;

    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    /**
     * Gets the value of the database column sys_user.username
     *
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the database column sys_user.username
     *
     * @param username
     *            用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * Gets the value of the database column sys_user.password
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the database column sys_user.password
     *
     * @param password
     *            密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * Gets the value of the database column sys_user.salt
     *
     * @return 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Sets the value of the database column sys_user.salt
     *
     * @param salt
     *            盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * Gets the value of the database column sys_user.email
     *
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the database column sys_user.email
     *
     * @param email
     *            邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * Gets the value of the database column sys_user.mobile
     *
     * @return 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the database column sys_user.mobile
     *
     * @param mobile
     *            手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * Gets the value of the database column sys_user.photo
     *
     * @return 用户头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the database column sys_user.photo
     *
     * @param photo
     *            用户头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * Gets the value of the database column sys_user.login_ip
     *
     * @return 最后登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * Sets the value of the database column sys_user.login_ip
     *
     * @param loginIp
     *            最后登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * Gets the value of the database column sys_user.login_date
     *
     * @return 最后登陆时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * Sets the value of the database column sys_user.login_date
     *
     * @param loginDate
     *            最后登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * Gets the value of the database column sys_user.locked
     *
     * @return 是否锁定
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * Sets the value of the database column sys_user.locked
     *
     * @param locked
     *            是否锁定
     */
    public void setLocked(Boolean locked) {
        this.locked = locked == null ? false : locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", photo='" + photo + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", locked=" + locked +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedBy=" + updatedBy +
                ", updatedAt=" + updatedAt +
                ", id=" + id +
                '}';
    }

}