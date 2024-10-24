package org.example.javalabfx.restaurant;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class RestaurantOrder {
    static final Order order = new Order();
    static final List<Dish> dishes = createDishes();

    static final CheckBox[] dishCheckBoxes = new CheckBox[dishes.size()];
    static final TextField[] dishCountFields = new TextField[dishes.size()];

    public static void start(Stage stage, Stage prevStage) {
        VBox dishesContainer = new VBox(10);

        for (int index = 0; index < dishes.size(); ++index) {
            CheckBox dishTitle = new CheckBox(dishes.get(index).getTitle());
            Label dishPrice = new Label("Цена: " + dishes.get(index).getPrice());
            TextField dishCount = new TextField("1");

            dishCount.setDisable(true);

            dishTitle.setOnAction(event -> {
                dishCount.setDisable(!dishTitle.isSelected());

                if (!dishTitle.isSelected()) {
                    dishCount.setText("1");
                }
            });

            HBox dishContainer = new HBox(30, dishTitle, dishPrice, new Label("Количество:"), dishCount);
            dishContainer.setAlignment(Pos.CENTER_LEFT);

            dishCheckBoxes[index] = dishTitle;
            dishCountFields[index] = dishCount;
            dishesContainer.getChildren().add(dishContainer);
        }

        Button orderButton = new Button("Заказать");
        orderButton.setOnAction(event -> {
            showReceipt();
        });

        Button backButton = new Button("Назад");
        backButton.setOnAction(actionEvent -> {
            stage.close();
            prevStage.show();
        });

        VBox root = new VBox(20, backButton, dishesContainer, orderButton);
        root.setAlignment(Pos.CENTER_LEFT);
        root.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Заказ в ресторане");
        stage.setScene(scene);
        stage.show();
    }

    private static List<Dish> createDishes() {
        List<Dish> dishes = new ArrayList<>();

        dishes.add(new Dish("Пицца", 450d));
        dishes.add(new Dish("Цезарь", 500d));
        dishes.add(new Dish("Вино красное 'Шёпот монаха'", 4500d));
        dishes.add(new Dish("Кекс", 150d));
        dishes.add(new Dish("Пивандрий", 200d));

        return dishes;
    }

    // Метод для отображения чека в модальном окне
    private static void showReceipt() {
        Stage receiptStage = new Stage();
        receiptStage.initModality(Modality.APPLICATION_MODAL);

        VBox receiptContainer = new VBox(10);

        double totalCost = 0;
        for (int index = 0; index < dishes.size(); ++index) {
            if (dishCheckBoxes[index].isSelected()) {
                int quantity = Integer.parseInt(dishCountFields[index].getText());
                double dishTotal = quantity * dishes.get(index).getPrice();
                totalCost += dishTotal;

                Label dishInfo = new Label(dishes.get(index).getTitle() + " — Количество: " + quantity + ", Итоговая стоимость: " + dishTotal + " руб.");
                receiptContainer.getChildren().add(dishInfo);
            }
        }

        Label totalLabel = new Label("Общая стоимость заказа: " + totalCost + " руб.");

        receiptContainer.getChildren().add(totalLabel);

        Button closeButton = new Button("Закрыть");
        closeButton.setOnAction(event -> receiptStage.close());

        receiptContainer.getChildren().add(closeButton);

        Scene receiptScene = new Scene(receiptContainer, 300, 300);
        receiptStage.setScene(receiptScene);
        receiptStage.setTitle("Чек");
        receiptStage.showAndWait();
    }
}
