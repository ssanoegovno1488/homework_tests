package components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class FileUploader {
    public void uploadFile (String pathtofile) {
        $("#uploadPicture").uploadFile(new File(pathtofile));
    }
}
