<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="create.shortLink.tittle.label"/></title>
</head>
<body>
<g:form controller="shortLink" action="createShortLink">
    <div id="create-shortLink" class="content">
        <h1><g:message code="create.shortLink.label"/></h1>
        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <g:if test="${shortLink?.hasErrors()}">
            <g:hasErrors bean="${shortLink}">
                <div class="errors">
                    <g:renderErrors bean="${shortLink}" as="list"/>
                </div>
            </g:hasErrors>
        </g:if>
        <div class="fieldcontain ${hasErrors(bean: shortLink, field: 'targetUrl', 'error')} ">
            <label><g:message code="shortLink.targetUrl.label" default="Target Url" /></label>
            <g:textField name="targetUrl" class="createLinkTextField" maxlength="2001" style="width:500px;"/>
        </div>
        <div class="createShortLinkButton"><g:submitButton name="save" class="createLinkButton" value="${message(code: 'default.button.create.label', default: 'Create')}"/></div>

        </br>
        <g:if test="${shortLink && !shortLink?.hasErrors()}">
            <div class="shortLinkResult">
                <g:message code="shortLink.link.label" default="Link corto: "/> <a href="${shortLink.link}">${shortLink.link}</a>
            </div>
        </g:if>
    </div>
</g:form>
</body>
</html>
