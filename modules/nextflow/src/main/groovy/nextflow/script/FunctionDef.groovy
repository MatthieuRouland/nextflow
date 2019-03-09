package nextflow.script

import java.lang.reflect.Method

import groovy.transform.CompileStatic
/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */

@CompileStatic
class FunctionDef extends ComponentDef {

    private BaseScript owner

    private Method method

    private String name

    FunctionDef(BaseScript owner, Method method) {
        this.owner = owner
        this.method = method
        this.name = method.name
    }

    protected FunctionDef() { }

    String getType() { 'function' }

    Method getMethod() { method }

    String getName() { name }

    BaseScript getOwner() { owner }

    Object invoke_a(Object[] args) {
        method.invoke(owner, args)
    }

    FunctionDef clone() {
      return (FunctionDef)super.clone()
    }

    FunctionDef withName(String name) {
        def result = clone()
        result.@name = name
        return result
    }
}