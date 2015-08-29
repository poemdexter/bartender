package bartender.controller

import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice

/**
 * Enables JSONP on all controllers.
 */
@ControllerAdvice
@CompileStatic
@SuppressWarnings('GroovyUnusedDeclaration')
class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    JsonpAdvice() {
        super('jsonp', 'callback', 'fn')
    }
}