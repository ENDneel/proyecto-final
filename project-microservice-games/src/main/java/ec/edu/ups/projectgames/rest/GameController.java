package ec.edu.ups.projectgames.rest;


import ec.edu.ups.projectgames.entitty.Category;
import ec.edu.ups.projectgames.entitty.Game;
import ec.edu.ups.projectgames.entitty.Platform;
import ec.edu.ups.projectgames.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;
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

    @PostMapping
    public List<Game> saveGames(){
        List<Category> categories = new ArrayList<>();
        List<Platform> platforms = new ArrayList<>();
        categories.add(Category.ADVENTURE);
        categories.add(Category.RPG);
        categories.add(Category.PUZZLE);
        platforms.add(Platform.PC);
        platforms.add(Platform.PLAYSTATION);
        platforms.add(Platform.ANDROID);
        Game game= new Game("juego1","123123123",3,categories,"+18",platforms,12,8.6,"PAY");
        Game game2= new Game("juego2","123123123",3,categories,"+18",platforms,9,5.6,"FREE");
        List<Game> games=new ArrayList<>();
        games.add(game);
        games.add(game2);
        gameRepository.save(game);
        gameRepository.save(game2);
        return gameRepository.findAll();
    }
    @GetMapping
    public List<Game> getAllGames(){
        System.out.println("LLega hasta aqui!!");
        return gameRepository.findAll();
    }


}
