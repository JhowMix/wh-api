package br.com.wrhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayloadFileWrapper {
    private String base64;
    private String mimmeType;
}
