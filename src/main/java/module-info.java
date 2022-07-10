module com.example.calcvm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.calcvm to javafx.fxml;
    exports com.example.calcvm;
}