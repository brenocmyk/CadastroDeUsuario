package CadastroDeUsuarios.Usuarios;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario) {
        return service.salvar(usuario);
    }

    @GetMapping
    public List<UsuarioModel> listar() {
        return service.listar();
    }
    @GetMapping("/{id}")
    public UsuarioModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public UsuarioModel atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        return service.atualizar(id, usuario);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        UsuarioModel usuario = service.autenticar(dto.getEmail(), dto.getPassword());

        return JwtUtil.gerarToken(usuario.getEmail(), "USER");
    }

}