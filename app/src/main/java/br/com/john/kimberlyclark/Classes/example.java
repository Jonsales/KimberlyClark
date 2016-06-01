package br.com.john.kimberlyclark.Classes;

/**
 * Created by Jonathan on 01/06/16.
 */
public class example {
        String id;
        String cod;
        String description;
        String image;
        String name;

        public example(String id, String cod, String description, String image, String name, String resource_uri, String value, String weight) {
            this.id = id;
            this.cod = cod;
            this.description = description;
            this.image = image;
            this.name = name;
            this.resource_uri = resource_uri;
            this.value = value;
            this.weight = weight;
        }

        String resource_uri;
        String value;

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResource_uri() {
            return resource_uri;
        }

        public void setResource_uri(String resource_uri) {
            this.resource_uri = resource_uri;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        String weight;

        public example(){

        }

}
