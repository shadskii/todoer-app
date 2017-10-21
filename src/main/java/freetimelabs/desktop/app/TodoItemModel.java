package freetimelabs.desktop.app;

import javafx.beans.property.*;

public class TodoItemModel {

    private StringProperty description;
    private BooleanProperty completed;

    public TodoItemModel(String description){
        this.description = new SimpleStringProperty(description);
        this.completed = new SimpleBooleanProperty(false);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public BooleanProperty completedProperty() {
        return completed;
    }
}

