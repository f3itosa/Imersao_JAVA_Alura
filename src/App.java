import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexao HTTP e buscar os top 250 filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // fazer uma conexao HTTP e buscar as top 250 series
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send (request, BodyHandlers.ofString());
        String body = response.body();
        

        // extrair so od dados de interessam (tirtulo, poster , classificacao)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());

        // exibir e manipular os dados
        //for (Map<String,String> filme : listaDeFilmes) 
        for (int i = 0; i < 3; i++ ) {
          Map<String,String> filme = listaDeFilmes.get(i);
          System.out.println("\u001b[1mTitulo:\u001b[m " + filme.get("title"));
          System.out.println("\u001b[1mURL da imagem:\u001b[m " + filme.get("image"));
          //System.out.println(filme.get("imDbRating"));
          //System.out.println();

          // classificacao
          double classificacao = Double.parseDouble(filme.get("imDbRating"));
          int numerosEstrelinhas = (int) classificacao;
          for (int n = 1; n<= numerosEstrelinhas; n++){
            System.out.print("⭐");
          }

          System.out.println("\n");
            
        }
    }
}
