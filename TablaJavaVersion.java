import java.util.Random;
import java.util.Scanner;

public class TablaJavaVersion 

{

    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                                     "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static String[] departamentos = {"Ropa", "Deportes", "Jugueteria"};
    private static int[][] tabla;

    public static void main(String[] args) 
    
    {
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

            switch (opcion) 
            
            {
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

    private static int[][] crearTabla() 
    
    {
        Random random = new Random();
        int[][] tabla = new int[meses.length][departamentos.length];
        for (int i = 0; i < meses.length; i++) {
            for (int j = 0; j < departamentos.length; j++) 
            
            {
                tabla[i][j] = random.nextInt(4501) + 500; 
            }
        }
        return tabla;
    }

    private static void mostrarTabla() 
    
    {
        System.out.println("\nVentas por Mes");
        System.out.printf("%-10s | %-10s | %-10s | %-10s%n", "Mes", "Ropa", "Deportes", "Jugueteria");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < meses.length; i++) 
        
        {
            System.out.printf("%-10s | %-10d | %-10d | %-10d%n", 
                              meses[i], tabla[i][0], tabla[i][1], tabla[i][2]);
        }
    }

    private static void ubicarVenta(Scanner scanner) 
    
    {
        System.out.print("Capture el mes que desea ubicar: ");
        String mes = scanner.nextLine();
        System.out.print("Capture el departamento: ");
        String departamento = scanner.nextLine();

        int fila = -1, columna = -1;

        for (int i = 0; i < meses.length; i++) 
        
        {
            if (meses[i].equalsIgnoreCase(mes)) 
            
            {
                fila = i;
                break;
            }
        }

        for (int j = 0; j < departamentos.length; j++) 
        
        {
            if (departamentos[j].equalsIgnoreCase(departamento)) 
            
            {
                columna = j;
                break;
            }
        }

        if (fila != -1 && columna != -1) 
        
        {
            System.out.printf("La venta en %s para el departamento de %s fue de: %d%n", 
                              mes, departamento, tabla[fila][columna]);
        } else 
        
        {
            System.out.println("No se ha encontrado ninguna venta realizada.");
        }
    }

    private static void eliminarVenta(Scanner scanner) 
    
    {
        System.out.print("Capture el mes que se realizó la venta: ");
        String mes = scanner.nextLine();
        System.out.print("Capture el departamento: ");
        String departamento = scanner.nextLine();

        int fila = -1, columna = -1;

        for (int i = 0; i < meses.length; i++) 
        
        {
            if (meses[i].equalsIgnoreCase(mes)) 
            
            {
                fila = i;
                break;
            }
        }

        for (int j = 0; j < departamentos.length; j++) 
        
        {
            if (departamentos[j].equalsIgnoreCase(departamento)) 
            
            {
                columna = j;
                break;
            }
        }

        if (fila != -1 && columna != -1) 
        
        {
            tabla[fila][columna] = 0;
            System.out.println("La venta ha sido eliminada.");
        } else {
            System.out.println("No se ha encontrado el mes/departamento ingresado.");
        }
    }
}