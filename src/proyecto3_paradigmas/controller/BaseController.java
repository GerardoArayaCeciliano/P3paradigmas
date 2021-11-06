/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3_paradigmas.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import proyecto3_paradigmas.model.Persona;
import proyecto3_paradigmas.util.Mensaje;
import proyecto3_paradigmas.util.PadronUtils;

/**
 * Esta clase se encarga de controlar los eventos dentro de la vista Base.fxml.
 *
 * @author Roberth
 * @author Gerardo
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
    private TableColumn<Persona, String> cl_fecha_vencimiento;
    @FXML
    private TableColumn<Persona, String> cl_estado_cedula;
    @FXML

    private ObservableList<Persona> listaTabla;
    private List<Persona> listaBase;
    @FXML
    private TextField txt_apellido2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listaBase = PadronUtils.cargarPersonas(); // Aqui se carga lista base

        //Esta de aqui es la lista de la tabla (NO HACE FALTA usa setIntems())
        //es un puntero y ya está enlazado
        listaTabla = FXCollections.observableArrayList();
        prepararTabla();

        // TODO
    }

    /**
     * Prepara la tabla para poder insertar datos tipo persona
     */
    private void prepararTabla() {
        activarResponsiveTable();
        tbl_personas.setItems(listaTabla);  //Lista de la tabla ahora es lista externa
        tbl_personas.setPlaceholder(new Label("Sin personas por mostrar"));

        cl_provinica.setCellValueFactory(x
                -> new SimpleStringProperty(x.getValue().getProvincia()));
        cl_nombre.setCellValueFactory(x
                -> new SimpleStringProperty(x.getValue().getNombre()));
        cl_cedula.setCellValueFactory(x
                -> new SimpleStringProperty(x.getValue().getCedula()));
        cl_apellidos.setCellValueFactory(x
                -> new SimpleStringProperty(x.getValue().getApellido1() + " "
                        + x.getValue().getApelido2()));
        cl_fecha_vencimiento.setCellValueFactory(x
                -> new SimpleStringProperty(x.getValue().getFechaVencimiento()));
        cl_estado_cedula.setCellValueFactory(x
                -> new SimpleStringProperty(x.getValue().getEstadoCedula()));

    }

    /**
     * Permite realizar la busqueda de busqueda mediante diferentes filtros
     *
     * @param event
     */
    @FXML
    private void buscar(ActionEvent event) {

        listaTabla.clear();
        listaTabla.addAll(listaBase.stream().filter(itm
                -> itm.getNombre().
                        contains(txt_nombre.getText().trim().toUpperCase())
                && itm.getApellido1().
                        contains(txt_apellidos.getText().trim().toUpperCase())
                && itm.getApelido2().
                        contains(txt_apellido2.getText().trim().toUpperCase())
                && itm.getCedula().toUpperCase().
                        contains(txt_cedula.getText().trim().toUpperCase())
                && itm.getFechaVencimiento().
                        contains((dp_fechaVecimiento.getValue() != null)
                                ? dp_fechaVecimiento.getValue().toString() : "")
        ).collect(Collectors.toList()));
    }
    /**
     * Permite hacer la tabla responsi
     */

    private void activarResponsiveTable() {
        cl_apellidos.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(6));
        cl_cedula.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(6));
        cl_nombre.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(6));
        cl_provinica.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(6));
        cl_fecha_vencimiento.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(6));
        cl_estado_cedula.prefWidthProperty().
                bind(tbl_personas.widthProperty().divide(6));

    }
    /**
     * Permite llamar al meto que realiza la busqueda de conincidencias 
     * @param event 
     */

    @FXML
    private void buscarConcidencias(ActionEvent event) {
        List<Persona> coincidencias = filtroListCoincidencias(listaBase);
        listaTabla.clear();
        Mensaje ms = new Mensaje();
        ms.showInformation("Cantidad de personas por concidencia"
                + ": " + coincidencias.size());
        listaTabla.addAll(coincidencias);
    }

    /**
     * retorna las persona que cumple con la condecia
     *
     * @param list resive la lista de personas
     * @return retorna la lista filtrada
     */
    private List<Persona> filtroListCoincidencias(List<Persona> list) {

        if (txt_nombre.getText().length() != 0 && txt_apellidos
                .getText().length() != 0
                && txt_apellido2.getText().length() != 0) {
            return list.stream().filter(x -> {
                return (txt_nombre.getText().toUpperCase().
                        equals(x.getNombre())
                        && (txt_apellidos.getText().toUpperCase()
                                .equals(x.getApellido1()))
                        && txt_apellido2.getText().toUpperCase().
                                equals(x.getApelido2()));
            }).collect(Collectors.toList());
        }
        if (txt_nombre.getText().length() != 0
                && txt_apellidos.getText().length() == 0
                && txt_apellido2.getText().length() == 0) {
            return list.stream().filter(x -> {
                return (txt_nombre.getText().toUpperCase().
                        equals(x.getNombre()));
            }).collect(Collectors.toList());
        }

        if (txt_nombre.getText().length() != 0
                && txt_apellidos.getText().length() != 0
                && txt_apellido2.getText().length() == 0) {
            return list.stream().filter(x -> {
                return (txt_nombre.getText().toUpperCase().
                        equals(x.getNombre())
                        && (txt_apellidos.getText().toUpperCase()
                                .equals(x.getApellido1())));
            }).collect(Collectors.toList());
        }
        if (txt_nombre.getText().length() != 0
                && txt_apellidos.getText().length() == 0
                && txt_apellido2.getText().length() != 0) {
            return list.stream().filter(x -> {
                return (txt_nombre.getText().toUpperCase().
                        equals(x.getNombre())
                        && txt_apellido2.getText()
                                .toUpperCase().equals(x.getApelido2()));
            }).collect(Collectors.toList());
        }
        if (txt_nombre.getText().length() == 0
                && txt_apellidos.getText().length() != 0
                && txt_apellido2.getText().length() != 0) {
            return list.stream().filter(x -> {
                return ((txt_apellidos.getText().toUpperCase()
                        .equals(x.getApellido1()))
                        && txt_apellido2.getText()
                                .toUpperCase().equals(x.getApelido2()));
            }).collect(Collectors.toList());
        }
         if (txt_nombre.getText().length() == 0
                && txt_apellidos.getText().length() != 0
                && txt_apellido2.getText().length() == 0) {
            return list.stream().filter(x -> {
                return ((txt_apellidos.getText().toUpperCase()
                        .equals(x.getApellido1())));
            }).collect(Collectors.toList());
        }
          if (txt_nombre.getText().length() == 0
                && txt_apellidos.getText().length()==0
                && txt_apellido2.getText().length() != 0) {
            return list.stream().filter(x -> {
                return ((txt_apellido2.getText().toUpperCase().equals(x.getApelido2())));
            }).collect(Collectors.toList());
        }
        return null;
    }

}
