package org.bedoing.commons;


import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {

        sayHello("first 1", "test 1", (msg) -> {
            System.out.println(msg);
        }, (msg) -> {
            System.out.println(msg);
        });
        sayHello("first 2", "test 2", (msg) -> {
            System.out.println(msg.toUpperCase());
        }, (msg) -> {
            System.out.println(msg);
        });
        sayHello("first 3", "test 3", (msg) -> {
            System.out.println(msg.replaceAll("o", "0"));
        }, (msg) -> {
            System.out.println(msg);
        });
    }

    public static void sayHello(String a, String msg, Consumer<String> callback, Consumer<String> callback2) {
        callback.accept(msg);
        callback2.accept(msg.toUpperCase());
    }

    public static void testPatchVehicle(String prefix, Map<String, String> m, Consumer<Map<String, String>> reqCallback, Consumer<Map<String, String>> respCallback) {
        reqCallback.accept(m);
        respCallback.accept(m);
    }
}