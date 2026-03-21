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
    @PutMapping("/{id}")
    public UsuarioModel atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        return service.atualizar(id, usuario);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}