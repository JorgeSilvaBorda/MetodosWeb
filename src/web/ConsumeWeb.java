package web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import modelo.Parametros;
import modelo.SalidaWeb;

/**
 * Clase para comunicarse mediante método POST a URL's determinadas.
 * Permite el uso de proxyes y envío de parámetros en la conexión.
 * Genera respuestas como texto que pueden luego ser procesadas por aplicaciones.
 * @author Jorge Silva Borda
 */
public class ConsumeWeb {
    
    /**
     * Envía una petición POST a una URL determinada.
     * @param urlDestino {@code String} con la URL a enviar la solicitud.
     * @return {@link modelo.SalidaWeb} con el código de respuesta y el contenido de la salida.
     * @throws IOException 
     * @see modelo.Parametro
     */
    public SalidaWeb hacerPost(String urlDestino) throws IOException{
	HttpURLConnection con = hacerConexion(urlDestino);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.flush();
	wr.close();
	int codRespuesta = con.getResponseCode();
	BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String lineaEntrada;
	StringBuilder salida = new StringBuilder();
	while ((lineaEntrada = entrada.readLine()) != null) {
	    salida.append(lineaEntrada);
	}
	entrada.close();
	
	return new SalidaWeb(codRespuesta, salida.toString());
    }
    
    /**
     * Envía una petición POST con parámetros a una URL determinada.
     * @param urlDestino {@code String} con la URL a enviar la solicitud.
     * @param parametros {@link modelo.Parametros} con los parámetros a enviar.
     * @return {@link modelo.SalidaWeb} con el código de respuesta y el contenido de la salida.
     * @throws IOException 
     * @see modelo.Parametro
     */
    public SalidaWeb hacerPost(String urlDestino, Parametros parametros) throws IOException{
	HttpURLConnection con = hacerConexion(urlDestino);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(parametros.construirParámetros());
	wr.flush();
	wr.close();
	int codRespuesta = con.getResponseCode();
	BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String lineaEntrada;
	StringBuilder salida = new StringBuilder();
	while ((lineaEntrada = entrada.readLine()) != null) {
	    salida.append(lineaEntrada);
	}
	entrada.close();
	
	return new SalidaWeb(codRespuesta, salida.toString());
    }
    
    /**
     * Envía una petición POST con parámetros a una URL determinada.
     * @param urlDestino {@code String} con la URL a enviar la solicitud.
     * @param proxy {@link String} con la dirección del proxy.
     * @param puerto {@link Integer} con el puerto del proxy.
     * @return {@link modelo.SalidaWeb} con el código de respuesta y el contenido de la salida.
     * @throws IOException
     * @throws MalformedURLException
     * @throws ProtocolException
     * @see modelo.Parametro
     */
    public SalidaWeb hacerPost(String urlDestino, String proxy, int puerto) throws MalformedURLException, ProtocolException, IOException{
	HttpURLConnection con = hacerConexion(urlDestino, proxy, puerto);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.flush();
	wr.close();
	int codRespuesta = con.getResponseCode();
	BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String lineaEntrada;
	StringBuilder salida = new StringBuilder();
	while ((lineaEntrada = entrada.readLine()) != null) {
	    salida.append(lineaEntrada);
	}
	entrada.close();
	
	return new SalidaWeb(codRespuesta, salida.toString());
    }
    
    /**
     * Envía una petición POST con parámetros a una URL determinada.
     * @param urlDestino {@code String} con la URL a enviar la solicitud.
     * @param proxy {@link String} con la dirección del proxy.
     * @param puerto {@link Integer} con el puerto del proxy.
     * @param parametros {@link modelo.Parametros} con los parámetros a enviar.
     * @return {@link modelo.SalidaWeb} con el código de respuesta y el contenido de la salida.
     * @throws IOException
     * @throws MalformedURLException
     * @throws ProtocolException
     * @see modelo.Parametro
     */
    public SalidaWeb hacerPost(String urlDestino, Parametros parametros, String proxy, int puerto) throws MalformedURLException, ProtocolException, IOException{
	HttpURLConnection con = hacerConexion(urlDestino, proxy, puerto);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(parametros.construirParámetros());
	wr.flush();
	wr.close();
	int codRespuesta = con.getResponseCode();
	BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String lineaEntrada;
	StringBuilder salida = new StringBuilder();
	while ((lineaEntrada = entrada.readLine()) != null) {
	    salida.append(lineaEntrada);
	}
	entrada.close();
	
	return new SalidaWeb(codRespuesta, salida.toString());
    }
    
    /**
     * Genera un objeto {@link java.net.HttpURLConnection} para ser utilizado en las llamadas POST.
     * @param urlDestino {@link String} con la URL de destino.
     * @return {@link java.net.HttpURLConnection} con la configuración de la conexión.
     * @throws MalformedURLException
     * @throws IOException 
     */
    private HttpURLConnection hacerConexion(String urlDestino) throws MalformedURLException, IOException{
	URL obj = new URL(urlDestino);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
	con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"); 
	con.setDoOutput(true);
	return con;
    }
    
    /**
     * Genera un objeto {@link java.net.HttpURLConnection} para ser utilizado en las llamadas POST.
     * @param urlDestino {@link String} con la URL de destino.
     * @param proxy {@link String} con la dirección del proxy.
     * @param puerto {@link Integer} con el puerto del proxy.
     * @return {@link java.net.HttpURLConnection} con la configuración de la conexión.
     * @throws MalformedURLException
     * @throws IOException 
     */
    private HttpURLConnection hacerConexion(String urlDestino, String proxy, int puerto) throws MalformedURLException, IOException{
	Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy, puerto));
	URL obj = new URL(urlDestino);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection(prox);
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
	con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"); 
	con.setDoOutput(true);
	return con;
    }
    
}
