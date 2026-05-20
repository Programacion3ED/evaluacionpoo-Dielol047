package ec.edu.poo;

public class Main {
    public static void main(String[] args) {


        GestorActivos gestor = new GestorActivos();

        System.out.println("--- REGISTRO DE ACTIVOS ---");


        Servidor server1 = new Servidor("SRV-001", "Servidor Producción", 9, false, "Linux Debian");
        Firewall fw1 = new Firewall("FW-001", "Firewall Perimetral", 5, true, 150);
        Servidor server2 = new Servidor("SRV-002", "Servidor Pruebas", 8, true, "Windows Server");


        System.out.println("Registrando server1: " + gestor.registrarActivo(server1)); // true
        System.out.println("Registrando fw1: " + gestor.registrarActivo(fw1));         // true
        System.out.println("Registrando server2: " + gestor.registrarActivo(server2)); // true


        Servidor server3 = new Servidor("SRV-001", "Servidor Clon", 4, false, "Linux Ubuntu");
        System.out.println("Registrando duplicado (SRV-001): " + gestor.registrarActivo() + gestor.registrarActivo()
                gestor.registrarActivo(server3));
        System.out.println("\n--- ESTADÍSTICAS ---");

        System.out.println("Total de activos registrados: " + gestor.obtenerCantidadActivos());
        System.out.println("Activos críticos (Riesgo >= 8): " + gestor.contarActivosCriticos());
        System.out.println("Promedio de riesgo total: " + gestor.calcularPromedioRiesgo());

        System.out.println("\n--- APLICACIÓN DE PARCHES ---");

        ActivoDigital activoBusqueda = gestor.buscarPorCodigo("SRV-001");
        if (activoBusqueda != null) {
            System.out.println("El estado del parche de " + activoBusqueda.getNombre() + " es: " + activoBusqueda.isParcheAplicado());
        }


        System.out.println("Aplicando parche a SRV-001... " + (gestor.aplicarParcheActivo("SRV-001") ? "Éxito" : "Falló"));


        activoBusqueda = gestor.buscarPorCodigo("SRV-001");
        System.out.println("El nuevo estado del parche de " + activoBusqueda.getNombre() + " es: " + activoBusqueda.isParcheAplicado());


        System.out.println("Aplicando parche a activo inexistente (XXX): " + gestor.aplicarParcheActivo("XXX"));
    }
}
