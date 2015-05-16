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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      </div> <!-- END #content -->
      </div> <!-- END #main -->
      
      <footer>
        <div id="copyright">
		  <div id="list-languages">
		    <%final String queryString = request.getQueryString() == null ? "" : request.getQueryString().replaceAll("&locale=([A-Za-z][A-Za-z]_)?[A-Za-z][A-Za-z]|^locale=([A-Za-z][A-Za-z]_)?[A-Za-z][A-Za-z]", "");%>
		    <c:set var='query' value='<%=queryString%>' />
		    <c:set var="xquery" value="${fn:escapeXml(query)}" />
		      
	        <c:choose>
		      <c:when test="${not empty requestScope['isMobile'] and not empty mobileCss}">
		        <form method="get" action="login?${xquery}">
		          <select name="locale">
		            <option value="en">English</option>
		            <option value="zh_CN"><spring:message code="screen.welcome.zh" /></option>
		          </select>
		          <input type="submit" value="Switch">
		        </form>
		      </c:when>
		      <c:otherwise>
		        <c:set var="loginUrl" value="login?${xquery}${not empty xquery ? '&' : ''}locale=" />
		        <ul>
		          <li class="first"><a href="${loginUrl}en">English</a></li>
		          <li><a href="${loginUrl}zh_CN"><spring:message code="screen.welcome.zh" /></a></li>
		        </ul>
		      </c:otherwise>
		    </c:choose>
		  </div>
        </div>
          
        <p><spring:message code="copyright" /></p>
        <p>Powered by <a href="http://www.jasig.org/cas">Jasig Central Authentication Service <%=org.jasig.cas.CasVersion.getVersion()%></a></p>
		    
      </footer>

    </div> <!-- END #container -->
    
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
    
    <%-- 
        JavaScript Debug: A simple wrapper for console.log 
        See this link for more info: http://benalman.com/projects/javascript-debug-console-log/
    --%>
    <script type="text/javascript" src="https://github.com/cowboy/javascript-debug/raw/master/ba-debug.min.js"></script>
    
    <spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
    <script type="text/javascript" src="<c:url value="${casJavascriptFile}" />"></script>
  </body>
</html>

