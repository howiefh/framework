package io.github.howiefh.cas.web.flow;

import io.github.howiefh.cas.authentication.UsernamePasswordCaptchaCredential;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.util.StringUtils;
import org.springframework.webflow.execution.RequestContext;

public class AuthenticationViaFormAction extends org.jasig.cas.web.flow.AuthenticationViaFormAction{

    public final String validatorCaptcha(final RequestContext context, final Credential credential,
            final MessageContext messageContext){
        
            final HttpServletRequest request = WebUtils.getHttpServletRequest(context);  
            HttpSession session = request.getSession();  
            String captcha = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
            session.removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
            
            UsernamePasswordCaptchaCredential upc = (UsernamePasswordCaptchaCredential)credential;  
            String submitAuthcodeCaptcha =upc.getCaptcha(); 
            
            
            if(!StringUtils.hasText(submitAuthcodeCaptcha) || !StringUtils.hasText(submitAuthcodeCaptcha)){
                messageContext.addMessage(new MessageBuilder().code("required.captcha").build()); 
                return "error";    
            }  
            if(submitAuthcodeCaptcha.equals(captcha)){    
                return "success";  
            }  
            messageContext.addMessage(new MessageBuilder().code("error.authentication.captcha.bad").build());
            return "error";    
    }
}