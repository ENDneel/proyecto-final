package ec.edu.ups.projectgames.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public ResponseEntity<String> showOrderInfo() {
        return ResponseEntity.ok("FROM ORDER SERVICE, Port# is: " + port);
    }

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        return "Hello World";
    }
}
