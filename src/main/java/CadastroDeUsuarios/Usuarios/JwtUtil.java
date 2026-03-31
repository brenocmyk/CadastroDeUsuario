package CadastroDeUsuarios.Usuarios;
import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
public class JwtUtil {
    private static final String SECRET = "minha chave super secreta que precisa ter 32 caracteres";
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
    public static String gerarToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }
}
