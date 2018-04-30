<div class="securityNonAdmin" > <%--session check for non admin--%>
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("/DAA/")}
  </g:if>
</div>
