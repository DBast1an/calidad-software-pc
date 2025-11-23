module com.mycompany.calidad_software_pc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.calidad_software_pc to javafx.fxml;
    exports com.mycompany.calidad_software_pc;
}
