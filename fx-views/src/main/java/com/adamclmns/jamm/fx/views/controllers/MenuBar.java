package com.adamclmns.jamm.fx.views.controllers;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * The type Menu bar.
 */
public class MenuBar {
    private static final Logger log = LoggerFactory.getLogger(MenuBar.class);
    private DirectoryImportCallback directoryImportCallback;

    /**
     * Sets directory import callback.
     *
     * @param callback the callback
     */
    void setDirectoryImportCallback(DirectoryImportCallback callback) {
        directoryImportCallback = callback;
    }

    @FXML
    private void importSingleFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose a File to Import");
        Stage stage = new Stage();
        File selectedFile = chooser.showOpenDialog(stage);
        stage.close();
        directoryImportCallback.execute();
    }

    @FXML
    private void importDirectoryRecursively() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose a Folder to Import");
        Stage stage = new Stage();
        File selectedFile = chooser.showDialog(stage);
        directoryImportCallback.execute();
    }

    @FXML
    private void quitUfu() {
        Platform.exit();
    }

    /**
     * Rescan library from disk.
     */
    public void rescanLibraryFromDisk() {

    }

    /**
     * The interface Directory import callback.
     */
    public interface DirectoryImportCallback {
        /**
         * Execute.
         */
        void execute();
    }
}
