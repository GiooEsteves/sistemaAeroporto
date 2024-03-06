package passageiro;

import java.util.ArrayList;
import business.busca.Busca;
import business.exceptions.ObjetoNaoCadastradoException;

public class RepositorioPassageiro{
    ArrayList <Passageiro> passageiros = new ArrayList<Passageiro>();
    Passageiro passageiro = new Passageiro();

    public Passageiro inserirPassageiros(String nomePassageiro, String nascPassageiro, String cpfPassageiro){
        try{
            Passageiro passageiro = new Passageiro();
            passageiro.setPassageiro(nomePassageiro, nascPassageiro, cpfPassageiro);
            passageiros.add(passageiro);
            return passageiro;      
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void listarPassageiros() throws ObjetoNaoCadastradoException{ // LISTA TODOS OS PASSAGEIROS
        if(passageiros.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Passageiro p : passageiros){
            System.out.println(p.getDadosPassageiro());    
        }
    }

    public void atualizarPassageiro(String cpfPassado, String novoNome, String novaDtaNasc, String novoCPF){
         try{
            Passageiro passageiroParaAtualizar = Busca.matchPassageiro(passageiros, novoCPF);
            passageiro.setPassageiroAtualizado(passageiroParaAtualizar, novoNome, novaDtaNasc, novoCPF);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
