<div class="security" > <%--session check for admin--%>
  <g:if test="${session?.teacher?.admin == false}">
    ${response.sendRedirect("/DAA/")}
  </g:if>
  <g:render template="/templates/securityNotAdmin"/>
</div>
