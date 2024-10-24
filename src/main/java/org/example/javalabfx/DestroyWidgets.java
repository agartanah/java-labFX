package org.example.javalabfx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DestroyWidgets {
    static final TextField textField1 = new TextField("Здравствуйте");
    static final TextField textField2 = new TextField("Привет");
    static final TextField textField3 = new TextField("Дарова надоел");

    static final CheckBox checkBoxTextField1 = new CheckBox();
    static final CheckBox checkBoxTextField2 = new CheckBox();
    static final CheckBox checkBoxTextField3 = new CheckBox();

    static final Button backButton = new Button("Назад");

    public static void start(Stage stage, Stage prevStage) {
        checkBoxTextField1.setOnAction(event -> textField1.setVisible(checkBoxTextField1.isSelected()));
        checkBoxTextField2.setOnAction(event -> textField2.setVisible(checkBoxTextField2.isSelected()));
        checkBoxTextField3.setOnAction(event -> textField3.setVisible(checkBoxTextField3.isSelected()));

        checkBoxTextField1.setSelected(true);
        checkBoxTextField2.setSelected(true);
        checkBoxTextField3.setSelected(true);

        backButton.setOnAction(actionEvent -> {
            stage.close();
            prevStage.show();
        });

        VBox widgetsContainer = new VBox(10, textField1, textField2, textField3);
        VBox checkBoxContainer = new VBox(20, checkBoxTextField1, checkBoxTextField2, checkBoxTextField3);

        HBox content = new HBox(20, checkBoxContainer, widgetsContainer);
        content.setAlignment(Pos.CENTER);

        VBox mainContainer = new VBox(20, backButton, content);
        mainContainer.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainContainer, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Аннигиляторная пушка");
        stage.show();
    }
}
