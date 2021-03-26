package com.example.demo.service;

public interface DemoService {
    boolean esPrioritario(String codigo);

    boolean verificar(String codigo);

    String[] ordenarCodigos(String[] codigos);

    String[] unirCodigos(String[] lista1, String[] lista2);

    String[] intersectarCodigos(String[] lista1, String[] lista2);
}