import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_board_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'apple-touch-icon.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'apple-touch-icon-retina.png'))
printHtmlPart(5)
invokeTag('stylesheet','asset',15,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',16,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',17,[:],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',22,['controller':("login")],3)
printHtmlPart(8)
createClosureForHtmlPart(10, 3)
invokeTag('connect','oauth',23,['provider':("google"),'id':("google-connect-link")],3)
printHtmlPart(8)
createClosureForHtmlPart(11, 3)
invokeTag('connect','oauth',24,['provider':("facebook"),'id':("facebook-connect-link")],3)
printHtmlPart(12)
})
invokeTag('ifNotLoggedIn','sec',25,[:],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(8)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',27,['controller':("user"),'action':("show")],3)
printHtmlPart(8)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',28,['controller':("logout")],3)
printHtmlPart(12)
})
invokeTag('ifAnyGranted','sec',29,['roles':("ROLE_USER")],2)
printHtmlPart(15)
invokeTag('layoutBody','g',31,[:],-1)
printHtmlPart(16)
invokeTag('message','g',33,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',34,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500360146920L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
