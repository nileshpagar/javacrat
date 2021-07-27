package com.javacrat.devices;

import java.awt.Robot;
import java.io.Console;
import java.util.Scanner;

import static java.awt.event.KeyEvent.*;

public class Main {
    public static void main(String[] argv) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();
        robot.keyPress(VK_A);
        robot.keyRelease(VK_A);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
        System.out.println(scanner.next());
    }
}