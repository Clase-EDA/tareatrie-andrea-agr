/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author aguil
 */
public class NodoTrie <T extends Comparable <T>> {
    
    boolean finPalabra;
    private NodoTrie[] arrHijos;
    public static Character[] simbolos;
    private T dato;
    
    public NodoTrie(Character[] simbolos){
        
        this.simbolos = simbolos;
        arrHijos = new NodoTrie[simbolos.length];
        
    }
    
    public boolean getfinPalabra()
    {
        return finPalabra;
    }
    
    public void setFin(boolean dat)
    {
        finPalabra = dat;
    }
    
    public void setSig(char l, NodoTrie <T> nodo)throws Exception
    {
        int i = 0;
        while(i< this.simbolos.length && l!= simbolos[i])
        {
            i++;
        }
        
        if(i == simbolos.length)
        {
            throw new Exception("no existe el simbolo");
        }
        
        arrHijos[i] = nodo;
    }
    
    public NodoTrie getSig(char l) throws Exception
    {
        int i = 0;
        while(i< this.simbolos.length  && l != simbolos[i])
        {
         i++;
        }
        
        if(i== simbolos.length)
        {
            throw new Exception("no existe el símbolo");
        }
        return arrHijos[i];
    }
    
    public boolean disponible(int i)throws Exception
    {
        if( i < this.simbolos.length)
        {
            if(arrHijos[i] == null)
                return true;
            else
                return false;
        }
        else
            throw new Exception("El arreglo no es tan grande");
    }
    
    public boolean estaVacio()
    {
        int i = 0;
        while(i< arrHijos.length && arrHijos[i] == null)
        {
            i++;
        }
        
        if(i >= arrHijos.length)
        {
            return true;
        }
        else
            return false;
    }
      
}
