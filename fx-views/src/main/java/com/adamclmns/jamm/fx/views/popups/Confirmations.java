package com.adamclmns.jamm.fx.views.popups;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * The type Confirmations.
 */
public class Confirmations {

    /**
     * Confirm or cancel dialog optional.
     *
     * @param message the message
     * @return the optional
     */
    public static Optional<ButtonType> confirmOrCancelDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure?");
        alert.setContentText(message);
        return alert.showAndWait();
    }
}
