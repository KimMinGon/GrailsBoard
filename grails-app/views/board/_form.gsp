<%@ page import="board.Board" %>

<div class="fieldcontain ${hasErrors(bean: boardInstance, field: 'subject', 'error')} required">
	<label for="subject">
		<g:message code="board.subject.label" default="Subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subject" required="" value="${boardInstance?.subject}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: boardInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="board.content.label" default="Content" />

	</label>
	<g:textArea name="content" value="${boardInstance?.content}"/>

</div>
