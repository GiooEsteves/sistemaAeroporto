package passageiro;

import java.util.ArrayList;
import business.exceptions.ObjetoNaoCadastradoException;
import business.exceptions.PassageiroInvalidoException;

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

    public Passageiro matchPassageiro(String cpf) throws PassageiroInvalidoException{
        for(Passageiro p : passageiros){
            if(p.getCPF().equals(cpf)){
                return p;
            }
        }
        throw new PassageiroInvalidoException();
    }

    public void atualizarPassageiro(String cpfPassado, String novoNome, String novaDtaNasc, String novoCPF){
         try{
            Passageiro passageiroParaAtualizar = matchPassageiro(cpfPassado);
            passageiro.setPassageiroAtualizado(passageiroParaAtualizar, novoNome, novaDtaNasc, novoCPF);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
