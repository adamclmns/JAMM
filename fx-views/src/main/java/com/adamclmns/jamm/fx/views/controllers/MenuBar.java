/*
 *
 * ' _   _ ______ _   _
 * | | | ||  ___| | | |                            Copyright -  AdamClmns 2020-03
 * | | | || |_  | | | |
 * | | | ||  _| | | | |
 * | |_| || |_  | |_| |
 *  \___(_)_(_)  \___(_)
 *
 *
 *  _   _       _     _            _   _  __ _          _  ______ _ _        _   _ _   _ _ _ _
 * | | | |     (_)   | |          | | (_)/ _(_)        | | |  ___(_) |      | | | | | (_) (_) |
 * | | | |_ __  _  __| | ___ _ __ | |_ _| |_ _  ___  __| | | |_   _| | ___  | | | | |_ _| |_| |_ _   _
 * | | | | '_ \| |/ _` |/ _ \ '_ \| __| |  _| |/ _ \/ _` | |  _| | | |/ _ \ | | | | __| | | | __| | | |
 * | |_| | | | | | (_| |  __/ | | | |_| | | | |  __/ (_| | | |   | | |  __/ | |_| | |_| | | | |_| |_| |
 *  \___/|_| |_|_|\__,_|\___|_| |_|\__|_|_| |_|\___|\__,_| \_|   |_|_|\___|  \___/ \__|_|_|_|\__|\__, |
 *                                                                                                __/ |
 *                                                                                               |___/
 *
 *
 */

package com.adamclmns.jamm.fx.views.controllers;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MenuBar {
    private static final Logger log = LoggerFactory.getLogger(MenuBar.class);
    private DirectoryImportCallback directoryImportCallback;

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

    public void rescanLibraryFromDisk() {

    }

    public interface DirectoryImportCallback {
        void execute();
    }
}
