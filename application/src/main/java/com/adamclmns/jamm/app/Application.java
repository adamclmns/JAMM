package com.adamclmns.jamm.app;


import com.adamclmns.jamm.fx.views.Launcher;
import javafx.stage.Stage;
import org.slf4j.Logger;

public class Application extends javafx.application.Application {
    // TODO: Configure Implementations of Interfaces here with Service Factory.
    // TODO: Write ServiceFactory in CoreImpl
    // TODO:

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Application.class);
    private final Launcher launcher = new Launcher();

    public static void main(final String... args) {
        javafx.application.Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        launcher.start(stage);
    }
}
