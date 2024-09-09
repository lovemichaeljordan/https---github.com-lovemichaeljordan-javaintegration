module lu.ics.se {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    exports lu.ics.se.models;
    opens lu.ics.se.models to com.google.gson;
    opens lu.ics.se to javafx.fxml;
    exports lu.ics.se;
}