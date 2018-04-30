<g:if test="${!session.teacher.admin}"> <%--showed only owned courses session check--%>
  <g:each var="c" in="${item.teachers}">
    <g:if test="${c.id == session.teacher.id}">
      ${raw(body())}
    </g:if>
  </g:each>
</g:if>
<g:else>
  ${raw(body())}
</g:else>
