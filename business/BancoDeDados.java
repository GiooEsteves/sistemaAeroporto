package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class BancoDeDados{
    public static void dadosEmArquivos(String nomeArquivo, String dados){
        try (Writer writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(dados);
            System.out.println("Dados adicionados com sucesso no arquivo " + nomeArquivo);
        }catch (IOException e){
            System.out.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }

    public static void eliminarTodoConteudoDeArquivo(String nomeArquivo){           // NÃO ESTÁ DELETANDO
        try(FileOutputStream fos = new FileOutputStream(nomeArquivo, false)){
            fos.write(new byte[0]); // Escreve um array de bytes vazio.
            System.out.println("Conteúdo do arquivo " + nomeArquivo + " eliminado com sucesso.");
        }catch(IOException e){
            System.err.println("Erro ao eliminar conteúdo do arquivo " + e.getMessage());
        }
    }

    public static void eliminarDadosDeArquivo(String nomeArquivo, String dadosParaApagar){     // NÃO ESTÁ DELETANDO
        try(FileInputStream fis = new FileInputStream(nomeArquivo)){

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String chunk = new String(buffer, 0, bytesRead);

                // Remove os dados que você deseja apagar
                chunk = chunk.replace(dadosParaApagar, "");
            }

            System.out.println("Dados removidos com sucesso do arquivo.");
        
        }catch(IOException e){
            System.err.println("Erro ao apagar dados do arquivo: " + e.getMessage());
        }
    }

    public static void lerDadosDeArquivo(String nomeArquivo){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo)))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }catch(IOException e){
            System.err.println("Erro ao ler os dados do arquivo: " + e.getMessage());
        }
    }
}