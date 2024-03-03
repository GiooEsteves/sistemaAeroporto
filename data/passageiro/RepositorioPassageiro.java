package passageiro;

import java.util.ArrayList;
import business.exceptions.DadosVaziosException;
import business.exceptions.ObjetoNaoCadastradoException;
import business.exceptions.PassageiroInvalidoException;

public class RepositorioPassageiro{
    ArrayList <Passageiro> passageiros = new ArrayList<Passageiro>();
    Passageiro passageiro = new Passageiro();

    public Passageiro inserirPassageiros(int numPassageiro, String nomePassageiro, String nascPassageiro, String cpfPassageiro) throws DadosVaziosException{
        if(numPassageiro <= 0){
            throw new DadosVaziosException("\nERRO: Número de passageiros inválido.");
        }

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

    public void listarPassageiros() throws ObjetoNaoCadastradoException{
        if(passageiros.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Passageiro p : passageiros){
            System.out.println(p.getDadosPassageiro());    
        }
    }

    public Passageiro matchPassageiro(String cpf) throws PassageiroInvalidoException{
        for(Passageiro p : passageiros){
            if(cpf == p.getCPF()){
                return p;
            }
        }
        throw new PassageiroInvalidoException();
    }

    public void atualizarPassageiro(String cpfPassado, String novoNome, String novaDtaNasc, String novoCPF){ // NÃO FUNCIONA
         try{
            Passageiro passageiroParaAtualizar = matchPassageiro(cpfPassado);
            passageiro.setPassageiroAtualizado(passageiroParaAtualizar, novoNome, novaDtaNasc, novoCPF);
        }catch(Exception e){
            System.err.println(e.getMessage()); // ERRO DE PASSAGEIRO INVÁLIDO
        }
    }
}
