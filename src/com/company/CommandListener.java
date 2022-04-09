package com.company;

import java.lang.reflect.Method;
import java.util.Scanner;

public class CommandListener {
    @Command(name="hello",
    desc="Say Hello",
    args="",
    aliases = {"hi"}
    )
    public void hello(){
        System.out.println("Hello!");
    }
    @Command(name="bye",
            desc="Say bye",
            args="",
            aliases = {"goodbye"}
    )
    public void bye(){
        System.out.println("Goodbye! ):");
    }
    @Command(name="help",
            desc="Command list",
            args="",
            aliases = {"commands"}
    )
    public void help(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Method m: this.getClass().getDeclaredMethods()){
            if(m.isAnnotationPresent(Command.class)){
                Command com = m.getAnnotation(Command.class);
                stringBuilder.append(com.name()).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
    @Command(name="play",
            desc="Play a game",
            args="",
            aliases = {"game"}
    )
    public void game(){
        Scanner sc= new Scanner(System.in);
        int[][] field={
                {0,1,0,0,0},
                {0,0,0,1,0},
                {0,1,0,1,0},
                {1,1,1,0,0},
                {2,0,0,0,1}
        };
        int[] player={0,0};
        while(field[player[0]][player[1]]!=2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(i==player[0]&&j==player[1]){
                        System.out.print("@");
                    } else {
                        if (field[i][j] == 0) {
                            System.out.print(".");
                        }
                        if (field[i][j] == 1) {
                            System.out.print("#");
                        }
                        if (field[i][j] == 2) {
                            System.out.print("*");
                        }
                    }
                }
                System.out.println();
            }
            switch (sc.next()) {
                case "up":
                    try {
                        if (field[player[0] - 1][player[1]] != 1) {
                            player[0] -= 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    break;
                case "down":
                    try {
                        if (field[player[0] + 1][player[1]] != 1) {
                            player[0] += 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    break;
                case "left":
                    try {
                        if (field[player[0]][player[1]-1] != 1) {
                            player[1] -= 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    break;
                case "right":
                    try {
                        if (field[player[0]][player[1]+1] != 1) {
                            player[1] += 1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    break;
            }

        }
        System.out.println("You won!");
    }
}