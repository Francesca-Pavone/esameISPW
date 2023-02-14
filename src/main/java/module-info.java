module com.ispw.esameispw {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.ispw.esameispw to javafx.fxml;
    exports com.ispw.esameispw;
}