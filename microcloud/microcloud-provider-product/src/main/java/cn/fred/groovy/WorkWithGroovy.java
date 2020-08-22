package cn.fred.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * Java调用groovy脚本示例
 */
public class WorkWithGroovy {

    private static void simpleReturnWithIntegerParam() {
        Binding binding = new Binding();
        binding.setVariable("foo", new Integer(2));
        GroovyShell shell = new GroovyShell(binding);

        String script = "def a = 12; println 'a is ' + a; "
                + "return foo * a; ";
        Object value = shell.evaluate(script);
        System.out.println("simpleReturnWithIntegerParam:" + value.toString());
    }

    private static void returnWithStringParam() {
        String body = "{\"errCode\":\"4000\"}";
        Binding binding = new Binding();
        binding.setVariable("body", body);
        String script = "import groovy.json.JsonSlurper;"
                + "def getTitle(String jsonStr) { return new JsonSlurper().parseText(jsonStr).errCode; }; "
                + "getTitle(body); ";
        Object result = new GroovyShell(binding).evaluate(script);
        System.out.println("returnWithStringParam:" + result.toString());
    }

    public static void main(String[] args) {
        simpleReturnWithIntegerParam();
        returnWithStringParam();
    }
}
