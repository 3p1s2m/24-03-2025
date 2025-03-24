package servicios;

import java.util.ArrayList;
import java.util.List;

import entidades.Reserva;

/**
 * Clase que gestiona el sistema de reservas deportivas.
 * Permite reservar pistas, cancelar reservas, gestionar la iluminación y verificar la disponibilidad de las pistas.
 * 
 * @author Nombre_del_Autor
 */

public class SistemaReservasDeportivas {
	private List<Reserva> reservas; // lista con las reservas que podemos hacer
    private boolean[] iluminacion; // atributo que nos mostrara un array de  la iluminacion de cada pista
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    
    
/**
* Constructor de la clase SistemaReservasDeportivas.
* Inicializa la lista de reservas y el estado de la iluminación de las pistas.
*/
    
    
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
    
    
     
    
    
/**
* Reserva una pista en una fecha y hora específicas.
* @param reserva Objeto Reserva con los detalles de la reserva.
* @return true si la reserva se realiza correctamente; false si la pista ya está reservada.
*/
    
    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }
    
/**
* Cancela una reserva.
* @param idReserva ID de la reserva a cancelar.
* @return true si la reserva se cancela correctamente; false si no se encuentra la reserva.
*/

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
/**
* Activa la iluminación de una pista específica.
* @param idPista ID de la pista cuya iluminación se va a activar.
* @return true si la iluminación se activa correctamente; false si el ID de la pista es inválido.
*/

    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    

/**
 * Desactiva la iluminación de una pista específica.
 * 
 * @param idPista ID de la pista cuya iluminación se va a desactivar.
 * @return true si la iluminación se desactiva correctamente; false si el ID de la pista es inválido.
 */
    
    
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
    
    
/**
* Verifica si una pista está disponible en una fecha específica.
 * @param idPista ID de la pista.
* @param fecha Fecha en formato LocalDate.
* @return true si la pista está disponible; false si ya está reservada.
*/

    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }

	
    
    
   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
