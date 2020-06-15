package com.adamclmns.jamm.fx.views.controllers;


import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Media view.
 */
public class MediaView implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(MediaView.class);

    private ContextMenu mediaViewContextMenu;


    /**
     * Instantiates a new Media view.
     */
    public MediaView() {
        this.mediaViewContextMenu = buildMediaItemRightClickMenu();
    }


    /**
     * Build media item right click menu context menu.
     *
     * @return the context menu
     */
    public ContextMenu buildMediaItemRightClickMenu() {
        ContextMenu contextMenu = new ContextMenu();
        // TODO: Does the Context menu apply to one or more items?
        // TODO: Does the actions on the items depend on the type of items selected?
        // create menu items
        MenuItem add_to_queue = new MenuItem("Add To Queue");
        MenuItem play_next = new MenuItem("Play Next");
        MenuItem show_info = new MenuItem("Show Info");
        MenuItem edit_info = new MenuItem("Edit Info");
        MenuItem delete_from_disk = new MenuItem("Delete From Disk");
        MenuItem remove_from_library = new MenuItem("Remove From Library");


        // add menu items to menu
        contextMenu.getItems().add(add_to_queue);
        contextMenu.getItems().add(play_next);
        contextMenu.getItems().add(show_info);
        contextMenu.getItems().add(edit_info);
        contextMenu.getItems().add(delete_from_disk);
        contextMenu.getItems().add(remove_from_library);
        return contextMenu;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // create window event
}
