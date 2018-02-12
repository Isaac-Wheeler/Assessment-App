<div class="security" >
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("/DAA")}
  </g:if>
</div>
