package ouvidoria;
/* Grupo:
Brendda Gaudêncio - 2213080040
Breno Tavares - 2113080049
Gabriel Nobrega - 2213080060
Jeneffer Farias - 2213080010 */



public class menu {
    public static void main(String[] args) {
        Manifestacao manifestacao = new Manifestacao();


        while (true) {
            System.out.println("***Ouvidoria Universidade ABC***");
            System.out.println("**************MENU**************");
            System.out.println();
            System.out.println();
            System.out.println("[ 1 ] Listar todas as manifestações");
            System.out.println("[ 2 ] Listar todas as sugestões");
            System.out.println("[ 3 ] Listar todas as reclamações");
            System.out.println("[ 4 ] Listar todos os elogios");
            System.out.println("[ 5 ] Enviar nova manifestação");
            System.out.println("[ 6 ] Pesquisar protocolo por número (ID)");
            System.out.println("[ 7 ] Sair");
            System.out.println("Digite sua opção: ");
            int opcao = Teclado.leInt();


            if (opcao == 1) { //[ 1 ] Listar todas as manifestações
                System.out.println("******TODAS AS MANIFESTAÇÕES******");
                System.out.println();
                for (Manifestacao m : manifestacao.getManifestacoes()) {
                    System.out.println(m);
                }
            } else if (opcao == 2) { //[ 2 ] Listar todas as sugestões
                System.out.println("********TODAS AS SUGESTÕES********");
                System.out.println();
                for (Manifestacao m : manifestacao.getManifestacoes()) {
                    if (m.getModelo() == "Sugestão") {
                        System.out.println(m);
                    }
                }
            } else if (opcao == 3) { //[ 3 ] Listar todas as reclamações
                System.out.println("*******TODAS AS RECLAMAÇÕES*******");
                System.out.println();
                for (Manifestacao m : manifestacao.getManifestacoes()) {
                    if (m.getModelo() == "Reclamação") {
                        System.out.println(m);
                    }
                }
            } else if (opcao == 4) { //[ 4 ] Listar todos os elogios
                System.out.println("*********TODAS OS ELOGIOS*********");
                System.out.println();
                for (Manifestacao m : manifestacao.getManifestacoes()) {
                    if (m.getModelo() == "Elogio") {
                        System.out.println(m);
                    }
                }
            } else if (opcao == 5) { //[ 5 ] Enviar nova manifestação

                while (true) {
                    System.out.println("Qual o tipo de manifestação deseja fazer?");
                    System.out.println("[ 1 ] Sugestão");
                    System.out.println("[ 2 ] Reclamação");
                    System.out.println("[ 3 ] Elogio");
                    System.out.println("[ 4 ] Voltar para o menu");
                    System.out.println("Digite a opção desejada: ");
                    int tipo = Teclado.leInt();

                    if (tipo == 4) { //Voltar para o menu
                        break;
                    } else if (tipo == 1 || tipo == 2 || tipo == 3) { //Inserir qualquer manifestação
                        System.out.println("Digite o número da manifestação:");
                        int numero = Teclado.leInt();
                        if (manifestacao.getManifestacaoPorNumero(numero) != null) {
                            System.out.println("Já existe uma manifestação com esse número");
                        } else {
                            System.out.println("Nome do requerente: ");
                            String nome = Teclado.leString();
                            System.out.println("Descrição: ");
                            String descricao = Teclado.leString();
                            String modelo;

                            System.out.println();
                            System.out.println("Manifestação inserida!");
                            System.out.println();
                            if (tipo == 1) {
                                modelo = "Sugestão";
                            } else if (tipo == 2) {
                                modelo = "Reclamação";
                            } else {
                                modelo = "Elogio";
                            }
                            Manifestacao nova = new Manifestacao(numero, nome, descricao, modelo);
                            manifestacao.novaManifestacao(nova);
                            break;
                        }
                    } else { //Valor Inválido
                        System.out.println("Valor Inválido!!");
                    }
                }
            } else if (opcao == 6) { //Pesquisar protocolo por número (ID)
                System.out.println("Digite o número do protocolo: ");
                int indice = Teclado.leInt();
                for (Manifestacao m : manifestacao.getManifestacoes()) {
                    if (manifestacao.getManifestacaoPorNumero(indice) == null) {
                        System.out.println("Não existe manifestação com esse protocolo!!");
                    } else {
                        if (indice == m.getNumero()) {
                            System.out.println(m);
                        }
                    }
                }
            } else if (opcao == 7) { //[ 7 ] Sair
                System.out.println("Até logo!!");
                break;
            } else {
                System.out.println("Opção inválida!!");
            }
        }
    }
}