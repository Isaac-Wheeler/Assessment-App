<div class="profileInfo">
    <g:set var="teacheri" value="${session.teacher}" />
    <g:set var="profilePic" value="${teacheri.profilePic}" />
<%--<<<<<<< HEAD
    <p> ${profilePic.id} </p>
   <g:if test="${profilePic == null}">
    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
=======
   <g:if test="${profilePic != null}">
    <p> Your Selected Profile Picture Below: </p>
    <p> ${profilePic.id} </p>
        <img src="${createLink(controller:'main', action:'displayImage', id:profilePic.id)}">
>>>>>>> c44880508877105a3bfcbe3e6d09fa060b820ad1
  </g:if>
  <g:else>
    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
  </g:else>
    <br>
    <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>--%>
    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
    <br>
    <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>
</div>
