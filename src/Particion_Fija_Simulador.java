import java.util.ArrayList;
import java.util.Scanner;

public class Particion_Fija_Simulador {
    private ArrayList<Particion> particions;

    public Particion_Fija_Simulador(int[] particion_Sizes){
        particions = new ArrayList<>();
        for(int size : particion_Sizes){
            particions.add(new Particion(size));    
        }
    }

    public void Mostrar_Particiones(){
        System.out.println("\nEstado de las particiones: ");
        for(int i = 0; i < particions.size(); i++){
            Particion particion = particions.get(i);
            System.out.printf("Particion %d: Tamanio %d, %s\n", i + 1, particion.getSize(),
                    particion.isfree() ? "Libre" : "Asignado a " + particion.getProceso());
        }
    }

    public void Asignar_Proceso(String Nombre_Proceso, int proceso_Size) {
        for(Particion particion : particions){
            if (particion.asgnar_Proceso(Nombre_Proceso, proceso_Size)) {
                System.out.println("Proceso " + Nombre_Proceso + " asignado correctamente.");
                return;
            }
        }
        System.out.println("No se pudo asignar el proceso" + Nombre_Proceso);
        System.out.println("No existe un particion disponible o suficiente espacio");
    }

    public void fre_Particion(int particion_index){
        if (particion_index >= 0 && particion_index < particions.size()) {
            Particion particion = particions.get(particion_index);
            if (!particion.isfree()) {
                System.out.println("Proceso " + particion.getProceso() + " liberado de la partcion " + (particion_index + 1) + ".");
                particion.free_Particion();
            }else{
                System.out.println("La particon ya se encuentra libre");
            }
        }else{
            System.out.println("Indice de particion invalido.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numeor de particiones: ");
        int num_Particiones = scanner.nextInt();

        int[] particion_Sizes = new int[num_Particiones];
        System.out.println("Ingrese los tamanios de las particiones");
        for(int i = 0; i < num_Particiones; i++){
            System.out.print("Tamanio de la particion " + (i + 1) + ": ");
            particion_Sizes[i] = scanner.nextInt();
        }

        Particion_Fija_Simulador simulador = new Particion_Fija_Simulador(particion_Sizes);

        while (true) {
            System.out.println("\nOpciones: ");
            System.out.println("1. Mostrar particiones");
            System.out.println("2. Asginar proceso ");
            System.out.println("3. Liberar particion");
            System.out.println("4. Salir");
            System.out.println("Selecciones un opcion");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    simulador.Mostrar_Particiones();
                    break;

                    case 2:
                    System.out.print("Ingrese el nombre del proceso");
                    String Nombre_Proceso =  scanner.nextLine();
                    System.out.print("Ingrese el tamanio del proceso: ");
                    int proceso_Size = scanner.nextInt();
                    simulador.Asignar_Proceso(Nombre_Proceso, proceso_Size);
                    break;

                    case 3:
                    System.out.println("Ingrese el indice de particion a liberar ( 1 a" + num_Particiones + " ):");
                    int particion_index = scanner.nextInt() - 1;
                    simulador.fre_Particion(particion_index);
                    break;

                    case 4:
                    System.out.println("Saliendo del simulador. Gracias por usarlo");
                    scanner.close();
                    return;
            
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }
    }
}
