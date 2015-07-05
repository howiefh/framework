package io.github.howiefh.cas.authentication;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.cas.authentication.RememberMeUsernamePasswordCredential;

public class UsernamePasswordCaptchaCredential extends RememberMeUsernamePasswordCredential{

    private static final long serialVersionUID = -2988130322912201986L;
    @NotNull
    @Size(min = 1, message = "required.captcha")
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
