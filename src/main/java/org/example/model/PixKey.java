package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.PixKeyType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PixKey {

    protected String pixKey;
    protected PixKeyType pixKeyType;

}
