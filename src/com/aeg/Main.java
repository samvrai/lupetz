package com.aeg;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Renombrando ficheros en " + args[0]);
        System.out.println("Seguro? s/n");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.next();
        if (ans.equals("s")) {
            File dir = new File(args[0]);
            File[] fs = dir.listFiles();

            int i = 1;
            for (File f : fs) {
                String name = f.getName();
                String[] dns = name.split("\\.");
                dns[0] = dns[0] + "_" + i;
                File fx = new File(dir + File.separator + dns[0] + "." + dns[1]);
                if (f.renameTo(fx))
                    System.out.println("Renombrado: " + name + " a " + fx.getName());
                else
                    System.out.println("Renombrado fallido:" + name + " a " + fx.getName());
                i++;
            }
        }
    }
}
