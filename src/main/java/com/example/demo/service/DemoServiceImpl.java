package com.example.demo.service;


import java.util.*;

public class DemoServiceImpl implements DemoService{

    /*
    devuelve true o false si el código de producto comienza con las letras 'P' o 'W'
    */
    public boolean esPrioritario(String codigo){
        char primerLetra = codigo.charAt(0);

        if (primerLetra == 'P' || primerLetra == 'W'){
            return true;
        }
        return false;
    };

    /*
    chequea si el dígito verificador es correcto
    devuelve true o false si el dígito verificador es correcto.
    */
    public boolean verificar(String codigo){
        char ultimoDigito = codigo.charAt(10);
        int ultimoDigitoInteger = Character.getNumericValue(ultimoDigito);

        String codigoIntermedio = "";

        for (int i = 4; i < 9; i++) {
            codigoIntermedio = codigoIntermedio + codigo.charAt(i);
        }

        int numeroIntermedio = Integer.parseInt(codigoIntermedio);

        int digitoVerificador = this.calcularDigito(numeroIntermedio);

        if (digitoVerificador == ultimoDigitoInteger){
            return true;
        }
        return false;
    };

    private int calcularDigito(int numeroIntermedio) {
        int sum = String.valueOf(numeroIntermedio)
                .chars()
                .map(Character::getNumericValue)
                .sum();

        if (isNotSingleDigit(sum)){
            calcularDigito(sum);
        }

        return sum;
    };

    private boolean isNotSingleDigit(int number){
        if (number > 9 || number < 0){
            return true;
        }
        return false;
    };

    /*
    recibe una lista de productos (lista/array de los códigos)
    las ordena alfabéticamente según su código alfabético (XXX), de menor a mayor.
    */
    public String[] ordenarCodigos(String[] codigos){
        Arrays.sort(codigos, Comparator.reverseOrder());
        return codigos;
    };

    /*
    recibe 2 listas de productos (listas/arrays de los códigos)
    devuelve una lista/array que representa la Unión de los elementos.
    */
    public String[] unirCodigos(String[] lista1, String[] lista2){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < lista1.length; i++) {
            set.add(lista1[i]);
        }

        for (int i = 0; i < lista2.length; i++) {
            set.add(lista2[i]);
        }

        return set.toArray(new String[set.size()]);
    };

    /*
    recibe 2 listas de productos (listas/arrays de los códigos)
    devuelve una lista/array que representa la Intersección de los elementos.
    */
    public String[] intersectarCodigos(String[] lista1, String[] lista2){
        Set<String> s1 = new HashSet<String>(Arrays.asList(lista1));
        Set<String> s2 = new HashSet<String>(Arrays.asList(lista2));
        s1.retainAll(s2);

        return s1.toArray(new String[s1.size()]);
    };

}
