package com.tit.greetingapp.DTO;

public class Greeting {
        private String message;

        public Greeting() {
            // No-args constructor for deserialization
        }

        public Greeting(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}
