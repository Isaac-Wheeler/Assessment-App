<div class="profileInfo">
    <g:set var="teacheri" value="${session.teacher}" />
    <g:set var="profilePic" value="${teacheri.profilePic}" />
   <g:if test="${profilePic != null}">
    <p> Your Selected Profile Picture Below: </p>
    <p> ${profilePic.id} </p>
        <img src="${createLink(controller:'main', action:'displayImage', id:profilePic.id)}">
  </g:if>
  <g:else>
    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
  </g:else>
    <br>
    <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>
</div>
