package business;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class BancoDeDados {
    public static void dadosEmArquivos(String nomeArquivo, String dados){
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(nomeArquivo), "UTF-8")){
            writer.write(dados);
            System.out.println("Dados salvos com sucesso no arquivo " + nomeArquivo);
        }catch(IOException e){
            System.out.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }

    public static void eliminarTodoConteudoDeArquivo(String nomeArquivo){
        try(FileOutputStream fos = new FileOutputStream(nomeArquivo, false)){
            // O segundo parâmetro (false) indica que o arquivo será sobrescrito sem adicionar ao final.
            fos.write(new byte[0]); // Escreve um array de bytes vazio.
            System.out.println("Conteúdo do arquivo " + nomeArquivo + " eliminado com sucesso.");
        }catch(IOException e){
            System.err.println("Erro ao eliminar conteúdo do arquivo " + e.getMessage());
        }
    }

    public static void eliminarDadosDeArquivo(String nomeArquivo, String dadosParaApagar){
        try(FileInputStream fis = new FileInputStream(nomeArquivo)){

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String chunk = new String(buffer, 0, bytesRead);

                // Remove os dados que você deseja apagar
                chunk = chunk.replace(dadosParaApagar, "");
                //fos.write(chunk.getBytes());
            }

            System.out.println("Dados removidos com sucesso do arquivo.");

        }catch(IOException e){
            System.err.println("Erro ao apagar dados do arquivo: " + e.getMessage());
        }
    }
}