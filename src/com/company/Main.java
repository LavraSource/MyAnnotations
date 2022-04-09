package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MessageListener messageListener = new MessageListener();
        for (int i = 0; i < 5; i++) {
            try {
                messageListener.onMessageReceived(new Scanner(System.in).nextLine());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
