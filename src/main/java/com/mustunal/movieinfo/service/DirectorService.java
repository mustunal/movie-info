package com.mustunal.movieinfo.service;

import com.mustunal.movieinfo.domain.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DirectorService {

    @Value("${DI_SERVICE_HOST}")
    private String diServiceHost;
    @Value("${DI_SERVICE_PORT}")
    private String diServicePort;

    public Director getDirectorById(long id){
        Director director = null;
        try {
            StringBuilder sbUrl = new StringBuilder("http://")
                    .append(diServiceHost).append(":").append(diServicePort)
                    .append("/api/v1/director-info");

            WebClient webClient = WebClient.builder()
                    .baseUrl(sbUrl.toString()).build();

            Mono<Director> directorMono = webClient.get()
                    .uri("/getDirectorById/" + id)
                    .retrieve()
                    .bodyToMono(Director.class);
            director = directorMono.block();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return director;
    }
}
