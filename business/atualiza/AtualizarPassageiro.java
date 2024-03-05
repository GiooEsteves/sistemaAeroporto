package business.atualiza;

import passageiro.RepositorioPassageiro;

public class AtualizarPassageiro{
    public static void atualizarPassageiro(RepositorioPassageiro repPassageiro, String cpfPassageiroAtualizar, String novoNome, String novaDtaNasc, String novoCPF){
        repPassageiro.atualizarPassageiro(cpfPassageiroAtualizar, novoNome, novaDtaNasc, novoCPF);
    }
}
