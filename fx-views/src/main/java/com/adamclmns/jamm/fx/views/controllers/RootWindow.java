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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("EmptyMethod")
public class RootWindow implements Initializable {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RootWindow.class);
    @FXML
    private Pane rootWindow;
    @FXML
    private Parent mediaView;
    @FXML
    private MediaView mediaViewController;
    @FXML
    private Parent sideBar;
    @FXML
    private SideBar sideBarController;
    @FXML
    private Parent menuBar;
    @FXML
    private MenuBar menuBarController;
    @FXML
    private Parent mediaControls;
    @FXML
    private MediaControls mediaControlsController;


    public RootWindow() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
