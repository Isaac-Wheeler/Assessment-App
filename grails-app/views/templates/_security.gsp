<div class="security" >
  <g:if test="${session?.teacher?.admin == false}">
    ${response.sendRedirect("/DAA")}
  </g:if>
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("/DAA")}
  </g:if>
</div>
