package name.yohahn.bookstore.domain.repository;

import io.katharsis.errorhandling.ErrorData;
import io.katharsis.errorhandling.ErrorResponse;
import io.katharsis.errorhandling.mapper.ExceptionMapperProvider;
import io.katharsis.errorhandling.mapper.JsonApiExceptionMapper;
import io.katharsis.response.HttpStatus;

/**
 * Created by yohahn.kim on 10/27/15.
 */
@ExceptionMapperProvider
public class DefaultJsonApiExceptionMapper implements JsonApiExceptionMapper<RuntimeException> {
    @Override
    public ErrorResponse toErrorResponse(RuntimeException exception) {
        return ErrorResponse.builder()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR_500)
                .setSingleErrorData(ErrorData.builder()
                        .setTitle(exception.getMessage())
                        .setDetail(exception.getStackTrace().toString())
                        .build())
                .build();
    }
}
