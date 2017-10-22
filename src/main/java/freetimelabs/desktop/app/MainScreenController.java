package freetimelabs.desktop.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.StringConverter;

public class MainScreenController
{

    @FXML
    private ListView<TodoItemModel> itemList;

    @FXML
    private Button addItem;

    @FXML
    private TextField description;

    @FXML
    public void initialize()
    {
        addItem.setOnAction(e ->
        {
            String desc = description.getText();
            if (!desc.isEmpty())
            {
                itemList.getItems().add(new TodoItemModel(desc));
                description.clear();
            }
        });
        itemList.setCellFactory(CheckBoxListCell.forListView(TodoItemModel::completedProperty, new StringConverter<TodoItemModel>()
        {
            @Override
            public String toString(TodoItemModel object)
            {
                return object.descriptionProperty().get();
            }

            @Override
            public TodoItemModel fromString(String string)
            {
                return null;
            }
        }));
    }

}
