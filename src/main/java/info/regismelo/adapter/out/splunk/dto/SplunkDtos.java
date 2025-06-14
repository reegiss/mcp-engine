package info.regismelo.adapter.out.splunk.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

// DTOs para as respostas da API do Splunk
public class SplunkDtos {
    public record SplunkSearchJobResponse(String sid) {}
    public record SplunkJobStatusResponse(Entry entry) {
        public record Entry(Content content) {}
        public record Content(@JsonProperty("dispatchState") String dispatchState) {}
    }
    public record SplunkSearchResponse(List<Map<String, String>> results) {}
}
