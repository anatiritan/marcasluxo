package com.marcasluxo.config;

import com.marcasluxo.infrastructure.entitys.Marca;
import com.marcasluxo.infrastructure.repository.MarcaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final MarcaRepository marcaRepository;

    public DataLoader(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (marcaRepository.count() == 0) {
            List<Marca> marcasIniciais = List.of(
                    Marca.builder()
                            .nome("Chanel")
                            .paisOrigem("França")
                            .anoFundacao(1910)
                            .categoria("Alta Costura & Perfumaria")
                            .faturamentoBilhoes(19.7)
                            .descricao("Ícone mundial de elegância fundada por Gabrielle 'Coco' Chanel.")
                            .siteOficial("https://www.chanel.com")
                            .build(),
                    Marca.builder()
                            .nome("Louis Vuitton")
                            .paisOrigem("França")
                            .anoFundacao(1854)
                            .categoria("Artigos de Couro & Alta Moda")
                            .faturamentoBilhoes(22.5)
                            .descricao("Casa de moda de luxo famosa pelo monograma LV e suas clássicas malas de viagem.")
                            .siteOficial("https://www.louisvuitton.com")
                            .build(),
                    Marca.builder()
                            .nome("Gucci")
                            .paisOrigem("Itália")
                            .anoFundacao(1921)
                            .categoria("Alta Costura & Acessórios")
                            .faturamentoBilhoes(10.5)
                            .descricao("Grife italiana fundada em Florença, sinônimo de exuberância e inovação fashion.")
                            .siteOficial("https://www.gucci.com")
                            .build(),
                    Marca.builder()
                            .nome("Rolex")
                            .paisOrigem("Suíça")
                            .anoFundacao(1905)
                            .categoria("Alta Relojoaria")
                            .faturamentoBilhoes(10.1)
                            .descricao("Referência absoluta em cronômetros de luxo, precisão suíça e status atemporal.")
                            .siteOficial("https://www.rolex.com")
                            .build(),
                    Marca.builder()
                            .nome("Hermès")
                            .paisOrigem("França")
                            .anoFundacao(1837)
                            .categoria("Alta Costura & Selaria de Luxo")
                            .faturamentoBilhoes(15.0)
                            .descricao("Tradição artesanal suprema conhecida mundialmente pelas cobiçadas bolsas Birkin e Kelly.")
                            .siteOficial("https://www.hermes.com")
                            .build(),
                    Marca.builder()
                            .nome("Ferrari")
                            .paisOrigem("Itália")
                            .anoFundacao(1939)
                            .categoria("Automóveis Superesportivos")
                            .faturamentoBilhoes(6.4)
                            .descricao("Lendária montadora de Maranello, ícone supremo de velocidade, design e automobilismo.")
                            .siteOficial("https://www.ferrari.com")
                            .build(),
                    Marca.builder()
                            .nome("Cartier")
                            .paisOrigem("França")
                            .anoFundacao(1847)
                            .categoria("Alta Joalheria & Relojoaria")
                            .faturamentoBilhoes(8.2)
                            .descricao("Historicamente aclamada como 'o joalheiro dos reis e o rei dos joalheiros'.")
                            .siteOficial("https://www.cartier.com")
                            .build(),
                    Marca.builder()
                            .nome("Prada")
                            .paisOrigem("Itália")
                            .anoFundacao(1913)
                            .categoria("Moda Contemporânea & Luxo")
                            .faturamentoBilhoes(5.1)
                            .descricao("Marca milanesa famosa pelo minimalismo sofisticado, elegância vanguardista e nylon icônico.")
                            .siteOficial("https://www.prada.com")
                            .build()
            );

            marcaRepository.saveAll(marcasIniciais);
            System.out.println(">>> [DataLoader] 8 marcas de luxo iniciais foram carregadas com sucesso no H2 Database!");
        }
    }
}
