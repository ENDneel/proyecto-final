package ec.edu.ups.projectsecurity.rest;


import ec.edu.ups.projectsecurity.entity.User;
import ec.edu.ups.projectsecurity.entity.request.UserDTO;
import ec.edu.ups.projectsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/securities")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public ResponseEntity<String> showOrderInfo() {
        return ResponseEntity.ok("FROM ORDER SERVICE, Port# is: " + port);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.of(userRepository.findById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUserName(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());

        if(userDTO.getPassword().length()<7 || !userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}