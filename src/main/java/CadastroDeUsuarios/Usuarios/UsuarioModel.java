package CadastroDeUsuarios.Usuarios;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Cadastro_Usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String nome;
   private String email;
   private int idade;

    public UsuarioModel() {
    }
    @Getter
    @Setter
    private String password;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public UsuarioModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}
