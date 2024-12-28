package tusk9_10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.experimental.Accessors;

import java.util.UUID;

    @Entity
    @Table(name = "books")
    @Accessors(chain = true)
    public class BookEntity {

        @Id
        @Column(nullable = false, unique = true, name = "ID")
        private UUID ID;

        @Column(nullable = false, name = "title")
        private String title;

        @Column(nullable = true, name = "author")
        private String avtor;

        public UUID getID() {
            return ID;
        }

        public void setID(UUID ID) {
            this.ID = ID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAvtor() {
            return avtor;
        }

        public void setAvtor(String avtor) {
            this.avtor = avtor;
        }
    }