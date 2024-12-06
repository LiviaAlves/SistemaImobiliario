import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Listas para armazenar os objetos do sistema
        List<Usuario> usuarios = new ArrayList<>();
        List<Imovel> imoveis = new ArrayList<>();
        List<Proprietario> proprietarios = new ArrayList<>();
        List<Matricula> matriculas = new ArrayList<>();

        // Criando um usuário administrador inicial
        usuarios.add(new Usuario("Admin", "admin@gmail.com", "admin123"));

        Usuario usuarioLogado = null; // Variável para armazenar o estado do usuário logado

        System.out.println("===== Bem-vindo ao Sistema de Gestão de Imóveis =====");

        while (true) {
            // Menu dinâmico baseado no estado do login
            if (usuarioLogado == null) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Login");
                System.out.println("2 - Cadastrar Usuário");
                System.out.println("3 - Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite seu email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite sua senha: ");
                        String senha = scanner.nextLine();

                        for (Usuario usuario : usuarios) {
                            if (usuario.autenticarUsuario(email, senha)) {
                                usuarioLogado = usuario;
                                break;
                            }
                        }

                        if (usuarioLogado != null) {
                            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                        } else {
                            System.out.println("Credenciais inválidas! Tente novamente.");
                        }
                    }
                    case 2 -> {
                        System.out.print("Digite seu nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite seu email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite sua senha: ");
                        String senha = scanner.nextLine();

                        usuarios.add(new Usuario(nome, email, senha));
                        System.out.println("Usuário cadastrado com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("Saindo do sistema. Até logo!");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                // Menu após login
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Cadastrar Imóvel");
                System.out.println("2 - Listar Imóveis");
                System.out.println("3 - Associar Proprietário a um Imóvel");
                System.out.println("4 - Alterar Atributos do Imóvel");
                System.out.println("5 - Consultar Matrícula");
                System.out.println("6 - Logout");
                System.out.println("7 - Sair");

                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o endereço do imóvel: ");
                        String endereco = scanner.nextLine();
                        System.out.print("Digite a área do imóvel (em m²): ");
                        double area = scanner.nextDouble();
                        System.out.print("Digite o valor cadastral do imóvel: ");
                        double valorCadastral = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner
                        System.out.print("Digite o número da matrícula: ");
                        String numeroMatricula = scanner.nextLine();
                        System.out.print("Digite o tipo do imóvel: ");
                        String tipo = scanner.nextLine();
                        System.out.print("Digite uma descrição do imóvel: ");
                        String descricao = scanner.nextLine();

                        Imovel novoImovel = new Imovel(endereco, area, valorCadastral, numeroMatricula, tipo, descricao);
                        imoveis.add(novoImovel);

                        Matricula novaMatricula = new Matricula("Imóvel registrado no sistema", "2024-11-21", numeroMatricula);
                        matriculas.add(novaMatricula);

                        System.out.println("Imóvel cadastrado com sucesso!");
                    }
                    case 2 -> {
                        if (imoveis.isEmpty()) {
                            System.out.println("Nenhum imóvel cadastrado.");
                        } else {
                            System.out.println("Imóveis cadastrados:");
                            for (Imovel imovel : imoveis) {
                                imovel.exibirDadosImovel();
                            }
                        }
                    }
                    case 3 -> {
                        if (imoveis.isEmpty()) {
                            System.out.println("Nenhum imóvel disponível para associação.");
                        } else {
                            System.out.print("Digite o nome do proprietário: ");
                            String nomeProprietario = scanner.nextLine();
                            System.out.print("Digite o CPF do proprietário: ");
                            String cpfProprietario = scanner.nextLine();

                            Proprietario novoProprietario = new Proprietario(nomeProprietario, cpfProprietario);
                            proprietarios.add(novoProprietario);

                            System.out.println("Selecione um imóvel para associar o proprietário:");
                            for (int i = 0; i < imoveis.size(); i++) {
                                System.out.println((i + 1) + " - " + imoveis.get(i).getEndereco());
                            }

                            System.out.print("Escolha o número do imóvel: ");
                            int escolhaImovel = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer do scanner

                            if (escolhaImovel > 0 && escolhaImovel <= imoveis.size()) {
                                Imovel imovelSelecionado = imoveis.get(escolhaImovel - 1);
                                imovelSelecionado.registrarObservador(novoProprietario);
                                System.out.println("Proprietário associado ao imóvel com sucesso!");
                            } else {
                                System.out.println("Opção inválida.");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite o número da matrícula para consulta: ");
                        String numeroMatriculaConsulta = scanner.nextLine();

                        Matricula matriculaEncontrada = null;
                        Imovel imovelAssociado = null;

                        for (Matricula matricula : matriculas) {
                            if (matricula.getNumeroMatricula().equals(numeroMatriculaConsulta)) {
                                matriculaEncontrada = matricula;

                                for (Imovel imovel : imoveis) {
                                    if (imovel.getNumeroMatricula().equals(numeroMatriculaConsulta)) {
                                        imovelAssociado = imovel;
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                        if (matriculaEncontrada != null) {
                            matriculaEncontrada.exibirDetalhesMatricula();

                            if (imovelAssociado != null) {
                                System.out.println("\nInformações do imóvel associado:");
                                imovelAssociado.exibirDadosImovel();

                                List<ProprietarioObserver> observadores = imovelAssociado.getObservadores();
                                List<Proprietario> proprietariosImovel = observadores.stream()
                                        .map(obs -> (Proprietario) obs)
                                        .collect(Collectors.toList());

                                if (proprietariosImovel.isEmpty()) {
                                    System.out.println("Nenhum proprietário associado.");
                                } else {
                                    System.out.println("Proprietário(s):");
                                    for (Proprietario proprietario : proprietariosImovel) {
                                        System.out.println("- Nome: " + proprietario.getNome());
                                        System.out.println("  CPF: " + proprietario.getCpf());
                                    }
                                }
                            } else {
                                System.out.println("Nenhum imóvel associado a esta matrícula.");
                            }
                        } else {
                            System.out.println("Matrícula não encontrada.");
                        }
                    }
                }
            }
        }
    }
}
