import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    // Construtor da classe Usuario
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Método para autenticar o usuário
    public boolean autenticarUsuario(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    // Método para listar permissões de um usuário (exemplo fictício)
    public List<String> listarPermissoes() {
        List<String> permissoes = new ArrayList<>();
        // Permissões fictícias apenas para exemplo
        permissoes.add("Visualizar Imóveis");
        permissoes.add("Cadastrar Imóveis");
        permissoes.add("Editar Proprietários");
        return permissoes;
    }

    // Método para buscar um usuário pelo nome (em uma lista de usuários)
    public static Usuario buscarUsuarioPorNome(String nome, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null; // Retorna null se não encontrar o usuário
    }

    // Getter para o nome do usuário
    public String getNome() {
        return nome;
    }

    // Setter para o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o email do usuário
    public String getEmail() {
        return email;
    }

    // Setter para o email do usuário
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter para a senha do usuário
    public String getSenha() {
        return senha;
    }

    // Setter para a senha do usuário
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para exibir os dados do usuário
    public void exibirDadosUsuario() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }
}
