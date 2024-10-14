package com.pzampi.biblioteca.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pzampi.biblioteca.models.Author;
import com.pzampi.biblioteca.models.Book;
import com.pzampi.biblioteca.models.Publisher;
import com.pzampi.biblioteca.repositories.AuthorRepository;
import com.pzampi.biblioteca.repositories.BookRepository;
import com.pzampi.biblioteca.repositories.PublisherRepository;
import com.pzampi.biblioteca.services.BookService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepositoy;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Publisher p1 = new Publisher(null, "Martin Claret", "rua tal, 150", "A publisher of books");

        publisherRepository.saveAll(Arrays.asList(p1));

        Author a1 = new Author(null, "Fiódor Dostoievski", "Russia", "Russo", LocalDate.parse("10/03/1870",fmt), LocalDate.parse("31/12/1910",fmt), "Era meio locão", p1);

        authorRepository.saveAll(Arrays.asList(a1));
    

        Book b1 = new Book(null, "Diario do Subsolo", LocalDate.parse("23/10/2019", fmt), a1,
        "É difícil ler o Diário do subsolo; é doloroso aceitá-lo. Com uma precisão quase clínica, Dostoiévski traça neste livro o perfil de uma pessoa que, marginalizada social e moralmente, procura vingar-se do mundo inteiro ao qual atribui a culpa de sua humilhação. “Sou um sujeito maldoso!” – reconhece o “homem do subsolo”, antecessor dos misantropos por opção do século XX, e sua maldade se volta, desenfreada, contra os inocentes e, muitas vezes, contra ele próprio. A rebelião existencial do indivíduo reduzido à condição de uma “reles mosca” dá início à minuciosa análise das questões cruciais de poder, justiça e liberdade, cujo frágil equilíbrio se reveste de especial importância em nossa época de revisão e contestação dos valores eternos. Abordando-as de modo lúcido e cortante, o gênio das letras russas deixa à humanidade seu aviso atemporal – Cuidado com o subsolo da alma, que suas portas estão sempre abertas!", p1);
        Book b2 = new Book(null, "Homem mais rico da babilonia", LocalDate.parse("20/10/1926", fmt),
                a1,
                "Baseando-se nos segredos de sucesso dos antigos babilônicos ― os habitantes da cidade mais rica e próspera de seu tempo ―, George S. Clason mostra soluções ao mesmo tempo sábias e muito atuais para evitar a falta de dinheiro, como não desperdiçar recursos durante tempos de opulência, buscar conhecimento e informação em vez de apenas lucro, assegurar uma renda para o futuro, manter a pontualidade no pagamento de dívidas e, sobretudo, cultivar as próprias aptidões, tornando-se cada vez mais habilidoso e consciente.", null);
// Book b3 = new Book(null, "UML 2 - Uma abordagem prática", LocalDate.parse("22/02/2018", fmt),
//         "Gilleanes T. A. Guedes",
//         "A UML - Unified Modeling Language ou Linguagem de Modelagem Unificada - é uma linguagem utilizada para modelar softwares baseados no paradigma de orientação a objetos, aplicada principalmente durante as fases de análise de requisitos e projeto de software. Essa linguagem consagrou-se como a linguagem-padrão de modelagem adotada internacionalmente pela indústria de Engenharia de Software, havendo um amplo mercado para profissionais que a dominem. Este livro procura ensinar ao leitor, por meio de exemplos práticos, como modelar softwares por meio da UML. A linguagem é ensinada mediante a apresentação de seus muitos diagramas, detalhando o propósito e a aplicação de cada um deles, bem como os elementos que os compõem, suas funções e como podem ser aplicados. A obra enfatiza ainda a importância da UML para a Engenharia de Software, além de abordar o paradigma de orientação a objetos, um conceito imprescindível para a compreensão correta da linguagem. Além disso, o livro demonstra também como mapear classes em tabelas de banco de dados relacionais, enfocando a questão de persistência. A obra contém diversos estudos de caso modelados como exemplos ao longo dos capítulos, além de um estudo de caso maior no final do livro, em que um sistema é analisado e modelado, com a ilustração completa de todos os diagramas referentes ao software.");

bookRepositoy.saveAll(Arrays.asList(b1,b2));

            }

}
