package com.scratch.app;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;

public class NashornSample {

    private static final String JS_SCRIPT = "jscode.js";
    public String ID = UUID.randomUUID().toString();

    public static String process(String var) {
        return var.toUpperCase();
    }

    public static String getJsScriptContent() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path platformIndependentPath = Paths.get(classloader.getResource(JS_SCRIPT).toURI());
        return new String(Files.readAllBytes(platformIndependentPath));
    }

    public static void main(String[] ss) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        Bindings bindings = new SimpleBindings(Stream.of(
                new SimpleEntry<>("name", "Raphael"),
                new SimpleEntry<>("surname", "Moita"),
                new SimpleEntry<>("numbers", Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                new SimpleEntry<>("javaObj", new NashornSample()))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));
        Object result = engine.eval(getJsScriptContent(), bindings);
        System.out.println(result.toString());
    }
}
