package modelo;

import java.util.LinkedList;

/**
 * Colección de {@link modelo.Parametro}.
 * Entrega los parámetros ordenados de la forma "atributo=valor" para ser 
 * utilizados en conexiones en URL's.
 * @author Jorge Silva Borda
 */
public class Parametros {
    
    private LinkedList<Parametro> params;
    
    /**
     * Constructor vacío.
     */
    public Parametros(){
	
    }
    
    /**
     * Agrega parámetros a la secuencia.
     * @param param {@link modelo.Parametro}
     */
    public void addParametro(Parametro param){
	this.params.add(param);
    }
    
    /**
     * Construye el {@link String} de los parámetros para poder ser insertados
     * en una URL determinada.
     * @return {@link String} con la secuencia de parámetros.
     */
    public String construirParámetros(){
	
	if(this.params.size() <= 0){
	    return "";
	}
	String salida = "";
	for(Parametro p : this.params){
	    salida = salida + p.getAtributo() + "=" + p.getValor() + "&";
	}
	return salida.substring(0, salida.length() - 1);
    }
    
}
