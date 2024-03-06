package business.busca;

import java.util.ArrayList;
import business.exceptions.AviaoInvalidoException;
import business.exceptions.FuncionarioInvalidoException;
import business.exceptions.PassageiroInvalidoException;
import business.exceptions.VooInvalidoException;
import business.exceptions.VooLotadoException;
import passageiro.Passageiro;
import aviao.Aviao;
import funcionario.Funcionario;
import voo.Voo;

public class Busca{
    public static Funcionario matchFuncionario(ArrayList<Funcionario> funcionarios, String funcCPF) throws FuncionarioInvalidoException{
        for(Funcionario f : funcionarios){
            if(f.getCPF().equals(funcCPF)){
                return f;
            }
        }
        throw new FuncionarioInvalidoException();     
    }

    public static Aviao matchAviao(ArrayList<Aviao> avioes, String aviaoNome) throws AviaoInvalidoException{
        for(Aviao a : avioes){
            if(a.getNome().equals(aviaoNome)){
                return a;
            }
        }
        throw new AviaoInvalidoException();     
    }

    public static Voo escolherVoo(ArrayList<Voo> voos, String dtaPassagemCompra, String nomeDestinoCompra) throws VooInvalidoException, VooLotadoException{
        for(Voo v : voos){     
            if(v.getData().equals(dtaPassagemCompra) && v.getDestino().equals(nomeDestinoCompra) && v.getCapacidade() >= (v.getABordo() + 1)){
                System.out.println(v.getPlaneInfo());
                return v;
            }else if(v.getNome().equals(dtaPassagemCompra) && v.getNome().equals(nomeDestinoCompra) && v.getCapacidade() < (v.getABordo() + 1)){
                throw new VooLotadoException("Há apenas " + (v.getCapacidade() - v.getABordo()) + " assento(s)");
            }
        }
        throw new VooInvalidoException();
    }

    public static Voo matchVoo(ArrayList<Voo> voos, String nomeVoo) throws VooInvalidoException{
        for(Voo v : voos){
            if(v.getNome().equals(nomeVoo)){
                return v;
            }
        }
        throw new VooInvalidoException();
    }

    public static Passageiro matchPassageiro(ArrayList<Passageiro> passageiros, String cpf) throws PassageiroInvalidoException{
        for(Passageiro p : passageiros){
            if(p.getCPF().equals(cpf)){
                return p;
            }
        }
        throw new PassageiroInvalidoException();
    }
}
