package com.jaume.penjat;

import java.util.Arrays;

public class Tauler {
    private String paraulaSecreta;
    private int intents;
    private String[] paraulaEncertada;
    private int vides;


    /**
     * Constructor methods
     */
    public Tauler(){
    }


    /**
     * Initialize methods
     */
    public void inicialitzarPartida(String paraula, int intents) {
        this.paraulaSecreta = paraula;
        this.intents = intents;
        this.vides = intents;
        paraulaEncertada = new String[paraulaSecreta.length()];
    }


    /**
     * Functional methods
     */
    public String verificar(String letra) {
        boolean isInList = false;
        if (letra.length() == 1){
            for (int i = 0; i < getParaulaSecreta().length; i++){
                if (letra.equals(Character.toString(getParaulaSecreta()[i]))) {
                    paraulaEncertada[i] = letra;
                    isInList = true;
                }
            }
            if (!isInList){
                this.vides --;
            }
            return imprimir();
        } else {
            return "Lletra incorrecte";
        }
    }

    public boolean hasGuanyat() {
        return Arrays.equals(getPalabraEndevinada(), paraulaSecreta.split(""));
    }



    /**
     * Graphic methods
     */
    public String imprimir() {
        String paraulaMostrar = "";
        for (int i = 0; i < getPalabraEndevinada().length; i++) {
            if (getParaulaSecreta()[i] == " ".toCharArray()[0]) {
                paraulaMostrar = paraulaMostrar + " ";
            } else if (getPalabraEndevinada()[i] == null){
                paraulaMostrar = paraulaMostrar + "_";
            } else {
                paraulaMostrar = paraulaMostrar + getPalabraEndevinada()[i];
            }
        }
        return paraulaMostrar;
    }

    public String imprimirVides() {
        if (vides == 1){
            return "Et queda " + vides + " vida de " + intents;
        } else {
            return "Et queden " + vides + " vides de " + intents;
        }
    }


    /**
     * DTO after this line
     */
    //Getters for the instance variables
    public char[] getParaulaSecreta(){
        return paraulaSecreta.toCharArray();
    }

    public int getIntents() {
        return vides;
    }

    public String[] getPalabraEndevinada(){
        return paraulaEncertada;
    }
}
