package com.calvinnordstrom.cnmacro;

import com.calvinnordstrom.cnmacro.controller.MainController;
import com.calvinnordstrom.cnmacro.macro.MacroModel;
import com.calvinnordstrom.cnmacro.util.KeyListener;
import com.calvinnordstrom.cnmacro.util.MouseListener;
import com.calvinnordstrom.cnmacro.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main extends Application {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getPackageName());
    public static final String TITLE = "CalMacro";
    public static final String VERSION = "0.0";

    @Override
    public void start(Stage stage) {
        MacroModel model = new MacroModel();
        MainView view = new MainView();
        MainController controller = new MainController(model, view);

        Scene scene = new Scene(controller.getView(), 480, 270);
//        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("css/main.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle(TITLE + " " + VERSION);
        stage.show();

        try {
            Logger.getLogger(GlobalScreen.class.getPackageName()).setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(KeyListener.getInstance());
            GlobalScreen.addNativeMouseListener(MouseListener.getInstance());
        } catch (NativeHookException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        printLineCount();
    }

    @Override
    public void stop() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    private static void printLineCount() {
        Path rootDir = Paths.get("C:\\Users\\calno\\Desktop\\IntelliJ Projects\\CNMacro\\src\\main\\java\\com\\calvinnordstrom\\cnmacro");
        try (Stream<Path> paths = Files.walk(rootDir)) {
            long totalLines = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .mapToLong(Main::countLinesInFile)
                    .sum();
            System.out.println("Total lines in all .java files: " + totalLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long countLinesInFile(Path path) {
        long lineCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    public static void main(String[] args) {
        launch(args);
    }
}