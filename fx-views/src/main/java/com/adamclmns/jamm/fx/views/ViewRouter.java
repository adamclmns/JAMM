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

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public enum ViewRouter {
    MAIN();

    private final String name;

    ViewRouter() {
        this.name = "RootWindow.fxml";
    }

    public <T> T loadNode() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ViewRouter.MAIN.toString()));
            loader.setLocation(getClass().getClassLoader().getResource(name));
            return loader.load();
        } catch (final IOException e) {
            throw new RuntimeException(String.format("Unable to load FXML '%s'", name), e);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
