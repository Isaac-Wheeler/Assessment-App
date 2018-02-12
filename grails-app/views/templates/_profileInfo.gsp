<div class="profileInfo">
  <g:if test="${session.teacher.profilePic == null}">
    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
  </g:if>
  <g:else>

  </g:else>
    <br>
    <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>
</div>
