package servicios;

/**
 * Clase que gestiona la iluminación de las pistas deportivas.
 */
public class GestorIluminacion {
    private boolean[] iluminacion; // Estado de iluminación de cada pista

    /**
     * Constructor que inicializa las luces apagadas.
     * @param maxPistas Número total de pistas.
     */
    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    /**
     * Enciende la iluminación de una pista.
     * @param idPista ID de la pista.
     * @return true si se enciende correctamente, false si el ID es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga la iluminación de una pista.
     * @param idPista ID de la pista.
     * @return true si se apaga correctamente, false si el ID es inválido.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }
}


		
		
		

