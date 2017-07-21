import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-oauth', version='2.1.0-RC4')
class gsp_springSecurityOauth_springSecurityOAuthaskToLinkOrCreateAccount_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-oauth-2.1.0-RC4/grails-app/views/springSecurityOAuth/askToLinkOrCreateAccount.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
invokeTag('set','g',2,['var':("layoutName"),'value':(grailsApplication.config.grails?.plugin?.springsecurity?.oauth?.layout)],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':(layoutName ?: 'main')],-1)
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(1)
expressionOut.print(layoutName)
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (flash.error)) {
printHtmlPart(5)
expressionOut.print(flash.error)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('message','g',50,['code':("springSecurity.oauth.registration.link.not.exists"),'default':("No user was found with this account."),'args':([session.springSecurityOAuthToken?.providerName])],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('renderErrors','g',55,['bean':(createAccountCommand),'as':("list")],-1)
printHtmlPart(10)
})
invokeTag('hasErrors','g',57,['bean':(createAccountCommand)],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',61,['code':("springSecurity.oauth.registration.create.legend"),'default':("Create a new account")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: createAccountCommand, field: 'username', 'error'))
printHtmlPart(14)
invokeTag('message','g',63,['code':("OAuthCreateAccountCommand.username.label"),'default':("Username")],-1)
printHtmlPart(15)
invokeTag('textField','g',64,['name':("username"),'value':(createAccountCommand?.username)],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: createAccountCommand, field: 'password1', 'error'))
printHtmlPart(17)
invokeTag('message','g',67,['code':("OAuthCreateAccountCommand.password1.label"),'default':("Password")],-1)
printHtmlPart(15)
invokeTag('passwordField','g',68,['name':("password1"),'value':(createAccountCommand?.password1)],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: createAccountCommand, field: 'password2', 'error'))
printHtmlPart(18)
invokeTag('message','g',71,['code':("OAuthCreateAccountCommand.password2.label"),'default':("Password re-type")],-1)
printHtmlPart(15)
invokeTag('passwordField','g',72,['name':("password2"),'value':(createAccountCommand?.password2)],-1)
printHtmlPart(19)
invokeTag('submitButton','g',74,['name':(message(code: 'springSecurity.oauth.registration.create.button', default: 'Create'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',76,['action':("createAccount"),'method':("post"),'autocomplete':("off")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('renderErrors','g',82,['bean':(linkAccountCommand),'as':("list")],-1)
printHtmlPart(10)
})
invokeTag('hasErrors','g',84,['bean':(linkAccountCommand)],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',88,['code':("springSecurity.oauth.registration.login.legend"),'default':("Link to an existing account")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: linkAccountCommand, field: 'username', 'error'))
printHtmlPart(14)
invokeTag('message','g',90,['code':("OAuthLinkAccountCommand.username.label"),'default':("Username")],-1)
printHtmlPart(15)
invokeTag('textField','g',91,['name':("username"),'value':(linkAccountCommand?.username)],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: linkAccountCommand, field: 'password', 'error'))
printHtmlPart(22)
invokeTag('message','g',94,['code':("OAuthLinkAccountCommand.password.label"),'default':("Password")],-1)
printHtmlPart(15)
invokeTag('passwordField','g',95,['name':("password"),'value':(linkAccountCommand?.password)],-1)
printHtmlPart(19)
invokeTag('submitButton','g',97,['name':(message(code: 'springSecurity.oauth.registration.login.button', default: 'Login'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',99,['action':("linkAccount"),'method':("post"),'autocomplete':("off")],2)
printHtmlPart(21)
createTagBody(2, {->
invokeTag('message','g',103,['code':("springSecurity.oauth.registration.back"),'default':("Back to login page")],-1)
})
invokeTag('link','g',103,['controller':("login"),'action':("auth")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400534910480L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
