<div class="profileInfo">
    <g:set var="teacheri" value="${session.teacher}" />
    <g:set var="profilePic" value="${teacheri.profilePic}" />
    <p> ${profilePic.id} </p>
   <%--<g:if test="${profilePic == null}">
    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
  </g:if>
  <g:else>
    <p> test </p>
    <img src="${createLink(controller:'main', action:'displayImage', id:session.teacher.profilePic.id)}">
  </g:else>
    <br>
    <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p> --%>
</div>
