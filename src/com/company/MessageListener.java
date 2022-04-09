package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListener {
    public static Map<String, Method> methodMap = new HashMap<>();
    public static CommandListener commandListener =new CommandListener();
    static{
        for(Method m: commandListener.getClass().getDeclaredMethods()){
            if(m.isAnnotationPresent(Command.class)){
                Command com = m.getAnnotation(Command.class);
                methodMap.put(com.name(),m);
                for (String a:com.aliases()) {
                    methodMap.put(a,m);
                }
            }
        }
    }
    public void onMessageReceived(String message) throws InvocationTargetException, IllegalAccessException {
        String[] messageParts=message.split(" ");
        if(messageParts[0].toLowerCase().equals("!")){
            String command = messageParts[1].toLowerCase();
            String[] args = Arrays.copyOfRange(messageParts, 2, messageParts.length);
            methodMap.get(command).invoke(commandListener, args);
        }
    }
}
