package dh.example.webservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 중복되는 코드 어노테이션으로 개선하기
 *
 * @Target(ElementType.PARAMETER) > 어노테이션이 생성될 위치 지정(파라미터로 선언되 객체에서만 사용가능)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
