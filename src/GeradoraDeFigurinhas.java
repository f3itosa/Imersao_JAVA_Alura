import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        // leitura imagem arquivo 
        //BufferedImage imagemOriginal = ImageIO.read(new File( "entrada/filme.png"));

        // leitura imagem URL opcoes de imagens
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.png"));
        //InputStream inputStream =  new URL("https://geekculture.co/wp-content/uploads/2019/10/Uncharted-Movie-1.jpeg").openStream();
        //InputStream inputStream =  new URL("https://1.bp.blogspot.com/-_uxSYoPteDI/Vn_UbFsownI/AAAAAAAABXk/cUn104dByoI/s1600/Uncharted.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        //int novaLargura = largura + 300;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem "em memoria"
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        // ajuste de fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 42 );
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever frase na nova imagem
        graphics.drawString("SENSACIONAL", 45, novaAltura - 100);

        // escrever nova imagem em arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
    //public static void main(String[] args) throws Exception {
       // var geradora = new GeradoraDeFigurinhas();
       // geradora.cria();
    //}
}
