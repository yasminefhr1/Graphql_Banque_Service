package com.example.Banque_Service.exception;

import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return GraphQLError.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.BAD_REQUEST)
                .location(new SourceLocation(1, 1)) // Optionnel : vous pouvez fournir des informations de localisation ici
                .build();
    }
}
