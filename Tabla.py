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
