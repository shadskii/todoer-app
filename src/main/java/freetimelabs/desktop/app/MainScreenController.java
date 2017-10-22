package freetimelabs.desktop.app;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Objects;

public class MainScreenController
{

    @FXML
    private ListView<TodoItemModel> itemList;

    @FXML
    private Button addItem;

    @FXML
    private TextField description;

    @FXML
    private Button completed;

    @FXML
    public void initialize()
    {
        itemList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
                completed.setText(newVal.completedProperty().get() ? "Undo Complete" : "Complete"));
        completed.setOnAction(e ->
        {
            TodoItemModel selected = itemList.getSelectionModel().getSelectedItem();
            if (Objects.nonNull(selected))
            {
                selected.completedProperty().setValue(!selected.completedProperty().get());
                completed.setText(selected.completedProperty().get() ? "Undo Complete" : "Complete");
            }
        });

        addItem.setOnAction(e ->
        {
            String desc = description.getText();
            if (!desc.isEmpty())
            {
                itemList.getItems().add(new TodoItemModel(desc));
                description.clear();
            }
        });
        itemList.setCellFactory(lv -> new ListCell<TodoItemModel>()
        {
            @Override
            protected void updateItem(TodoItemModel itemModel, boolean empty)
            {
                super.updateItem(itemModel, empty);
                if (empty)
                {
                    setGraphic(null);
                    setText(null);
                } else
                {
                    Label text = new Label(itemModel.descriptionProperty().get());
                    setGraphic(text);
                    itemModel.completedProperty().addListener((obs, oldVal, newVal) ->
                    {
                        System.out.println(text + " " + newVal);
                        if (newVal)
                        {
                            text.setStyle("-fx-strikethrough: true");
                        } else
                        {
                            text.setStyle("-fx-strikethrough: false");
                        }
                    });

                }
            }
        });
    }

}
