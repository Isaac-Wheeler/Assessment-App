<g:each var="c" in="${item.teachers}"><%--session check for only owned by admin--%>
  <g:if test="${c.id == session.teacher.id}">
    ${raw(body())}
  </g:if>
</g:each>
