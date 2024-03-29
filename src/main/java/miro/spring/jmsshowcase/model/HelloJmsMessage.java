package miro.spring.jmsshowcase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloJmsMessage implements Serializable {

    static final long serialVersionUID = -4020695491444014100L;

    private UUID id;
    private String message;
}
