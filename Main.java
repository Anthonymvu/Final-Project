package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, durationInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("NailsByJan");

        TableColumn<Customer, String> idColumn = new TableColumn<>("Customer ID");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Customer ID"));

        TableColumn<Customer, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setMinWidth(200);
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> durationColumn = new TableColumn<>("Duration");
        durationColumn.setMinWidth(100);
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Employee, String> employeeIDColumn = new TableColumn<>("Employee ID");
        employeeIDColumn.setMinWidth(100);
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("Employee ID"));

        TableColumn<Employee, String> employeeNameColumn = new TableColumn<>("Employee Name");
        employeeNameColumn.setMinWidth(100);
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("Employee Name"));

        TableColumn<Transaction, String> transactionIDColumn = new TableColumn<>("Transaction ID");
        transactionIDColumn.setMinWidth(100);
        transactionIDColumn.setCellValueFactory(new PropertyValueFactory<>("Transaction ID"));

        TableColumn<Transaction, String> transactionTotalColumn = new TableColumn<>("Transaction Total");
        transactionTotalColumn.setMinWidth(100);
        transactionTotalColumn.setCellValueFactory(new PropertyValueFactory<>("Transaction Total"));

        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");

        durationInput = new TextField();
        durationInput.setPromptText("Duration");

        durationInput = new TextField();
        durationInput.setPromptText("Duration");

        durationInput = new TextField();
        durationInput.setPromptText("Duration");

        durationInput = new TextField();
        durationInput.setPromptText("Duration");

        durationInput = new TextField();
        durationInput.setPromptText("Duration");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        addButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, durationInput, addButton, deleteButton);




        table= new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, durationColumn);

       VBox vBox = new VBox();
       vBox.getChildren().addAll();

       Scene scene = new Scene(vBox);
       window.setScene(scene);
       window.show();
    }

    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setDuration(Integer.parseInt(durationInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        durationInput.clear();

    }

    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }



    public ObservableList<Product> getProduct()
    {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Manicure", 15.00, 10));
        products.add(new Product("Pedicure", 15.00, 10));
        products.add(new Product("Filing", 5.00, 5));
        products.add(new Product("Massage", 30.00, 25));
        products.add(new Product("Facial", 20.00, 10));
        products.add(new Product("Waxxing", 20.00, 10));
        products.add(new Product("Shellac", 12.50, 10));
        products.add(new Product("Manicure+Pedicure", 25.00, 20));
        products.add(new Product("Massage+Facial", 40.00, 35));
        products.add(new Product("Massage+Waxxing", 40.00, 35));

        return products;
    }
    }


