import entrada.Entrada;
import lhashmap.LHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {



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

    IO.println("=".repeat(40));
    IO.println("Tamaño: " + nombres.size());
    IO.println("get(\"Kike\"): " + nombres.get("Kike"));
    IO.println("get(\"Pepe\"): " + nombres.get("Pepe"));

    IO.println("=".repeat(40));
    IO.println("put(\"B\", \"Berenice\") regresa: " + nombres.put("B", "Berenice"));
    IO.println("get(\"B\"): " + nombres.get("B"));
    IO.println("Tamaño: " + nombres.size());

    IO.println("=".repeat(40));
    IO.println("remove(\"Billy\") regresa: " + nombres.remove("Billy"));
    IO.println("remove(\"Pepe\") regresa: " + nombres.remove("Pepe"));
    IO.println("Tamaño: " + nombres.size());

    IO.println("Valores:");
    for (String valor:nombres.values()){
        IO.println(valor);
    }
    IO.println("Esta vacio? " + nombres.isEmpty());

}
