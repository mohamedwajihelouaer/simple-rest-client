package com.jyx.rest.client.models;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RegisterForReflection
public class TvSerie {

    private Long id;
    private String name;
    private URL url;
    private String summary;
    private String language;
    private Set<String> genres;
    private URL officialSite;


}
