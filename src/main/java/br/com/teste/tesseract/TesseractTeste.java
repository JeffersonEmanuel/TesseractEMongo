/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.tesseract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jefferson
 */
public class TesseractTeste {

   
    
    public void pegarPalavrasDeImagem(String caminhoImagem) {

               //         System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");
//        File imageFile = new File("/home/jefferson/frases-e-mensagens-de-motivacao-para-facebook.jpg");
//        TesseractTeste instance = TesseractTeste.getInstance();  // JNA Interface Mapping
//        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
//
//        try {
//            String result = instance.doOCR(imageFile);
//            System.out.println(result);
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//        }
//        caminhoImagem = "/home/jefferson/frases-e-mensagens-de-motivacao-para-facebook.jpg";
        
        String caminhoGravarTexto = "/home/jefferson/tempOCR";
        caminhoImagem += ".jpg";
        try {
            Runtime.getRuntime().exec("tesseract " + caminhoImagem + " " + caminhoGravarTexto);
        } catch (IOException ex) {
            Logger.getLogger(TesseractTeste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String lerArquivo(String caminhoImagem) {

        pegarPalavrasDeImagem(caminhoImagem);
        BufferedReader br = null;
        String variavelDeRetorno = "";
        String caminhoLerTexto = "/home/jefferson/tempOCR.txt";
        try {
            br = new BufferedReader(new FileReader(caminhoLerTexto));
            StringBuilder sb = new StringBuilder();
            String linhaTexto = br.readLine();

            while (linhaTexto != null) {
                sb.append(linhaTexto);
                sb.append(System.lineSeparator());
                linhaTexto = br.readLine();
            }
            
            variavelDeRetorno = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return variavelDeRetorno;
    }
   
    public List<String> separarPalavra(String caminhoImagem) {
         
        StringTokenizer st = new StringTokenizer(lerArquivo(caminhoImagem), " ");
        List<String>  list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        return list;
    }

    
}
