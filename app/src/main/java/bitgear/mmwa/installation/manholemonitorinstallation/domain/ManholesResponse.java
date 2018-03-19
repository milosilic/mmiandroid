package bitgear.mmwa.installation.manholemonitorinstallation.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import bitgear.mmwa.installation.manholemonitorinstallation.model.Movie;


public class ManholesResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Manhole> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Manhole> getResults() {
        return results;
    }

    public void setResults(List<Manhole> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
