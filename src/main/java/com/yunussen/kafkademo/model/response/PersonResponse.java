package com.yunussen.kafkademo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonResponse {
    public enum  Status{
        SUCCES("BAŞARILI");
        private String message;

        private Status(String message){
            this.message=message;
        }

        public String getMessage() {
            return message;
        }
    };

    private String name;
    private Status status;
    private String result;
}

