package com.yang.file_server_adaptor.rest;

public class BuilderTest {

    private String id;

    private String name;

    private BuilderTest(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;

        private String name;

        public Builder() {
            super();
        }

        public Builder addId(String id) {
            this.id = id;
            return this;
        }

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
