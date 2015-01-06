/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.main;

import br.com.teste.mongo.MongoTeste;
import br.com.teste.tesseract.TesseractTeste;

/**
 *
 * @author jefferson
 */
public class Main {

    public static void main(String[] args) {

        TesseractTeste tesseract = new TesseractTeste();
        MongoTeste mongo = new MongoTeste();
//        tesseract.separarPalavra("/home/jefferson/Defesa-A-caracterização-do-documento-jurídico-para-a-organização-da-informação.jpg");
//        mongo.salvarPorTermo("/home/jefferson/Defesa");
        mongo.buscar("complexos");

    }

}
