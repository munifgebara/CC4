/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fafiman.cc4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author munifgebarajunior
 */
public class CC4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            String arquivos[] = {"teste0.CC4", "teste1.CC4", "teste2.CC4", "teste3.CC4", "teste4.CC4", "teste5.CC4"};
            for (String arquivo : arquivos) {
                List<String> tokens = getTokens("exemplos/"+arquivo);
                for (String s : tokens) {
                    System.out.println(s);
                }
                System.out.println("\n\n");
            }
            

        } else if (args.length == 1) {
            System.out.println("Compilando " + args[0]);
            //mostraArquivo(args[0]);
            List<String> tokens = getTokens(args[0]);
            for (String s : tokens) {
                System.out.println(s);
            }

        } else {
            System.out.println("Você deve utilizar java CC4 nomedoarquivo.cc4");
        }
    }

    private static List<String> getTokens(String nomeArquivo) {
        List<String> aRetornar = new ArrayList<>();
        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linha, "^ =*,+-/<>", true);
                String aspas = null;
                while (st.hasMoreTokens()) {
                    String tk = st.nextToken();
                    if (tk.startsWith("\"")) {

                        aspas = tk;
                        continue;
                    } else if (tk.endsWith("\"")) {

                        tk = aspas + tk;
                        aspas = null;
                    } else if (aspas != null) {

                        aspas = aspas + tk;
                        continue;
                    } else {
                        tk = tk.trim();
                    }
                    if (tk.isEmpty()) {
                        continue;
                    }
                    aRetornar.add(tk);
                }
                String tk = "|ENTER|";
                aRetornar.add(tk);
            }
        } catch (Exception ex) {
            System.out.println("Arquivo não encontrado:" + nomeArquivo);
        }
        return aRetornar;
    }

    private static void mostraArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Arquivo não encontrado:" + nomeArquivo);
        }
    }

}
