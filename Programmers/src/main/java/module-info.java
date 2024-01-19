module com.example.programmers {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.programmers to javafx.fxml;
    exports com.example.programmers;
}