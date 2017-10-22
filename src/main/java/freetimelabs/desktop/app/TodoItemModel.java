package freetimelabs.desktop.app;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model to be used as To do Items
 */
public class TodoItemModel {

    private StringProperty description;
    private BooleanProperty completed;

    /**
     * Constructs a TodoItemModel with a given description. Defaulting the completed property to false.
     *
     * @param description - A String describing the to-do item.
     */
    public TodoItemModel(String description){
        this.description = new SimpleStringProperty(description);
        this.completed = new SimpleBooleanProperty(false);
    }

    /**
     * The description of this to-do item.
     * @return A property that represents the description of this to-do item.
     */
    public StringProperty descriptionProperty() {
        return description;
    }

    /**
     * The completed status of this to-do item.
     * @return A property that represents the completed status of this to-do item.
     */
    public BooleanProperty completedProperty() {
        return completed;
    }
}

