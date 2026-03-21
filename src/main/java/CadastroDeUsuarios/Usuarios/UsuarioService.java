package CadastroDeUsuarios.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioModel salvar(UsuarioModel usuario) {
        return repository.save(usuario);
    }

    public List<UsuarioModel> listar() {
        return repository.findAll();
    }
    public UsuarioModel atualizar(Long id, UsuarioModel usuarioAtualizado) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setIdade(usuarioAtualizado.getIdade());

        return repository.save(usuario);
    }
    public void deletar(Long id) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        repository.delete(usuario);
    }
}