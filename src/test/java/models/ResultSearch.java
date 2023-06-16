package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResultSearch {
    @JsonProperty("success")
    public int getSuccess() {
        return this.success; }
    public void setSuccess(int success) {
        this.success = success; }
    int success;
    @JsonProperty("results_html")
    public String getResults_html() {
        return this.results_html; }
    public void setResults_html(String results_html) {
        this.results_html = results_html; }
    String results_html;
    @JsonProperty("total_count")
    public int getTotal_count() {
        return this.total_count; }
    public void setTotal_count(int total_count) {
        this.total_count = total_count; }
    int total_count;
    @JsonProperty("start")
    public int getStart() {
        return this.start; }
    public void setStart(int start) {
        this.start = start; }
    int start;

 }