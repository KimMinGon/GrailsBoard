
<%@ page import="board.Board" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'board.label', default: 'Board')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-board" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-board" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list board">

				<g:if test="${boardInstance?.subject}">
					<li class="fieldcontain">
						<span id="subject-label" class="property-label"><g:message code="board.subject.label" default="Subject" /></span>

						<span class="property-value" aria-labelledby="subject-label"><g:fieldValue bean="${boardInstance}" field="subject"/></span>

					</li>
				</g:if>

				<g:if test="${boardInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="board.dateCreated.label" default="Date Created" /></span>
					
					<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate type="date" date="${boardInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>


				<g:if test="${boardInstance?.content}">
					<li class="fieldcontain">
						<span id="content-label" class="property-label"><g:message code="board.content.label" default="Content" /></span>

						<span class="property-value" aria-labelledby="content-label">${boardInstance.content.encodeAsHTML()}</span>
					</li>
				</g:if>
			
			</ol>
			<g:if test="${boardInstance.user == user}">
			<g:form url="[resource:boardInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${boardInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
			</g:if>
		</div>
	</body>
</html>
