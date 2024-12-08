package com.jyx.rest.client;

import com.jyx.rest.client.api.TvSerieServiceApi;
import com.jyx.rest.client.models.TvSerie;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TvSerieResourceTest {


    @InjectMock
    @RestClient
    TvSerieServiceApi testApi;

    @BeforeEach
    public void setUp() throws URISyntaxException, MalformedURLException {
        TvSerie tvSerie = TvSerie.builder()
                .id(1L)
                .name("MockSerie")
                .url(new URI("http://mock-serie.org").toURL())
                .summary("Mock Object to test the client")
                .language("english")
                .genres(Set.of("Test1", "Test2"))
                .officialSite(new URI("http://mock-serie.org").toURL())
                .build();

        when(testApi.getSeriesByTitle("MockSerie")).thenReturn(tvSerie);
    }


    @Test
    void getSerie()  {
        TvSerie result = testApi.getSeriesByTitle("MockSerie");
        Assertions.assertEquals("english", result.getLanguage());
    }
}