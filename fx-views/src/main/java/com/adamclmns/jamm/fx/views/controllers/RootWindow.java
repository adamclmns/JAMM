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
