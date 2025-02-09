# Explicacion de codigos

Para esta explicacion usaremos 

Codigo Python

```python
import json
import random

def crear_tabla():
    mes = ("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
    departamento = ("Ropa", "Deportes", "Jugueteria")
    tabla = [[random.randint(500, 5000) for _ in range(len(departamento))] for _ in range(len(mes))]
    return tabla, mes, departamento

def ensenar_tabla(tabla, mes, departamento):
    print("\nVentas x Mes")
    print(f"{'Mes':<10} | {' | '.join(departamento)}")
    print("-" * 40)
    for i, m in enumerate(mes):
        fila = [str(tabla[i][j]) for j in range(len(departamento))]
        print(f"{m:<10} | {' | '.join(fila)}")

def ubicar_venta(tabla, mes, departamento):
    mes_venta = input("Capture el mes que desea ubicar: ")
    depar = input("Capture el departamento: ")
    if mes_venta in mes and depar in departamento:
        fila, columna = mes.index(mes_venta), departamento.index(depar)
        venta = tabla[fila][columna]
        print(f"La venta en {mes_venta} para el departamento de {depar} fue de: {venta}")
    else: 
        print("No se ha encontrado ninguna venta realizada")

def eliminar_venta(tabla, mes, departamento):
    mes_venta = input("Capture el mes que se realizo la venta: ")
    depar = input("Capture el departamento: ")
    if mes_venta in mes and depar in departamento:
        fila, columna = mes.index(mes_venta), departamento.index(depar)
        tabla[fila][columna] = 0
        print("La venta ha sido eliminada")
    else:
        print("No se ha encontrado el mes/departamento ingresado")

def main():
    tabla, mes, departamento = crear_tabla()
    
    while True:
        print("\nMenu:")
        print("1. Enseñar tabla")
        print("2. Ubicar venta")
        print("3. Eliminar venta")
        print("4. Salir")
        
        opcion = input("Seleccione una opcion: ")
        
        if opcion == "1":
            ensenar_tabla(tabla, mes, departamento)
        elif opcion == "2":
            ubicar_venta(tabla, mes, departamento)
        elif opcion == "3":
            eliminar_venta(tabla, mes, departamento)
        elif opcion == "4":
            print("Finalizando programa")
            break
        else:
            print("Opcion NO valida. Por favor intente de nuevo.")

if __name__ == "__main__":
    main()
```


EXPLICACION:
Como se puede apreciar en el codigo para la realizacion se realizaron cinco metodos, un metodo para crear la tabla, agregando apartados de mes, departamento y agregando un variable para crear los datos internos de la tabla donde usamos una libreria conocida como random, eso para generar valores aleatorios para generar datos de la tabla, estos considerando que tenemos datos preestablecidos, se crea ahora otro metodo que este metodo lo que hara es arrojar la tabla, arrojando los diferentes apartados y los resultados de estos, en el tercer apartado se crea el metodo para ubicar alguna venta en especifica esto solicitando datos como el mes que se realizo la venta y en que departamento fue, arrojando al final un mensaje especificando de cuanto fue la venta y reafirmando el mes y departamento que se realizo, en el cuarto y penultimo metodo es donde eliminaremos una venta realizando el mismo proceso de solicitar mes y departamento, como ultimo creamos el metodo main para crear un ciclo while para realizar un tipo menu para solicitar al usuario que accion quiere realizar para modificar o interectuar con la tabla.

A continuacion pasaremos con la explicacion del codigo en Java.

Codigo Java

```java
import java.util.Random;
import java.util.Scanner;

public class TablaJavaVersion {

    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                                     "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static String[] departamentos = {"Ropa", "Deportes", "Jugueteria"};
    private static int[][] tabla;

    public static void main(String[] args) {
        tabla = crearTabla();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Mostrar tabla");
            System.out.println("2. Ubicar venta");
            System.out.println("3. Eliminar venta");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarTabla();
                    break;
                case "2":
                    ubicarVenta(scanner);
                    break;
                case "3":
                    eliminarVenta(scanner);
                    break;
                case "4":
                    System.out.println("Finalizando programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción NO válida. Por favor intente de nuevo.");
            }
        }
    }

    private static int[][] crearTabla() {
        Random random = new Random();
        int[][] tabla = new int[meses.length][departamentos.length];
        for (int i = 0; i < meses.length; i++) {
            for (int j = 0; j < departamentos.length; j++) {
                tabla[i][j] = random.nextInt(4501) + 500; 
            }
        }
        return tabla;
    }

    private static void mostrarTabla() {
        System.out.println("\nVentas por Mes");
        System.out.printf("%-10s | %-10s | %-10s | %-10s%n", "Mes", "Ropa", "Deportes", "Jugueteria");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < meses.length; i++) {
            System.out.printf("%-10s | %-10d | %-10d | %-10d%n", 
                              meses[i], tabla[i][0], tabla[i][1], tabla[i][2]);
        }
    }

    private static void ubicarVenta(Scanner scanner) {
        System.out.print("Capture el mes que desea ubicar: ");
        String mes = scanner.nextLine();
        System.out.print("Capture el departamento: ");
        String departamento = scanner.nextLine();

        int fila = -1, columna = -1;

        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(mes)) {
                fila = i;
                break;
            }
        }

        for (int j = 0; j < departamentos.length; j++) {
            if (departamentos[j].equalsIgnoreCase(departamento)) {
                columna = j;
                break;
            }
        }

        if (fila != -1 && columna != -1) {
            System.out.printf("La venta en %s para el departamento de %s fue de: %d%n", 
                              mes, departamento, tabla[fila][columna]);
        } else {
            System.out.println("No se ha encontrado ninguna venta realizada.");
        }
    }

    private static void eliminarVenta(Scanner scanner) {
        System.out.print("Capture el mes que se realizó la venta: ");
        String mes = scanner.nextLine();
        System.out.print("Capture el departamento: ");
        String departamento = scanner.nextLine();

        int fila = -1, columna = -1;

        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(mes)) {
                fila = i;
                break;
            }
        }

        for (int j = 0; j < departamentos.length; j++) {
            if (departamentos[j].equalsIgnoreCase(departamento)) {
                columna = j;
                break;
            }
        }

        if (fila != -1 && columna != -1) {
            tabla[fila][columna] = 0;
            System.out.println("La venta ha sido eliminada.");
        } else {
            System.out.println("No se ha encontrado el mes/departamento ingresado.");
        }
    }
}
```


EXPLICACION:
En este codigo para su realización nuevamente se implementaron cuatro métodos, el primero es crearTabla, que genera la tabla con valores aleatorios usando la clase Random, para el segundo método este imprime la tabla, mostrando los valores de ventas, en el tercero permite buscar una venta específica solicitando el mes y departamento, mostrando el valor correspondiente, para el cuarto método, elimina una venta estableciendo su valor en 0, también solicitando el mes y departamento y para finalizar, en el método main se crea un menú interactivo con un ciclo while para que el usuario elija entre mostrar la tabla, ubicar o eliminar una venta, o salir del programa. 
Como se puede apreciar ambos codigos cuentan con los mismo metodos y mismas funciones, lo unico diferente es su programacion a su lenguaje correspondiente.



