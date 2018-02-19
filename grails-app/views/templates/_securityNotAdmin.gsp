<div class="securityNonAdmin" >
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("DAA")}
  </g:if>
</div>
