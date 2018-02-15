<g:if test="${!session.teacher.admin}">
  <g:each var="c" in="${it.teachers}">
    <g:if test="${c.id == session.teacher.id}">
      ${raw(body())}
    </g:if>
  </g:each>
</g:if>
<g:else>
  ${raw(body())}
</g:else>
