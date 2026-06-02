import br.com.alura.screenmatch.models.Filme;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 1970, 180);
        filme1.exibeFichaTecnica();

        filme1.avalia(8);
        filme1.avalia(5);
        filme1.avalia(10);
        System.out.println("Total de avaliações: " + filme1.getTotalDeAvaliacoes());
        System.out.println(filme1.pegaMedia());
    }
}
