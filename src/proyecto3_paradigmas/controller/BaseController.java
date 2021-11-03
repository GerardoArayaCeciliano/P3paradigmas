/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3_paradigmas.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import proyecto3_paradigmas.model.Persona;
import proyecto3_paradigmas.util.PadronUtils;

/**
 *
 * @author Andres
 */
public class BaseController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField txt_cedula;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellidos;
    @FXML
    private DatePicker dp_fechaVecimiento;
    @FXML
    private TableView<Persona> tbl_personas;
    @FXML
    private TableColumn<Persona, String> cl_cedula;
    @FXML
    private TableColumn<Persona, String> cl_nombre;
    @FXML
    private TableColumn<Persona, String> cl_apellidos;
    @FXML
    private TableColumn<Persona, String> cl_provinica;
    @FXML
    
    
    private TableColumn<Persona, Void> cl_acciones;
    private ObservableList<Persona> listaTabla;
    private List<Persona> listaBase;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listaBase = PadronUtils.cargarPersonas(); // Aqui se carga lista base
        
        //Esta de aqui es la lista de la tabla (NO HACE FALTA usa setIntems())
        //es un puntero y ya está enlazado
        listaTabla = FXCollections.observableArrayList();
        prepararTabla();

        // TODO
    }

    private void prepararTabla() {
        activateResponsiveTable();
        tbl_personas.setItems(listaTabla);  //Lista de la tabla ahora es lista externa
        tbl_personas.setPlaceholder(new Label("Sin personas por mostrar"));

        cl_provinica.setCellValueFactory(x -> 
                new SimpleStringProperty(x.getValue().getProvincia()));
        cl_nombre.setCellValueFactory(x -> 
                new SimpleStringProperty(x.getValue().getProvincia()));
        cl_cedula.setCellValueFactory(x -> 
                new SimpleStringProperty(x.getValue().getProvincia()));
        cl_apellidos.setCellValueFactory(x -> 
                new SimpleStringProperty(x.getValue().getProvincia()));

        prepararAccionesDeTupla();
    }

    private void prepararAccionesDeTupla() {

        Callback<TableColumn<Persona, Void>, TableCell<Persona, Void>> 
                cellFactory = (final TableColumn<Persona, Void> param) -> {
            final TableCell<Persona, Void> cell = new TableCell<Persona, Void>() {

                private final Button btn = new Button("Buscar nombres iguales");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        //TODO
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        btn.setStyle("-fx-background-color:#388E3C; -fx-text-fill: whitesmoke;");
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        };

        cl_acciones.setCellFactory(cellFactory);

    }

    @FXML
    private void buscar(ActionEvent event) {
                                                //TODO BUSCAR
    }

    private void activateResponsiveTable() {
        cl_acciones.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(5));
        cl_apellidos.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(5));
        cl_cedula.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(5));
        cl_nombre.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(5));
        cl_provinica.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(5));
    }

}
