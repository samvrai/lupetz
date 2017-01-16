package com.aeg;

import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int entry = -1;
        System.out.println("**********************************");
        System.out.println("____________REFACTOR______________");
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1.- Modificador de archivos");
        System.out.println("0.- Salir");

        System.out.println("Opcion: ");
        entry = scanner.nextInt();

        switch (entry) {
            case 1: modifier();
            case 0: System.exit(0);
            default:
                System.out.print("Opción no existe");
                menu();
        }
    }

    private static void modifier() {
        System.out.println("*****Modificador de archivos******");
        System.out.println("Ruta de la carpeta:");
        String path = scanner.next();
        System.out.println("Tipo de documento:");
        String type = scanner.next().toUpperCase();
        System.out.println();
        System.out.println("Aplicacion:");
        String app = scanner.next().toUpperCase();
        System.out.println();
        System.out.println("Reemplazar en otra carpeta: s/n");
        String aux = scanner.next();
        System.out.println("Carpeta " + path + " || " + type + ".000." + app + ".#######" + " || Reemplazo: " + aux);
        System.out.println("Seguro? s/n");
        String ans = scanner.next();
        if (ans.equals("s")) {
            File folder2 = null;
            if(aux.equals("s")) {
                folder2 = new File(path + "_REEMPLAZO");
            }
            File dir = new File(path);
            File[] fs = dir.listFiles();
            int i = 1;
            for (File f : fs) {
                String name = f.getName();
                String[] dns = name.split("\\.");
                dns[dns.length - 2] = dns[dns.length - 2] + "_" + i;
                String nf = "";
                for(String s: dns) {
                    nf += s + ".";
                }
                nf = nf.substring(0, nf.length() -1);
                File fx = null;
                if(aux.equals("s")) {
                    fx = new File(dir + nf);
                } else {
                    fx = new File(dir + nf);
                }
                try {
                    f.renameTo(fx);
                    System.out.println("Renombrado: " + nf + " a " + fx.getName());
                } catch (Exception e) {
                    System.out.println("Renombrado fallido:" + nf + " a " + fx.getName());
                }
                i++;
            }
        }
        System.out.println("Ejecución correcta.");
        menu();
    }
}
