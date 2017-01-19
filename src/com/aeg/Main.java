package com.aeg;

import java.io.File;
import java.nio.file.Files;
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
        scanner.nextLine();
        switch (entry) {
            case 1:
                modifier();
            case 0:
                System.exit(0);
            default:
                System.out.print("Opción no existe");
                menu();
        }
    }

    private static void modifier() {
        System.out.println("*****Modificador de archivos******");
        System.out.println("Ruta de la carpeta:");
        String path = scanner.nextLine();
        System.out.println("Reemplazar en otra carpeta: s/n");
        String aux = scanner.nextLine();
        System.out.println("Configurar:");
        String del = scanner.nextLine();
        if (del.equals("s")) {
            System.out.println("Tipo de documento:");
            String type = scanner.nextLine().toUpperCase();
            System.out.println("Aplicacion:");
            String app = scanner.nextLine().toUpperCase();
            System.out.println("Carpeta " + path + " || " + type + ".000." + app + ".#######" + " || Reemplazo: " + aux);
            System.out.println("Seguro? s/n");
            String ans = scanner.nextLine();
            if (ans.equals("s")) {
                print(aux, path, type, app);
            }
        } else {
            System.out.println("Carpeta " + path + " || 000.#######" + " || Reemplazo: " + aux);
            System.out.println("Seguro? s/n");
            String ans = scanner.nextLine();
            if (ans.equals("s")) {
                print(aux, path, null, null);
            }
        }
        System.out.println("Ejecución correcta.");
        menu();
    }

    private static void print(String aux, String path, String type, String app) {
        File folder2 = null;
        if (aux.equals("s")) {
            folder2 = new File(path + "_REEMPLAZO");
            folder2.mkdirs();
        }
        File dir = new File(path);
        File[] fs = dir.listFiles();
        int i = 1;
        for (File f : fs) {
            String nf = "";
            if(type == null && app == null) nf += i + "." + f.getName();
            else nf += type + "." + i + "." + app + "." + f.getName();
            File fx;
            if (aux.equals("s")) {
                fx = new File(folder2 + File.separator + nf);
            } else {
                fx = new File(dir + File.separator + nf);
            }
            try {
                if (aux.equals("s"))
                    Files.copy(f.toPath(), fx.toPath());
                else
                    f.renameTo(fx);
                System.out.println("Renombrado: " + f.getName() + " a " + fx.getName());
            } catch (Exception e) {
                System.out.println("Renombrado fallido:" + f.getName() + " a " + fx.getName());
            }
            i++;
        }
    }
}
