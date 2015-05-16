<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<jsp:directive.include file="includes/top.jsp" />

<c:if test="${not pageContext.request.secure}">
  <div id="msg" class="errors">
    <h2><spring:message code="screen.welcome.non_secure.head" /></h2>
    <p><spring:message code="screen.welcome.non_secure.content" /></p>
  </div>
</c:if>

<div class="box" id="login">
  <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">

    <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" />
  
    <h2><spring:message code="screen.welcome.instructions" /></h2>
  
    <section class="row id">
      <span></span>
      <c:choose>
        <c:when test="${not empty sessionScope.openIdLocalId}">
          <strong>${sessionScope.openIdLocalId}</strong>
          <input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}" />
        </c:when>
        <c:otherwise>
          <spring:message code="screen.welcome.label.netid" var="userNameHolder" />
          <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
          <form:input cssClass="required" cssErrorClass="error" id="username" size="25" tabindex="1" placeholder="${userNameHolder }" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
        </c:otherwise>
      </c:choose>
    </section>
    
    <section class="row pwd">
      <span></span>
      <%--
      NOTE: Certain browsers will offer the option of caching passwords for a user.  There is a non-standard attribute,
      "autocomplete" that when set to "off" will tell certain browsers not to prompt to cache credentials.  For more
      information, see the following web page:
      http://www.technofundo.com/tech/web/ie_autocomplete.html
      --%>
      <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
      <spring:message code="screen.welcome.label.password" var="passwordHolder" />
      <form:password cssClass="required" cssErrorClass="error" id="password" size="25" tabindex="2" path="password" placeholder="${passwordHolder }" accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
    </section>
    <section class="row">
	      <spring:message code="screen.welcome.label.captcha.accesskey" var="captchaAccessKey" />
	      <spring:message code="screen.welcome.label.captcha" var="captchaHolder" />
          <form:input cssClass="required" cssErrorClass="error" id="captcha" size="10" tabindex="3"  path="captcha" placeholder="${captchaHolder }" accesskey="${captchaAccessKey}" autocomplete="off" htmlEscape="true" />
          <img alt="${captchaHolder }" src="captcha.jpg" onclick="this.src='captcha.jpg?'+Math.random();">
    </section>
    <section class="row check">
      <input id="rememberMe" name="rememberMe" value="false" tabindex="4" accesskey="<spring:message code="screen.welcome.label.rememberMe.accesskey" />" type="checkbox" />
      <label for="rememberMe"><spring:message code="screen.welcome.label.rememberMe" /></label>
    </section>
    
    <section class="row btn-row">
      <input type="hidden" name="lt" value="${loginTicket}" />
      <input type="hidden" name="execution" value="${flowExecutionKey}" />
      <input type="hidden" name="_eventId" value="submit" />

      <input class="btn-submit" name="submit" accesskey="l" value="<spring:message code="screen.welcome.button.login" />" tabindex="5" type="submit" />
      <input class="btn-reset" name="reset" accesskey="c" value="<spring:message code="screen.welcome.button.clear" />" tabindex="6" type="reset" />
    </section>
  </form:form>
</div>

<jsp:directive.include file="includes/bottom.jsp" />
