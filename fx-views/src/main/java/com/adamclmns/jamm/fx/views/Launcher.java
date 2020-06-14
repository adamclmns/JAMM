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

package com.adamclmns.jamm.fx.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Launcher extends Application {
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
