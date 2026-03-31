package CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService service;

    public AuthController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public UsuarioModel login(@RequestBody LoginDTO dto) {
        return service.autenticar(dto.getEmail(), dto.getPassword());
    }
}