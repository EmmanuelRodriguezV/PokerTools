package sample.Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.nashorn.internal.objects.annotations.Property;
import sample.Models.Connect;
import sample.Models.RowsCards;
import sample.Rules.OpenRaise;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ControllerTable implements Initializable {

    ObservableList<RowsCards> letras;
    @FXML
            TextField editBuscador;
    String cartaSeleccionada;
    @FXML
    ComboBox<String> comboposiciones;
    @FXML
    TableView <RowsCards>TableViewCartas ;
    @FXML
    TableColumn<RowsCards,String > c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13;
    /*
    * UTG,MP,CO,BTN,SB
    * */
    ObservableList<String>ObservableListlugares = FXCollections.observableArrayList("UTG","MP","CO","BTN","SB");
    public void onclickOpenraise()
    {
        try {
            if(cartaSeleccionada.contentEquals("") ){
                throw  new Exception();
            }
            OpenRaise openRaise = new OpenRaise();
            String mensaje=  openRaise.resolver(cartaSeleccionada,comboposiciones.getSelectionModel().getSelectedIndex() +1);
            Alert alert = new Alert(mensaje == "fold" ? Alert.AlertType.ERROR : Alert.AlertType.INFORMATION);
            alert.setHeaderText("Resultado obtenido");
            alert.setContentText(mensaje);
            //   alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(mensaje)));
            alert.showAndWait();
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Error de datos");
            alert.setContentText("verifica tus datos de entrada para poder operar \ncorrectamente");
            alert.showAndWait();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboposiciones.setItems(ObservableListlugares);
        cartaSeleccionada = "";
        Connect connect = new Connect();
        c1.setCellValueFactory(new PropertyValueFactory<>("c1"));
        c2.setCellValueFactory(new PropertyValueFactory<>("c2"));
        c3.setCellValueFactory(new PropertyValueFactory<>("c3"));
        c4.setCellValueFactory(new PropertyValueFactory<>("c4"));
        c5.setCellValueFactory(new PropertyValueFactory<>("c5"));
        c6.setCellValueFactory(new PropertyValueFactory<>("c6"));
        c7.setCellValueFactory(new PropertyValueFactory<>("c7"));
        c8.setCellValueFactory(new PropertyValueFactory<>("c8"));
        c9.setCellValueFactory(new PropertyValueFactory<>("c9"));
        c10.setCellValueFactory(new PropertyValueFactory<>("c10"));
        c11.setCellValueFactory(new PropertyValueFactory<>("c11"));
        c12.setCellValueFactory(new PropertyValueFactory<>("c12"));
        c13.setCellValueFactory(new PropertyValueFactory<>("c13"));
        letras = FXCollections.observableList(connect.selectAll());
        TableViewCartas.setItems(letras);



        TableViewCartas.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = TableViewCartas.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                cartaSeleccionada = val.toString();
                System.out.println("Selected Value" + val);
            }
        });
    }
    public  void  oninputChange() {
        if (editBuscador.getCharacters().toString().length() == 0) {
        }
        else
            {
                setupdates();
        }
    }
    void setupdates (){

        Pattern pattern = Pattern.compile("^" + editBuscador.getCharacters().toString().toUpperCase());
        c13.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c12.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c11.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c10.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c9.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c8.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c7.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c6.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c5.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c4.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c1.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c2.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:red");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });
        c3.setCellFactory(column -> {
            return new TableCell<RowsCards, String>() {
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : getString());
                    if (pattern.matcher(getString()).find())
                        setStyle("-fx-background-color:#ff0000");
                }
                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            };
        });

    }
    }

