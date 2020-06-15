package com.adamclmns.jamm.fx.views;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * The enum View router.
 */
public enum ViewRouter {
    /**
     * Main view router.
     */
    MAIN();

    private final String name;

    ViewRouter() {
        this.name = "RootWindow.fxml";
    }

    /**
     * Load node t.
     *
     * @param <T> the type parameter
     * @return the t
     */
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
