package com.melon.melontest.model;

import java.util.List;

public class Response {
    private boolean error;
    private List<Result> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
