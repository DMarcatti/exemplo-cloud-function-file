package br.com.marcatti.service;

import br.com.marcatti.dto.FileDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
public class FileService {

    String msg = "";

    public String readFile(FileDto fileDto) throws IOException {
        log.info("readFile:: nome {} path {} ", fileDto.getNome(), fileDto.getPath());
        String line = "";
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(fileDto.getPath()), StandardCharsets.UTF_8);
            while ((line = reader.readLine()) != null) {
                log.info("line {}", line);
            }
            this.msg = "Leitura OK!";
        } catch (IOException e) {
            this.msg = String.format("Erro no processamento de leitura do arquivo nome %s path %s ", fileDto.getNome(), fileDto.getPath());
            log.error(msg);
        } finally {
            if (reader != null ) reader.close();
        }
        return this.msg;
   }
}
