package proyecto3_paradigmas.util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Window;

/**
 * Esta clase facilita el lanzamiento de alertas.
 * @author Carlos Carranza Blanco
 */
public class Mensaje {

    /**
     *Lanza un mensaje simple.
     * @param tipo Tipo de mensaje.
     * @param titulo Titulo del mensaje.
     * @param mensaje Cuerpo del mensaje.
     */
    public void show(AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    /**
     *Lanza un mensaje de manera que bloque el stage del cual procede.
     * @param tipo Tipo de mensaje.
     * @param titulo Titulo del mensaje.
     * @param padre Ventana que debe ser bloqueada.
     * @param mensaje Cuerpo del mensaje.
     */
    public void showModal(AlertType tipo, String titulo, Window padre, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Lnaza una alerta que realiza una pregunta y bloquea la ventana.
     * @param titulo Titulo de mensaje.
     * @param padre Ventana que debe ser bloqueada.
     * @param mensaje Cuerpo del mensaje.
     * @return True o False segun la decision que tome el usuairo.
     */
    public Boolean showConfirmation(String titulo, Window padre, String mensaje) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
    }

    /**
     * Lanza una pregunta que viene acompañada de una leve descripcion y bloquea
     * la ventana.
     * @param titulo Titulo del mensaje.
     * @param padre Ventana que debe ser bloqueada.
     * @param descripcion Descripcion de la pregunta.
     * @param mensaje Cuerpo del mensaje.
     * @return True o False segun la decision del usuaio.
     */
    public Boolean showConfirmation(String titulo, Window padre, String descripcion, String mensaje) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(descripcion);
        alert.initOwner(padre);
        alert.setContentText(mensaje);
        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
    }

    /**
     * Lanza un mnesaje informativo.
     * @param mensaje Cuerpo del mensaje.
     */
    public  void showInformation(String  mensaje){
        show(AlertType.INFORMATION, "Información", mensaje);

    }
}