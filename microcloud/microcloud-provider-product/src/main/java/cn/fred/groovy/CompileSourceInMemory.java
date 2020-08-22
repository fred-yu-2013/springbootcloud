package cn.fred.groovy;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;

/**
 * 本例子演示了，如何编译字符串定义的类，然后执行它：
 *  1. 加载类
 *  2. 创建实例，并执行
 *
 * 若想获取返回值，请在Java里面定义借口，字符串代码里面实现它
 *  2. 创建实例，转成接口对象，然后执行接口方法
 */
public class CompileSourceInMemory {
    public static void main(String args[]) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        String clsName = "HelloWorld";
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.println("import cn.fred.groovy.CompileSourceInMemory.HelloWorldBase;");
        out.println("public class HelloWorld implements HelloWorldBase {");
        out.println("  @Override");
        out.println("  public void doIt() {System.out.println(\"This is in HelloWorld.doIt()\");}");
        out.println("  public static void main(String args[]) {");
        out.println("    System.out.println(\"This is in another java file\");");
        out.println("  }");
        out.println("}");
        out.close();
        SimpleJavaFileObject file = new JavaSourceFromString(clsName, writer.toString());

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);

        boolean success = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));
        }
        System.out.println("Success: " + success);
        if (success) {
            try {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
                classLoader.loadClass(clsName).getDeclaredMethod("main", new Class[] { String[].class })
                        .invoke(null, new Object[] { null });
                HelloWorldBase base = (HelloWorldBase) classLoader.loadClass(clsName).newInstance();
                base.doIt();
            } catch (ClassNotFoundException e) {
                System.err.println("Class not found: " + e);
            } catch (NoSuchMethodException e) {
                System.err.println("No such method: " + e);
            } catch (IllegalAccessException e) {
                System.err.println("Illegal access: " + e);
            } catch (InvocationTargetException e) {
                System.err.println("Invocation target: " + e);
            } catch (InstantiationException e) {
                System.err.println("New instance filed: " + e);
            }
        }
    }

    public interface HelloWorldBase {
        void doIt();
    }
}

class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}