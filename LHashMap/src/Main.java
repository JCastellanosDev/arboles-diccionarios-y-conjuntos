import entrada.Entrada;
import lhashmap.LHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    TreeMap<String, String> mapa = new TreeMap<>();
    
    LHashMap<String,String> nombres = new LHashMap<>();
    nombres.put("Rulis", "Raul");
    nombres.put("Billy", "Cesar");
    nombres.put("Kike", "Enrique");
    nombres.put("B", "Brenda");

    for (Entrada<String,String> nombre:nombres.entries()){
        IO.println(nombre);
    }
    for (String key:nombres.keys()){
        IO.println(key);
    }

}
