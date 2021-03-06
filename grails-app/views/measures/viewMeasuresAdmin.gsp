<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    <div class="newTab">
                <p>Measures
                  <g:link controller="measures" action="create" params="[isadmin:true]">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link><%-- Header with new button --%>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Measures}" var="m" status="i">
            			<div class="listings"><%-- Measure cards--%>
                			<h1>${m.measureTitle}</h1>
                      <p>Desc: ${m.measureDescription}</p>
                      <p>Indicator: ${m.indicator.find().toString()} </p>
                       <g:link controller="measures" action="edit" params="[measure:m.id, isadmin:true]">
           							<button class="add">Edit</button></g:link>
                        <g:link controller="measures" action="delete" params="[measure:m.id, isadmin:true]" onclick="return confirm('Are you sure you want to delete this measure? measure: $m.measureTitle')">
            							<button class="add">Delete</button></g:link>
             		   </div>
             	<br/>
        			</g:each>
            </div>
    </body>
</html>
