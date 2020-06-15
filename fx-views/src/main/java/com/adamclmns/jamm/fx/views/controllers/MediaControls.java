package com.adamclmns.jamm.fx.views.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Media controls.
 */
public class MediaControls {
    private static final Logger log = LoggerFactory.getLogger(MediaControls.class);


    @FXML
    private Label nowPlaying;
    @FXML
    private Slider playProgress;


    @FXML
    private void playSelectedFile() {

    }


}
