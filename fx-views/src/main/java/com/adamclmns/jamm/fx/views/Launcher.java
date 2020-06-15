package com.adamclmns.jamm.fx.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * The type Launcher.
 */
public class Launcher extends Application {
    /**
     * The constant TITLE_BAR.
     */
    public static final String TITLE_BAR = "JAMM - Just Another Media Manager";

    private void loadRootUI(Stage stage) {
        Pane root = ViewRouter.MAIN.loadNode();
        stage.setScene(new Scene(root));
        //stage.getIcons().add(new Image("images/global/ufo.png"));
        stage.setResizable(true);
        stage.setTitle(TITLE_BAR);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        loadRootUI(stage);

    }


}
