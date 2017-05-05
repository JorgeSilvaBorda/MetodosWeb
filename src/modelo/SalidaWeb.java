package modelo;

public class SalidaWeb {
    
    private int codSalida;
    private String contenido;
    
    public SalidaWeb(){
	
    }
    
    public SalidaWeb(int codSalida, String contenido){
	this.codSalida = codSalida;
	this.contenido = contenido;
    }

    public int getCodSalida() {
	return codSalida;
    }

    public void setCodSalida(int codSalida) {
	this.codSalida = codSalida;
    }

    public String getContenido() {
	return contenido;
    }

    public void setContenido(String contenido) {
	this.contenido = contenido;
    }
    
    
}
