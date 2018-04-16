<g:each var="c" in="${item.teachers}">
  <g:if test="${c.id == session.teacher.id}">
    ${raw(body())}
  </g:if>
</g:each>
