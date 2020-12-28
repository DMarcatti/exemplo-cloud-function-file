package br.com.marcatti.functions;

import br.com.marcatti.dto.FileDto;
import br.com.marcatti.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.function.Function;

//Function Local

public class FileRead implements Function<FileDto, String> {

    @Autowired
    FileService fileService;

    @Override
    public String apply(FileDto fileDto) {
        String msg = "";
        try {
            msg = fileService.readFile(fileDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
