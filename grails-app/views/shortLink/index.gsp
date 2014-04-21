<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'shortLink.label', default: 'ShortLink')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<a href="#create-shortLink" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<g:form controller="shortLink" action="createShortLink">
    <div id="create-shortLink" class="content">
        <h1><g:message code="default.create.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${shortLink}">
            <ul class="errors">
                <g:eachError bean="${shortLink}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
        <div class="fieldcontain ${hasErrors(bean: shortLink, field: 'targetUrl', 'error')} ">
            <label><g:message code="shortLink.targetUrl.label" default="Target Url" /></label>
            <g:textField name="targetUrl" maxlength="2000" style="width:400px;"/>
            <g:submitButton name="create" class="button" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </div>
        </br>
        <div class="shortLinkResult">
            <g:if test="${shortLink}">
                <g:message code="shortLink.link.label" default="Link corto: "/> <a href="${shortLink.link}">${shortLink.link}</a>
            </g:if>
        </div>
    </div>
</g:form>
</body>
</html>