package ec.edu.poo;

public class GestorActivos {

    public final int MAX_ACTIVOS = 10;

    private ActivoDigital[] activos;
    private int contador;

    public GestorActivos() {
        // TODO: inicializar arreglo y contador
        this.activos = new ActivoDigital[MAX_ACTIVOS];
        this.contador = 0;
    }

    public void reiniciar() {
        // TODO: reiniciar arreglo y contador
        this.activos = new ActivoDigital[MAX_ACTIVOS];
        this.contador = 0;
    }

    public boolean registrarActivo(ActivoDigital activo) {
        // TODO: registrar si hay espacio y si el código no existe
        if (contador >= MAX_ACTIVOS) {
            return false;
        }

        if (buscarPorCodigo(activo.getCodigo()) != null) {
            return false;
        }

        activos[contador] = activo;
        contador++;
        return true;
    }

    public ActivoDigital buscarPorCodigo(String codigo) {
        // TODO: búsqueda secuencial por código
        for (int i = 0; i < contador; i++) {
            if (activos[i].getCodigo().equals(codigo)) {
                return activos[i];
            }
        }
        return null;
    }

    public int contarActivosCriticos() {
        // TODO: contar activos con nivelRiesgo >= 8
        int criticos = 0;
        for (int i = 0; i < contador; i++) {
            if (activos[i].getNivelRiesgo() >= 8) {
                criticos++;
            }
        }
        return criticos;
    }

    public double calcularPromedioRiesgo() {
        // TODO: calcular promedio de riesgo
        if (contador == 0) {
            return 0.0;
        }

        double sumaRiesgo = 0;
        for (int i = 0; i < contador; i++) {
            sumaRiesgo += activos[i].getNivelRiesgo();
        }
        return sumaRiesgo / contador;
    }

    public boolean aplicarParcheActivo(String codigo) {
        // TODO: buscar activo y cambiar parcheAplicado a true
        ActivoDigital activo = buscarPorCodigo(codigo);
        if (activo != null) {
            activo.setParcheAplicado(true);
            return true;
        }
        return false;
    }

    public int obtenerCantidadActivos() {
        return contador;
    }

    public ActivoDigital[] obtenerActivos() {
        return activos;
    }

}
