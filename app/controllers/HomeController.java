package controllers;

import play.mvc.*;
import views.html.*;

import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.*;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Hola mundo, servicios web!!"));
    }

    /*
* El siguiente método hace una multiplicación de enteros.
* @param a el primer  entero.
* @param b el segundo entero.
* @return Resultado en formato Json.
*/
    public Result getMultiplicacion(int a, int b){
        ObjectNode result = Json.newObject();
        result.put("resultado", a*b );
        return ok(result);
    }

    /*
* El siguiente método verifica si una cadena es un palíndromo.
* @param word la palabra a validar.
* @return true o false en formato Json.
*/
    public Result getPalindromo(String word) {
        ObjectNode result = Json.newObject();
        String myWord = word.replaceAll("\\s+", "");
        String reverse = new StringBuffer(myWord).reverse().toString();
        result.put("resultado", reverse.equalsIgnoreCase(myWord));
        return ok(result);
    }

    public Result getDolares(double pesos) {
        ObjectNode result = Json.newObject();
        double dolares = pesos*18.57;
        result.put("resultado", dolares);
        return ok(result);
    }

    public Result getCentigrados(double fahrenheit) {
        ObjectNode result = Json.newObject();
        double centigrados = (fahrenheit*1.8)+32;
        result.put("resultado", centigrados);
        return ok(result);
    }

    public Result getCapital(String pais) {
        ObjectNode result = Json.newObject();
        String capital = "";
        String[] listaPaises = {"Alemania","Austria","Belgica","Dinamarca","España",
                "Finlandia","Francia","Grecia","Hungria","Irlanda",
                "Italia","Paises Bajos","Polonia","Portugal",
                "Reino Unido","Republica Checa","Rumania","Suecia"};
        String[] listaCapitales = {"Berlin","Vienna","Bruselas","Copenhagen","Madrid",
                "Helsinki","Paris","Αtenas","Budapest","Dublin","Roma",
                "Amsterdam","Warsaw","Lisboa","Londres","Prague",
                "Bucharest","Stockholmo"};
        for(int i=0;i<listaPaises.length;i++){
            if(listaPaises[i].equals(pais)){
                capital = listaCapitales[i];
                result.put("resultado", capital);
                break;
            }
        }
        return ok(result);
    }

    public Result getEmbajada(String pais) {
        ObjectNode result = Json.newObject();
        String embajada = "";
        String[] listaPaises = {"Alemania","Austria","Belgica","Dinamarca","España",
                "Finlandia","Francia","Grecia","Hungria","Irlanda",
                "Italia","Países Bajos","Polonia","Portugal",
                "Reino Unido","Republica Checa","Rumania","Suecia"};
        String[] coordenadasembajada = {"52.5077843,13.3517587","48.1998585,16.3700744",
                "50.8083158,4.3849209","55.6864627,12.5918263",
                "40.4160947,-3.6973632","60.1685662,24.9351516",
                "48.8648275,2.292344","37.9773269,23.7406908",
                "47.516701,19.0278825","53.3303151,-6.2387368",
                "41.9133032,12.5097257","52.0899761,4.3059916",
                "52.22499,20.99128","38.7375761,-9.2019543",
                "51.513845,-0.1422097","50.0801273,14.4168633",
                "50.0801273,14.4168633","59.3320685,18.0830599"};
        for(int i=0;i<listaPaises.length;i++){
            if(listaPaises[i].equals(pais)){
                embajada = coordenadasembajada[i];
                result.put("resultado", embajada);
                break;
            }
        }
        return ok(result);
    }
}
