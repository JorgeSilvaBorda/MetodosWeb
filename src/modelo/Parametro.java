package modelo;

/**
 * Un par ordenado de atributo y su valor.
 * @author Jorge Silva Borda
 */
public class Parametro {
    
    private String atributo;
    private String valor;
    
    /**
     * Constructor vacío.
     */
    public Parametro(){
	
    }
    
    /**
     * Constructor conmpleto.
     * @param atributo {@link String} con el nombre del atributo.
     * @param valor {@link String} con el valor del atributo.
     */
    public Parametro(String atributo, String valor){
	this.atributo = atributo;
	this.valor = valor;
    }

    /**
     * @return {@link String} con el nombre del atributo.
     */
    public String getAtributo() {
	return atributo;
    }
    
    /**
     * Inserta el nombre del atributo.
     * @param atributo {@link String} con el nombre del atributo.
     */
    public void setAtributo(String atributo) {
	this.atributo = atributo;
    }

    /**
     * @return {@link String} con el valor del atributo.
     */
    public String getValor() {
	return valor;
    }

    /**
     * Inserta el valor del atributo.
     * @param valor {@link String} con el valor del atributo.
     */
    public void setValor(String valor) {
	this.valor = valor;
    }
}
