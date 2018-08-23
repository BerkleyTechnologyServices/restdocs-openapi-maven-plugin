package com.berkleytechnologyservices.restdocs.mojo;

import com.berkleytechnologyservices.restdocs.model.OpenApiModel;
import com.berkleytechnologyservices.restdocs.model.OpenApiParameter;
import com.berkleytechnologyservices.restdocs.model.OpenApiRequest;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OpenApiBuilderTest {

  private final OpenApiBuilder builder = new OpenApiBuilder();

  @Test
  public void testBuild() {
    OpenApiParameter parameter = new OpenApiParameter();
    parameter.setName("id");

    OpenApiRequest request = new OpenApiRequest();
    request.setHost("api.example.org");
    request.setBasePath("/api");
    request.setPath("/user/{id}");
    request.setHttpMethod("get");
    request.setPathParameters(Collections.singletonList(parameter));

    OpenApiModel model = new OpenApiModel();
    model.setRequest(request);

    OpenAPI openAPI = builder.request(request).build();
    assertThat(openAPI.getServers()).containsExactly(new Server().url("http://api.example.org/api"));
    assertThat(openAPI.getPaths().get("/user/{id}")).isNotNull().satisfies(pathItem -> {
      assertThat(pathItem.getGet().getParameters()).extracting(Parameter::getName).containsExactly("id");
    });
  }
}