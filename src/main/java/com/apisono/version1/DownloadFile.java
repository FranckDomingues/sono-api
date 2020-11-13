package com.apisono.version1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DownloadFile {

    public static void main(String[] args) {
        SpringApplication.run(DownloadFile.class, args);
    }

}

/*@Controller
class HeartController {
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List>HeartZonesDTO(){
        return ResponseEntity.ok("");
    }
}
 */