package com.berkleytechnologyservices.restdocs.spec;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiDetails {

  private static final String DEFAULT_NAME = "API Documentation";
  private static final String DEFAULT_VERSION = "1.0.0";
  private static final String DEFAULT_HOST = "localhost";
  private static final List<String> DEFAULT_SCHEMES = Collections.singletonList("http");
  private static final SpecificationFormat DEFAULT_FORMAT = SpecificationFormat.YAML;

  private String name;
  private String description;
  private String version;
  private String host;
  private String basePath;
  private List<Tag> tagDescriptions;
  private List<String> schemes;
  private SpecificationFormat format;
  private AuthConfig authConfig;

  public ApiDetails() {
    this.name = DEFAULT_NAME;
    this.description = null;
    this.version = DEFAULT_VERSION;
    this.host = DEFAULT_HOST;
    this.basePath = null;
    this.tagDescriptions = Collections.emptyList();
    this.schemes = DEFAULT_SCHEMES;
    this.format = DEFAULT_FORMAT;
    this.authConfig = new AuthConfig();
  }

  public String getName() {
    return name;
  }

  public ApiDetails name(String name) {
    this.name = name != null ? name : DEFAULT_NAME;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ApiDetails description(String description) {
    this.description = description;
    return this;
  }

  public String getVersion() {
    return version;
  }

  public ApiDetails version(String version) {
    this.version = version != null ? version : DEFAULT_VERSION;
    return this;
  }

  public String getHost() {
    return host;
  }

  public ApiDetails host(String host) {
    this.host = host != null ? host : DEFAULT_HOST;
    return this;
  }

  public String getBasePath() {
    return basePath;
  }

  public ApiDetails basePath(String basePath) {
    this.basePath = basePath;
    return this;
  }

  public Map<String, String> getTagDescriptions() {
    return tagDescriptions.stream()
        .collect(Collectors.toMap(Tag::getName, Tag::getDescription));
  }

  public ApiDetails tagDescriptions(List<Tag> tagDescriptions) {
    this.tagDescriptions = tagDescriptions != null ? Collections.unmodifiableList(tagDescriptions) : Collections.emptyList();
    return this;
  }

  public List<String> getSchemes() {
    return schemes;
  }

  public ApiDetails schemes(List<String> schemes) {
    this.schemes = schemes != null && !schemes.isEmpty() ? Collections.unmodifiableList(schemes) : DEFAULT_SCHEMES;
    return this;
  }

  public SpecificationFormat getFormat() {
    return format;
  }

  public ApiDetails format(SpecificationFormat format) {
    this.format = format != null ? format : DEFAULT_FORMAT;
    return this;
  }

  public AuthConfig getAuthConfig() {
    return this.authConfig;
  }

  public ApiDetails authConfig(AuthConfig authConfig) {
    this.authConfig = authConfig != null ? authConfig : new AuthConfig();
    return this;
  }
}
