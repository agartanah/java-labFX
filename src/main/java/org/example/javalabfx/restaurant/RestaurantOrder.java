package org.example.javalabfx.restaurant;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    static final Button backButton = new Button("Назад");
    static final Button orderButton = new Button("Заказать");

    static final VBox dishesContainer = new VBox(10);
    static final VBox root = new VBox(20, backButton, dishesContainer, orderButton);

    public static void start(Stage stage, Stage prevStage) {
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

        orderButton.setOnAction(event -> {
            try {
                createOrder();
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Введите число!");
                alert.setHeaderText(null);
                alert.setContentText("Поле количества либо пустое, либо не является числом!");
                alert.showAndWait();

                return;
            }

            if (order.getPositions().isEmpty()) {
                return;
            }

            showReceipt();
        });

        backButton.setOnAction(actionEvent -> {
            stage.close();
            prevStage.show();
        });

        root.setAlignment(Pos.CENTER_LEFT);
        root.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(root, 700, 400);
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

    private static void createOrder() {
        for (int index = 0; index < dishes.size(); ++index) {
            if (dishCheckBoxes[index].isSelected()) {
                order.addPosition(dishes.get(index), Integer.parseInt(dishCountFields[index].getText()));
            }
        }
    }

    // Метод для отображения чека в модальном окне
    private static void showReceipt() {
        Stage receiptStage = new Stage();
        receiptStage.initModality(Modality.APPLICATION_MODAL);

        VBox receiptContainer = new VBox(10);

        for (Position pos : order.getPositions()) {
            Label positionInfo = new Label(pos.getDish().getTitle() + " — Количество: " + pos.getCount() + ", Итоговая стоимость: " + pos.getTotalPrice() + " руб.");
            receiptContainer.getChildren().add(positionInfo);
        }

        Label totalLabel = new Label("Общая стоимость заказа: " + order.getTotalPrice() + " руб.");

        receiptContainer.getChildren().add(totalLabel);

        Button closeButton = new Button("Закрыть");
        closeButton.setOnAction(event -> receiptStage.close());

        receiptContainer.getChildren().add(closeButton);

        Scene receiptScene = new Scene(receiptContainer, 500, 300);
        receiptStage.setScene(receiptScene);
        receiptStage.setTitle("Чек");
        receiptStage.showAndWait();
    }
}
