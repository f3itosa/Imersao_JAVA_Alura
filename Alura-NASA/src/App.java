import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {

        // API Sping JAVA Json Aula 04 teste
        //String urlLinguagens = "http://localhost:8080/linguagens";


        // chama URL API.java
        API api = API.LINGUAGEM;

        String  url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();

         // Cria diretorio de figurinhasWhats
         var diretorio = new File("saida/");
         diretorio.mkdir();
      

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados 
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 2; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".jpg";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
