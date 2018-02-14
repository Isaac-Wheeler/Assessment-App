<g:if test="${!it.teachers.contains(session.teacher)}">
  ${raw(body())}
</g:if>
