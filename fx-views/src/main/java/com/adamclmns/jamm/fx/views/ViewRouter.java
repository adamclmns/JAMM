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
