/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aguil
 */
public class Trie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Triee trie = new Triee(generarAbecedario());
        /*
        trie.agrega("ana");
        trie.agrega("an");
        trie.agrega("andrea");
        trie.agrega("maria.");
        trie.agrega("sergio");
        trie.agrega("dolores");
        trie.agrega("andy");
        
        System.out.println(trie.busca("an"));
        System.out.println(trie.busca("ana"));
        System.out.println(trie.busca("andrea"));
        System.out.println(trie.busca("dolores"));
        
        System.out.println(trie.borra("an"));
        
        System.out.println(trie.busca("an"));
        System.out.println(trie.busca("ana"));
        System.out.println(trie.busca("andrea"));
              
        
        trie.recorre();
                */
        
        //trie.llenaYrecorre("‪../../wiki-100k.txt");
        
        
        llenayRMixcoac("C:\\Users\\aguil\\OneDrive\\Documents\\Compu\\Estructura de Datos\\Trie\\wiki-100k.txt");
        
        
    }
    
    private static Character[] generarAbecedario()
    {

        Character[] abc = new Character[223];

 

        for(int i= 33; i<= 254;i++)

        {

            abc[i-33]=(char)i;

        }

        return abc;

    }
    
    private static void mixcoacMergeSort(String a[], int izq, int der){
        int mitad = (der + izq) / 2;
        if(izq >= der - 1){
            return;
        }
        mixcoacMergeSort(a, izq, mitad);
        mixcoacMergeSort(a, mitad, der);

        for(int i = izq; i < der; i++){
            if(a[i].compareTo(a[i+1]) > 0){
                String aux = a[i];
                a[i] = a[i+1];
                a[i+1] = aux;
            }
        }
    }
    
     public static void llenayRMixcoac(String dir)
    {
        try
        {
            Scanner archivo;
            File file;
            file = new File(dir);
            archivo = new Scanner(file);
            String[] arr = new String[5000000];
            int i = 0;
            
            while(archivo.hasNext())
            {
                arr[i] = archivo.next();
                i++;
            }
            for(int e = 0 ; e< i-1; e++)
            {
                System.out.println(arr);
            }
            mixcoacMergeSort(arr, 0, i-1);
            
            for(int e = 0 ; e< i-1; e++)
            {
                System.out.println(arr);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(-1);
        }
    }

 

    
}
