package br.com.marcatti.handler;

import br.com.marcatti.dto.FileDto;
import br.com.marcatti.service.FileService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

//Function para AWS

public class FileHandler  implements RequestHandler<FileDto, String> {

    @Autowired
    FileService fileService;


    @Override
    public String handleRequest(FileDto fileDto, Context context) {
        String msg = "";
        try {
            msg = fileService.readFile(fileDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
