package net.schoolvery.schoolveryserver.domain.user.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Throwable {
    private BaseResponseStatus status; // BaseResponseStatus 객체 매핑
}
