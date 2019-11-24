/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author aguil
 */
public class Triee<T extends Comparable<T>> {
    
    NodoTrie<T> raiz;
    Character[] simbolos;
    
    Triee(Character[] sim)
    {
        simbolos = sim;
        raiz = new NodoTrie(simbolos);
    }
    
    public boolean busca(String llave)
    {
        return busca(llave, raiz);
    }
    
    private boolean busca(String llave, NodoTrie actual)
    {
        if(actual == null)
        {
            return false;
        }
        
        if(llave.equals(""))
            return actual.getfinPalabra();
        
        try
        {
            return busca(llave.substring(1), actual.getSig(llave.charAt(0)));
        }
        catch(Exception e)
        {
            return false; 
        }
    }
    
    public void agrega(String llave)
    {
        agrega(llave, raiz);
    }
    
    private void agrega(String llave, NodoTrie actual)
    {   
        if(actual == null)
        {
            return;
        }
        
        if(llave.equals(""))
        {
            actual.setFin(true);
            return;
        }
        
        try
        {
            NodoTrie<T> sig = actual.getSig(llave.charAt(0));
            if( sig == null)
            {
                sig = new NodoTrie(simbolos);
                actual.setSig(llave.charAt(0), sig);
            }
            agrega(llave.substring(1),actual.getSig(llave.charAt(0)));
        }
        catch(Exception e)
        {
            
        }
        
    }
    
    public NodoTrie borra(String llave)
    {
        return borra(llave, raiz);
    }
   
    private NodoTrie borra(String llave, NodoTrie actual)
     {
        boolean vacio;
        if(actual == null)
        {
            return null;
        }
        
        if(llave.equals(""))
        {
            actual.setFin(false);
            vacio = actual.estaVacio();
            if(vacio)
            {
                return null;
            }
            else
                return actual;
        }
        
        try
        {
            char simbolo = llave.charAt(0);
            NodoTrie sig = actual.getSig(simbolo);
            NodoTrie temp = borra(llave.substring(1), sig);
            actual.setSig(simbolo, temp);
        }
        catch(Exception e)
        {
            
        }
        
        if(!actual.getfinPalabra() && actual.estaVacio() )
            return null;
        
        return actual; 
    }
    
    public void recorre()
    {
        recorre(raiz, "");
    }
    
    private void recorre(NodoTrie actual, String texto)
    {
        String ntexto;
        if(actual.getfinPalabra() == true)
        {
            System.out.println(texto);
        }
        for(int i  = 0; i< simbolos.length; i++)
        {   
            try
            {
                if(!actual.disponible(i))
                {
                    ntexto = texto + simbolos[i];
                    recorre(actual.getSig(simbolos[i]),ntexto);
                }
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    //C:\Users\aguil\OneDrive\Documents\wiki-100k.tx
    public void llenaYrecorre(String dir)
    {
        try
        {
            Scanner archivo;
            File file;
            file = new File(dir);
            archivo = new Scanner(file);
            
            while(archivo.hasNext())
            {
                this.agrega(archivo.next());
            }
        }
        catch(Exception fnfe)
        {
            System.out.println(fnfe);
            System.exit(-1);
        }
        
        this.recorre();
    }
    
}
